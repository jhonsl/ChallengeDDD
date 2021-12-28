package co.com.softka.challengeddd.fabricación;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.fabricación.values.CantidadDeAsientos;
import co.com.softka.challengeddd.fabricación.values.CantidadDeLLantas;
import co.com.softka.challengeddd.fabricación.values.IdCarro;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class Carro extends Entity<IdCarro> {

    protected Precio precio;
    protected CantidadDeLLantas cantidadDeLLantas;
    protected CantidadDeAsientos cantidadDeAsientos;

    public Carro(IdCarro entityId, Precio precio, CantidadDeLLantas cantidadDeLLantas, CantidadDeAsientos cantidadDeAsientos) {
        super(entityId);
        this.precio = precio;
        this.cantidadDeLLantas = cantidadDeLLantas;
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public void actualizarPrecioCarro(Precio precio) {
        this.precio = precio;
    }

    public Precio precio() {
        return precio;
    }

    public CantidadDeLLantas cantidadDeLLantas() {
        return cantidadDeLLantas;
    }

    public CantidadDeAsientos cantidadDeAsientos() {
        return cantidadDeAsientos;
    }
}
