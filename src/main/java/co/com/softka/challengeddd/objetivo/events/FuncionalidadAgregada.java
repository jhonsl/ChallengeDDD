package co.com.softka.challengeddd.objetivo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdFuncionalidad;
import co.com.softka.challengeddd.objetivo.values.NuevaCaracteristica;

import java.util.Set;

public class FuncionalidadAgregada extends DomainEvent {

    private final IdFuncionalidad idFuncionalidad;
    private final Descripcion descripcion;

    public FuncionalidadAgregada(IdFuncionalidad entityId, Descripcion descripcion) {
        super("Softka.objetivo.funcionalidadAgregada");
        this.idFuncionalidad = entityId;
        this.descripcion = descripcion;
    }

    public IdFuncionalidad getIdFuncionalidad() {
        return idFuncionalidad;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
