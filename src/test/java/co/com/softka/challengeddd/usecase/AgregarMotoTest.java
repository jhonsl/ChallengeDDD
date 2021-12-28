package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.fabricación.commands.AgregarMoto;
import co.com.softka.challengeddd.fabricación.events.FabricacionCreada;
import co.com.softka.challengeddd.fabricación.events.MotoAgregada;
import co.com.softka.challengeddd.fabricación.values.*;
import co.com.softka.challengeddd.jefe.events.JefeCreado;
import co.com.softka.challengeddd.jefe.values.Edad;
import co.com.softka.challengeddd.jefe.values.Nombre;
import co.com.softka.usecase.fabricacion.AgregarMotoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarMotoTest {

    @Mock
    DomainEventRepository repository;

    private List<DomainEvent> events(){
        return List.of(new FabricacionCreada(
                new Modelo("Yamaha"),
                new Presupuesto(80000000L)
        ));
    }

    @Test
    void agregarMoto(){

        //arrange
        IdFabricacion idFabricacion = IdFabricacion.of("lalala");
        IdMoto idMoto = IdMoto.of("abcd");
        Cilindraje cilindraje = new Cilindraje(125);
        Precio precio = new Precio(20000000);
        var command = new AgregarMoto(idFabricacion, idMoto, cilindraje, precio);
        var usecase = new AgregarMotoUseCase();

        //act
        when(repository.getEventsBy("lalala")).thenReturn(events());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idFabricacion.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (MotoAgregada)events.get(0);

        //asserts
        Assertions.assertEquals("abcd", event.getIdMoto().value());
        Assertions.assertEquals(125, event.getCilindraje().value());
        Assertions.assertEquals(20000000, event.getPrecio().value());

        Mockito.verify(repository).getEventsBy("lalala");
    }
}
