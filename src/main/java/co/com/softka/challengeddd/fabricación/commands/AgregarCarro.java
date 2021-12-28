package co.com.softka.challengeddd.fabricación.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.fabricación.values.*;

public class AgregarCarro extends Command {

    private final IdFabricacion idFabricacion;
    private final IdCarro idCarro;
    private final Precio precio;
    private final CantidadDeLLantas cantidadDeLLantas;
    private final CantidadDeAsientos cantidadDeAsientos;

    public AgregarCarro(IdFabricacion idFabricacion, IdCarro idCarro, Precio precio, CantidadDeLLantas cantidadDeLLantas, CantidadDeAsientos cantidadDeAsientos) {
        this.idFabricacion = idFabricacion;
        this.idCarro = idCarro;
        this.precio = precio;
        this.cantidadDeLLantas = cantidadDeLLantas;
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public IdFabricacion getIdFabricacion() {
        return idFabricacion;
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
