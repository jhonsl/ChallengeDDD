package co.com.softka.challengeddd.fabricación.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.fabricación.values.Cilindraje;
import co.com.softka.challengeddd.fabricación.values.IdFabricacion;
import co.com.softka.challengeddd.fabricación.values.IdMoto;
import co.com.softka.challengeddd.fabricación.values.Precio;

public class AgregarMoto extends Command {

    private final IdFabricacion idFabricacion;
    private final IdMoto idMoto;
    private final Cilindraje cilindraje;
    private final Precio precio;

    public AgregarMoto(IdFabricacion idFabricacion, IdMoto idMoto, Cilindraje cilindraje, Precio precio) {
        this.idFabricacion = idFabricacion;
        this.idMoto = idMoto;
        this.cilindraje = cilindraje;
        this.precio = precio;
    }

    public IdFabricacion getIdFabricacion() {
        return idFabricacion;
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
