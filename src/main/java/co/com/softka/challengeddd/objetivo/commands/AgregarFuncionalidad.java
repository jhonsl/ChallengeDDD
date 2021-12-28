package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdFuncionalidad;
import co.com.softka.challengeddd.objetivo.values.IdObjetivo;

public class AgregarFuncionalidad extends Command {

    private final IdObjetivo idObjetivo;
    private final IdFuncionalidad idFuncionalidad;
    private final Descripcion descripcion;

    public AgregarFuncionalidad(IdObjetivo idObjetivo, IdFuncionalidad idFuncionalidad, Descripcion descripcion) {
        this.idObjetivo = idObjetivo;
        this.idFuncionalidad = idFuncionalidad;
        this.descripcion = descripcion;
    }

    public IdObjetivo getIdObjetivo() {
        return idObjetivo;
    }

    public IdFuncionalidad getIdFuncionalidad() {
        return idFuncionalidad;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
