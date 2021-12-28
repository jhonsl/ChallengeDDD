package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.fabricación.commands.AgregarCarro;
import co.com.softka.challengeddd.fabricación.events.CarroAgregado;
import co.com.softka.challengeddd.fabricación.events.FabricacionCreada;
import co.com.softka.challengeddd.fabricación.values.*;
import co.com.softka.usecase.fabricacion.AgregarCarroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarCarroTest {

    @Mock
    DomainEventRepository repository;

    private List<DomainEvent> events(){
        return List.of(new FabricacionCreada(
                new Modelo("chevrolet"),
                new Presupuesto(200000000L)
        ));
    }

    @Test
    void agregarCarro(){

        //arrange
        IdFabricacion idFabricacion = IdFabricacion.of("bebebe");
        IdCarro idCarro = IdCarro.of("cecece");
        Precio precio = new Precio(100000000);
        CantidadDeLLantas cantidadDeLLantas = new CantidadDeLLantas(4);
        CantidadDeAsientos cantidadDeAsientos = new CantidadDeAsientos(5);
        var command = new AgregarCarro(idFabricacion, idCarro, precio, cantidadDeLLantas, cantidadDeAsientos);
        var usecase = new AgregarCarroUseCase();

        //act
        when(repository.getEventsBy("bebebe")).thenReturn(events());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idFabricacion.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CarroAgregado)events.get(0);

        //asserts
        Assertions.assertEquals("cecece", event.getIdCarro().value());
        Assertions.assertEquals(100000000, event.getPrecio().value());
        Assertions.assertEquals(4, event.getCantidadDeLLantas().value());
        Assertions.assertEquals(5, event.getCantidadDeAsientos().value());

        Mockito.verify(repository).getEventsBy("bebebe");
    }
}
