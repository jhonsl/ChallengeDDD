package co.com.softka.challengeddd.fabricación;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.fabricación.values.Cilindraje;
import co.com.softka.challengeddd.fabricación.values.IdMoto;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class Moto extends Entity<IdMoto> {

    protected Cilindraje cilindraje;
    protected Precio precio;

    public Moto(IdMoto entityId, Cilindraje cilindraje, Precio precio) {
        super(entityId);
        this.cilindraje = cilindraje;
        this.precio = precio;
    }

    public void actualizarPrecioMoto(Precio precio) {
        this.precio = precio;
    }

    public void actualizarCilindraje(Cilindraje cilindraje) {
        this.cilindraje = cilindraje;
    }

    public Cilindraje cilindraje() {
        return cilindraje;
    }

    public Precio precio() {
        return precio;
    }
}
