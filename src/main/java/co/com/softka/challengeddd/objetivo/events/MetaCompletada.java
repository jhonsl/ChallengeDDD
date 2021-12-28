package co.com.softka.challengeddd.objetivo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.objetivo.values.IdMeta;

public class MetaCompletada extends DomainEvent {

    private final IdMeta idMeta;

    public MetaCompletada(IdMeta entityId) {
        super("Softka.objetivo.mejoraCompletada");
        this.idMeta = entityId;
    }

    public IdMeta getIdMeta() {
        return idMeta;
    }
}
