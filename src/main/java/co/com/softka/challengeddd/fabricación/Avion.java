package co.com.softka.challengeddd.fabricación;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.fabricación.values.CantidadDeAsientos;
import co.com.softka.challengeddd.fabricación.values.IdAvion;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class Avion extends Entity<IdAvion> {

    protected Precio precio;
    protected CantidadDeAsientos cantidadDeAsientos;

    public Avion(IdAvion entityId, Precio precio, CantidadDeAsientos cantidadDeAsientos) {
        super(entityId);
        this.precio = precio;
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public void actualizarPrecioAvion(Precio precio) {
        this.precio = precio;
    }

    public Precio precio() {
        return precio;
    }

    public CantidadDeAsientos cantidadDeAsientos() {
        return cantidadDeAsientos;
    }
}
