package co.com.softka.challengeddd.jefe.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.jefe.values.Duracion;

public class ActualizarDuracion extends Command {

    private final Duracion duracion;

    public ActualizarDuracion(Duracion duracion) {
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
