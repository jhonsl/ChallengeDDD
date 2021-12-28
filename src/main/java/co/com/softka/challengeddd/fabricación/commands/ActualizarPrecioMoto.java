package co.com.softka.challengeddd.fabricación.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.fabricación.values.IdMoto;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class ActualizarPrecioMoto extends Command {

    private final IdMoto idMoto;
    private final Precio precio;

    public ActualizarPrecioMoto(IdMoto idMoto, Precio precio) {
        this.idMoto = idMoto;
        this.precio = precio;
    }

    public IdMoto getIdMoto() {
        return idMoto;
    }

    public Precio getPrecio() {
        return precio;
    }
}
