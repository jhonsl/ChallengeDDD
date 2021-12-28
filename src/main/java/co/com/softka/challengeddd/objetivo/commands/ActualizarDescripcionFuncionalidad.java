package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdFuncionalidad;

public class ActualizarDescripcionFuncionalidad extends Command {

    private final IdFuncionalidad idFuncionalidad;
    private final Descripcion descripcion;

    public ActualizarDescripcionFuncionalidad(IdFuncionalidad idFuncionalidad, Descripcion descripcion) {
        this.idFuncionalidad = idFuncionalidad;
        this.descripcion = descripcion;
    }

    public IdFuncionalidad getIdFuncionalidad() {
        return idFuncionalidad;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
