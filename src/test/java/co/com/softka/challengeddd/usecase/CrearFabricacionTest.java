package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.softka.challengeddd.fabricación.commands.CrearFabricacion;
import co.com.softka.challengeddd.fabricación.events.FabricacionCreada;
import co.com.softka.challengeddd.fabricación.values.IdFabricacion;
import co.com.softka.challengeddd.fabricación.values.Modelo;
import co.com.softka.challengeddd.fabricación.values.Presupuesto;
import co.com.softka.usecase.fabricacion.CrearFabricacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrearFabricacionTest {

    @Test
    public void crearFabricacion(){

        //arrange
        IdFabricacion idFabricacion = IdFabricacion.of("yyyyy");
        Modelo modelo = new Modelo("Susuki");
        Presupuesto presupuesto = new Presupuesto(20000000L);
        var command = new CrearFabricacion(idFabricacion, modelo, presupuesto);
        var usecase = new CrearFabricacionUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        FabricacionCreada event = (FabricacionCreada)events.getDomainEvents().get(0);
        Assertions.assertEquals("yyyyy", event.aggregateRootId());
        Assertions.assertEquals("Susuki", event.getModelo().value());
        Assertions.assertEquals(20000000L, event.getPresupuesto().value());
    }
}
