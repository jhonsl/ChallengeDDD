package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdMeta;

public class ActualizarDescripcionMeta extends Command {

    private final IdMeta idMeta;
    private final Descripcion descripcion;

    public ActualizarDescripcionMeta(IdMeta idMeta, Descripcion descripcion) {
        this.idMeta = idMeta;
        this.descripcion = descripcion;
    }

    public IdMeta getIdMeta() {
        return idMeta;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
