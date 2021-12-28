package co.com.softka.challengeddd.fabricación.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.fabricación.values.Cilindraje;
import co.com.softka.challengeddd.fabricación.values.IdMoto;

public class ActualizarCilindraje extends Command {

    private final IdMoto idMoto;
    private final Cilindraje cilindraje;

    public ActualizarCilindraje(IdMoto idMoto, Cilindraje cilindraje) {
        this.idMoto = idMoto;
        this.cilindraje = cilindraje;
    }

    public IdMoto getIdMoto() {
        return idMoto;
    }

    public Cilindraje getCilindraje() {
        return cilindraje;
    }
}
