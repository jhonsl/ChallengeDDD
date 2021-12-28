package co.com.softka.challengeddd.fabricación.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.fabricación.values.CantidadDeAsientos;
import co.com.softka.challengeddd.fabricación.values.IdAvion;
import co.com.softka.challengeddd.fabricación.values.IdFabricacion;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class AgregarAvion extends Command {

    private final IdFabricacion idFabricacion;
    private final IdAvion idAvion;
    private final Precio precio;
    private final CantidadDeAsientos cantidadDeAsientos;

    public AgregarAvion(IdFabricacion idFabricacion, IdAvion idAvion, Precio precio, CantidadDeAsientos cantidadDeAsientos) {
        this.idFabricacion = idFabricacion;
        this.idAvion = idAvion;
        this.precio = precio;
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public IdFabricacion getIdFabricacion() {
        return idFabricacion;
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
