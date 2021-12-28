package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.objetivo.Funcionalidad;
import co.com.softka.challengeddd.objetivo.commands.AgregarFuncionalidad;
import co.com.softka.challengeddd.objetivo.events.FuncionalidadAgregada;
import co.com.softka.challengeddd.objetivo.events.ObjetivoCreado;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdFuncionalidad;
import co.com.softka.challengeddd.objetivo.values.IdObjetivo;
import co.com.softka.usecase.objetivo.AgregarFuncionalidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarFuncionalidadTest {

    @Mock
    DomainEventRepository repository;

    private List<DomainEvent> events(){
        return List.of(new ObjetivoCreado(
                new Descripcion("Terminar el trabajo en 1 mes")
        ));
    }

    @Test
    void agregarFuncionalidad(){

        //arrange
        IdObjetivo idObjetivo = IdObjetivo.of("mamama");
        IdFuncionalidad idFuncionalidad = IdFuncionalidad.of("papapa");
        Descripcion descripcion = new Descripcion("Tener mayores resultados en menor tiempo");
        var command = new AgregarFuncionalidad(idObjetivo, idFuncionalidad, descripcion);
        var usecase = new AgregarFuncionalidadUseCase();

        //act
        when(repository.getEventsBy("mamama")).thenReturn(events());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idObjetivo.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (FuncionalidadAgregada)events.get(0);

        //asserts
        Assertions.assertEquals("papapa", event.getIdFuncionalidad().value());
        Assertions.assertEquals("Tener mayores resultados en menor tiempo", event.getDescripcion().value());

        Mockito.verify(repository).getEventsBy("mamama");
    }
}
