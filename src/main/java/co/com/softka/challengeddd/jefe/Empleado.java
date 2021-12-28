package co.com.softka.challengeddd.jefe;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.jefe.values.Edad;
import co.com.softka.challengeddd.jefe.values.IdEmpleado;
import co.com.softka.challengeddd.jefe.values.Nombre;
import co.com.softka.challengeddd.jefe.values.Salario;

public class Empleado extends Entity<IdEmpleado> {

    protected Nombre nombre;
    protected Edad edad;
    protected Salario salario;

    public Empleado(IdEmpleado entityId, Nombre nombre, Edad edad, Salario salario) {
        super(entityId);
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public void actualizarSalario(Salario salario) {
        this.salario = salario;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Edad edad() {
        return edad;
    }

    public Salario salario() {
        return salario;
    }
}
