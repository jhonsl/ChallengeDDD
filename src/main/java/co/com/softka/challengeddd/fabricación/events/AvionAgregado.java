package co.com.softka.challengeddd.fabricación.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.fabricación.values.CantidadDeAsientos;
import co.com.softka.challengeddd.fabricación.values.IdAvion;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class AvionAgregado extends DomainEvent {

    private final IdAvion idAvion;
    private final Precio precio;
    private final CantidadDeAsientos cantidadDeAsientos;

    public AvionAgregado(IdAvion entityId, Precio precio, CantidadDeAsientos cantidadDeAsientos) {
        super("Softka.fabricacion.avionAgregado");
        this.idAvion = entityId;
        this.precio = precio;
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public IdAvion getIdAvion() {
        return idAvion;
    }

    public Precio getPrecio() {
        return precio;
    }

    public CantidadDeAsientos getCantidadDeAsientos() {
        return cantidadDeAsientos;
    }
}
