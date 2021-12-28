package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.fabricación.commands.AgregarAvion;
import co.com.softka.challengeddd.fabricación.events.AvionAgregado;
import co.com.softka.challengeddd.fabricación.events.FabricacionCreada;
import co.com.softka.challengeddd.fabricación.values.*;
import co.com.softka.usecase.fabricacion.AgregarAvionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarAvionTest {

    @Mock
    DomainEventRepository repository;

    private List<DomainEvent> events(){
        return List.of(new FabricacionCreada(
                new Modelo("BMW"),
                new Presupuesto(100000000L)
        ));
    }

    @Test
    void agregarAvion(){

        //arrange
        IdFabricacion idFabricacion = IdFabricacion.of("QQQQQ");
        IdAvion idAvion = IdAvion.of("xxxx");
        Precio precio = new Precio(80000000);
        CantidadDeAsientos cantidadDeAsientos = new CantidadDeAsientos(80);
        var command = new AgregarAvion(idFabricacion, idAvion, precio, cantidadDeAsientos);
        var usecase = new AgregarAvionUseCase();

        //act
        when(repository.getEventsBy("QQQQQ")).thenReturn(events());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idAvion.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AvionAgregado)events.get(0);

        //assertions
        Assertions.assertEquals("xxxx", event.getIdAvion().value());
        Assertions.assertEquals(80000000, event.getPrecio().value());
        Assertions.assertEquals(80, event.getCantidadDeAsientos().value());

        Mockito.verify(repository).getEventsBy("QQQQQ");
    }
}
