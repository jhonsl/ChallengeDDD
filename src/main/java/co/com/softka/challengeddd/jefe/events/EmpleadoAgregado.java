package co.com.softka.challengeddd.jefe.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.jefe.values.Edad;
import co.com.softka.challengeddd.jefe.values.IdEmpleado;
import co.com.softka.challengeddd.jefe.values.Nombre;
import co.com.softka.challengeddd.jefe.values.Salario;


public class EmpleadoAgregado extends DomainEvent {

    private final IdEmpleado idEmpleado;
    private final Nombre nombre;
    private final Edad edad;
    private final Salario salario;

    public EmpleadoAgregado(IdEmpleado entityId, Nombre nombre, Edad edad, Salario salario) {
        super("Softka.jefe.tareaAgregada");
        this.idEmpleado = entityId;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public IdEmpleado getIdEmpleado() {
        return idEmpleado;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }

    public Salario getSalario() {
        return salario;
    }
}
