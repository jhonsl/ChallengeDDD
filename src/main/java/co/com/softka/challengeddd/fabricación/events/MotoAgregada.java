package co.com.softka.challengeddd.fabricación.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.fabricación.values.Cilindraje;
import co.com.softka.challengeddd.fabricación.values.IdMoto;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class MotoAgregada extends DomainEvent {

    private final IdMoto idMoto;
    private final Cilindraje cilindraje;
    private final Precio precio;

    public MotoAgregada(IdMoto entityId, Cilindraje cilindraje, Precio precio) {
        super("Softka.fabricacion.motoAgregada");
        this.idMoto = entityId;
        this.cilindraje = cilindraje;
        this.precio = precio;
    }

    public IdMoto getIdMoto() {
        return idMoto;
    }

    public Cilindraje getCilindraje() {
        return cilindraje;
    }

    public Precio getPrecio() {
        return precio;
    }
}
