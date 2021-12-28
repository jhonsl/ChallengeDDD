package co.com.softka.challengeddd.jefe.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.jefe.values.*;

public class AgregarEmpleado extends Command {

    private final IdJefe idJefe;
    private final IdEmpleado idEmpleado;
    private final Nombre nombre;
    private final Edad edad;
    private final Salario salario;

    public AgregarEmpleado(IdJefe idJefe, IdEmpleado idEmpleado, Nombre nombre, Edad edad, Salario salario) {
        this.idJefe = idJefe;
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public IdJefe getIdJefe() {
        return idJefe;
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
