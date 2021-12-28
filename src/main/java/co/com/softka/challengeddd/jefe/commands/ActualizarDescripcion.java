package co.com.softka.challengeddd.jefe.commands;

import co.com.softka.challengeddd.objetivo.values.Descripcion;

public class ActualizarDescripcion {

    private final Descripcion descripcion;

    public ActualizarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
