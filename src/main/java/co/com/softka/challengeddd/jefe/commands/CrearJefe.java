package co.com.softka.challengeddd.jefe.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.jefe.values.Edad;
import co.com.softka.challengeddd.jefe.values.IdJefe;
import co.com.softka.challengeddd.jefe.values.Nombre;

public class CrearJefe extends Command {

    private final IdJefe idJefe;
    private final Nombre nombre;
    private final Edad edad;

    public CrearJefe(IdJefe idJefe, Nombre nombre, Edad edad) {
        this.idJefe = idJefe;
        this.nombre = nombre;
        this.edad = edad;
    }

    public IdJefe getIdJefe() {
        return idJefe;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }
}
