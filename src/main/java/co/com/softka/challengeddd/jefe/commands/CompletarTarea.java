package co.com.softka.challengeddd.jefe.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.jefe.values.Completado;
import co.com.softka.challengeddd.jefe.values.IdTarea;

public class CompletarTarea extends Command {

    private final IdTarea idTarea;
    private final Completado completado;

    public CompletarTarea(IdTarea idTarea, Completado completado) {
        this.idTarea = idTarea;
        this.completado = completado;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public Completado getCompletado() {
        return completado;
    }
}
