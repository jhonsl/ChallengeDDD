package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.softka.challengeddd.objetivo.commands.CrearObjetivo;
import co.com.softka.challengeddd.objetivo.events.ObjetivoCreado;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdObjetivo;
import co.com.softka.usecase.objetivo.CrearObjetivoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrearObjetivoTest {

    @Test
    public void crearObjetivo(){

        //arrange
        IdObjetivo idObjetivo = IdObjetivo.of("AAA");
        Descripcion descripcion = new Descripcion("El objetivo de esta fabricacion es aumentas las ventas");
        var command = new CrearObjetivo(idObjetivo, descripcion);
        var usecase = new CrearObjetivoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        ObjetivoCreado event = (ObjetivoCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("AAA", event.aggregateRootId());
        Assertions.assertEquals("El objetivo de esta fabricacion es aumentas las ventas", event.getDescripcion().value());
    }
}
