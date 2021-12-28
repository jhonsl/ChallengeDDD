package co.com.softka.challengeddd.jefe.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.jefe.values.IdEmpleado;

public class EmpleadoEliminado extends DomainEvent {

    private final IdEmpleado idEmpleado;

    public EmpleadoEliminado(IdEmpleado entityId) {
        super("Softka.jefe.empleadoEliminado");
        this.idEmpleado = entityId;
    }

    public IdEmpleado getIdEmpleado() {
        return idEmpleado;
    }
}
