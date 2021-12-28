package co.com.softka.challengeddd.jefe.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.jefe.values.IdEmpleado;
import co.com.softka.challengeddd.jefe.values.IdJefe;

public class EliminarEmpleado extends Command {

    private final IdJefe idJefe;
    private final IdEmpleado idEmpleado;

    public EliminarEmpleado(IdJefe idJefe, IdEmpleado idEmpleado) {
        this.idJefe = idJefe;
        this.idEmpleado = idEmpleado;
    }

    public IdJefe getIdJefe() {
        return idJefe;
    }

    public IdEmpleado getIdEmpleado() {
        return idEmpleado;
    }
}