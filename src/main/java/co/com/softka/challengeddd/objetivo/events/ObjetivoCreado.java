package co.com.softka.challengeddd.objetivo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.objetivo.values.Descripcion;

public class ObjetivoCreado extends DomainEvent {

    private final Descripcion descripcion;

    public ObjetivoCreado(Descripcion descripcion) {
        super("Softka.objetivo.objetivoCreado");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
