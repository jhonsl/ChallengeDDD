package co.com.softka.challengeddd.jefe.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.jefe.values.IdTarea;

public class TareaCompletada extends DomainEvent {

    private final IdTarea idTarea;

    public TareaCompletada(IdTarea entityId) {
        super("Softka.jefe.tareaCompletada");
        this.idTarea = entityId;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }
}
