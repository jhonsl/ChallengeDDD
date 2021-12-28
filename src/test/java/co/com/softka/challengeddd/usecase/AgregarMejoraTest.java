package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.objetivo.commands.AgregarMejora;
import co.com.softka.challengeddd.objetivo.events.FuncionalidadAgregada;
import co.com.softka.challengeddd.objetivo.events.MejoraAgregada;
import co.com.softka.challengeddd.objetivo.events.ObjetivoCreado;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdMejora;
import co.com.softka.challengeddd.objetivo.values.IdObjetivo;
import co.com.softka.challengeddd.objetivo.values.NuevaCaracteristica;
import co.com.softka.usecase.objetivo.AgregarMejoraUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarMejoraTest {

    @Mock
    DomainEventRepository repository;

    private List<DomainEvent> events(){
        return List.of(new ObjetivoCreado(
                new Descripcion("Fabricar vehiculos mas rapidos")
        ));
    }

    @Test
    void agregarMejora(){

        //arrange
        IdObjetivo idObjetivo = IdObjetivo.of("tatata");
        IdMejora idMejora = IdMejora.of("wawawa");
        Descripcion descripcion = new Descripcion("Mejora en la optimizacion del motor");
        Set<NuevaCaracteristica> nuevasCaracteristicas = Set.of(
                new NuevaCaracteristica("Mayor velocidad"),
                new NuevaCaracteristica("Menor consumo de gasolina"),
                new NuevaCaracteristica("Mas econocimo")
        );
        var command = new AgregarMejora(idObjetivo, idMejora, descripcion, nuevasCaracteristicas);
        var usecase = new AgregarMejoraUseCase();

        //act
        when(repository.getEventsBy("tatata")).thenReturn(events());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idObjetivo.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (MejoraAgregada)events.get(0);

        //assert
        Assertions.assertEquals("wawawa", event.getIdMejora().value());
        Assertions.assertEquals("Mejora en la optimizacion del motor", event.getDescripcion().value());
        Assertions.assertEquals(Set.of(
                    new NuevaCaracteristica("Mayor velocidad"),
                    new NuevaCaracteristica("Menor consumo de gasolina"),
                    new NuevaCaracteristica("Mas econocimo")
                    ), event.getNuevasCaracteristicas());

        Mockito.verify(repository).getEventsBy("tatata");
    }
}
