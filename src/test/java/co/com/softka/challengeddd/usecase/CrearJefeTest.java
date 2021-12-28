package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.softka.challengeddd.jefe.commands.CrearJefe;
import co.com.softka.challengeddd.jefe.events.JefeCreado;
import co.com.softka.challengeddd.jefe.values.Edad;
import co.com.softka.challengeddd.jefe.values.IdJefe;
import co.com.softka.challengeddd.jefe.values.Nombre;
import co.com.softka.usecase.jefe.CrearJefeUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrearJefeTest {

    @Test
    public void crearJefe(){

        //arrange
        IdJefe idJefe = IdJefe.of("xxxxx");
        Nombre nombre = new Nombre("pepe");
        Edad edad = new Edad(40);
        var command = new CrearJefe(idJefe, nombre, edad);
        var usecase = new CrearJefeUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        JefeCreado event = (JefeCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxxx", event.aggregateRootId());
        Assertions.assertEquals("pepe", event.getNombre().value());
        Assertions.assertEquals(40, event.getEdad().value());
    }
}
