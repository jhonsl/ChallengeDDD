package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdMejora;

public class ActualizarDescripcionMejora extends Command {

    private final IdMejora idMejora;
    private final Descripcion descripcion;

    public ActualizarDescripcionMejora(IdMejora idMejora, Descripcion descripcion) {
        this.idMejora = idMejora;
        this.descripcion = descripcion;
    }

    public IdMejora getIdMejora() {
        return idMejora;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
