package co.com.softka.challengeddd.fabricación.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.fabricación.values.IdAvion;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class ActualizarPrecioAvion extends Command {

    private final IdAvion idAvion;
    private final Precio precio;

    public ActualizarPrecioAvion(IdAvion idAvion, Precio precio) {
        this.idAvion = idAvion;
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }

    public IdAvion getIdAvion() {
        return idAvion;
    }
}
