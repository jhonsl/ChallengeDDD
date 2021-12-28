package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdObjetivo;

public class CrearObjetivo extends Command {

    private final IdObjetivo idObjetivo;
    private final Descripcion descripcion;

    public CrearObjetivo(IdObjetivo idObjetivo, Descripcion descripcion) {
        this.idObjetivo = idObjetivo;
        this.descripcion = descripcion;
    }

    public IdObjetivo getIdObjetivo() {
        return idObjetivo;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
