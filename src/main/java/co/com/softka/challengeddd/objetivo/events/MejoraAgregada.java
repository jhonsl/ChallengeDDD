package co.com.softka.challengeddd.objetivo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdMejora;
import co.com.softka.challengeddd.objetivo.values.NuevaCaracteristica;

import java.util.Set;

public class MejoraAgregada extends DomainEvent {

    private final IdMejora idMejora;
    private final Descripcion descripcion;
    private final Set<NuevaCaracteristica> nuevasCaracteristicas;

    public MejoraAgregada(IdMejora entityId, Descripcion descripcion, Set<NuevaCaracteristica> nuevasCaracteristicas) {
        super("Softka.objetivo.mejoraAgregada");
        this.idMejora = entityId;
        this.descripcion = descripcion;
        this.nuevasCaracteristicas = nuevasCaracteristicas;
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
