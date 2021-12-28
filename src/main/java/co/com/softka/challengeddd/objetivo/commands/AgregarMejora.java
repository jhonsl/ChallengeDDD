package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdMejora;
import co.com.softka.challengeddd.objetivo.values.IdObjetivo;
import co.com.softka.challengeddd.objetivo.values.NuevaCaracteristica;

import java.util.Set;

public class AgregarMejora extends Command {

    private final IdObjetivo idObjetivo;
    private final IdMejora idMejora;
    private final Descripcion descripcion;
    private final Set<NuevaCaracteristica> nuevasCaracteristicas;

    public AgregarMejora(IdObjetivo idObjetivo, IdMejora idMejora, Descripcion descripcion, Set<NuevaCaracteristica> nuevasCaracteristicas) {
        this.idObjetivo = idObjetivo;
        this.idMejora = idMejora;
        this.descripcion = descripcion;
        this.nuevasCaracteristicas = nuevasCaracteristicas;
    }

    public IdObjetivo getIdObjetivo() {
        return idObjetivo;
    }

    public IdMejora getIdMejora() {
        return idMejora;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Set<NuevaCaracteristica> getNuevasCaracteristicas() {
        return nuevasCaracteristicas;
    }
}
