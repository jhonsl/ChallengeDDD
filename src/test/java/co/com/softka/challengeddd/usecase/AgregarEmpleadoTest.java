package co.com.softka.challengeddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.jefe.commands.AgregarEmpleado;
import co.com.softka.challengeddd.jefe.events.EmpleadoAgregado;
import co.com.softka.challengeddd.jefe.events.JefeCreado;
import co.com.softka.challengeddd.jefe.values.*;
import co.com.softka.usecase.jefe.AgregarEmpleadoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarEmpleadoTest {

    @Mock
    DomainEventRepository repository;

    private List<DomainEvent> events(){
        return List.of(new JefeCreado(
                new Nombre("roberto"),
                new Edad(40)
        ));
    }

    @Test
    void agregarEmpleado(){

        //arrange
        IdJefe idJefe = IdJefe.of("BBBB");
        IdEmpleado idEmpleado = IdEmpleado.of("xxxx");
        Nombre nombre = new Nombre("juan");
        Edad edad = new Edad(30);
        Salario salario = new Salario(1000000);
        var command = new AgregarEmpleado(idJefe, idEmpleado, nombre, edad, salario);
        var usecase = new AgregarEmpleadoUseCase();

        //act
        when(repository.getEventsBy("BBBB")).thenReturn(events());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idJefe.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EmpleadoAgregado)events.get(0);

        //assertions
        Assertions.assertEquals("xxxx", event.getIdEmpleado().value());
        Assertions.assertEquals("juan", event.getNombre().value());
        Assertions.assertEquals(30, event.getEdad().value());
        Assertions.assertEquals(1000000, event.getSalario().value());

        Mockito.verify(repository).getEventsBy("BBBB");
    }
}
