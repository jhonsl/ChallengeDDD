package co.com.softka.challengeddd.fabricación.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.fabricación.values.CantidadDeAsientos;
import co.com.softka.challengeddd.fabricación.values.CantidadDeLLantas;
import co.com.softka.challengeddd.fabricación.values.IdCarro;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class CarroAgregado extends DomainEvent {

    private final IdCarro idCarro;
    private final Precio precio;
    private final CantidadDeLLantas cantidadDeLLantas;
    private final CantidadDeAsientos cantidadDeAsientos;

    public CarroAgregado(IdCarro entityId, Precio precio, CantidadDeLLantas cantidadDeLLantas, CantidadDeAsientos cantidadDeAsientos) {
        super("Softka.fabricacion.carroAgregado");
        this.idCarro = entityId;
        this.precio = precio;
        this.cantidadDeLLantas = cantidadDeLLantas;
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public IdCarro getIdCarro() {
        return idCarro;
    }

    public Precio getPrecio() {
        return precio;
    }

    public CantidadDeLLantas getCantidadDeLLantas() {
        return cantidadDeLLantas;
    }

    public CantidadDeAsientos getCantidadDeAsientos() {
        return cantidadDeAsientos;
    }
}
