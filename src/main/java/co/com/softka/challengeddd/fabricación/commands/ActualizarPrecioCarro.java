package co.com.softka.challengeddd.fabricación.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.fabricación.values.IdCarro;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class ActualizarPrecioCarro extends Command {

    private final IdCarro idCarro;
    private final Precio precio;

    public ActualizarPrecioCarro(IdCarro idCarro, Precio precio) {
        this.idCarro = idCarro;
        this.precio = precio;
    }

    public IdCarro getIdCarro() {
        return idCarro;
    }

    public Precio getPrecio() {
        return precio;
    }
}
