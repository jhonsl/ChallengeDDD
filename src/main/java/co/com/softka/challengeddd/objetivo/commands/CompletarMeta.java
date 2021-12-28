package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.Completado;
import co.com.softka.challengeddd.objetivo.values.IdMeta;

public class CompletarMeta extends Command {

    private final IdMeta idMeta;
    private final Completado completado;

    public CompletarMeta(IdMeta idMeta, Completado completado) {
        this.idMeta = idMeta;
        this.completado = completado;
    }

    public IdMeta getIdMeta() {
        return idMeta;
    }

    public Completado getCompletado() {
        return completado;
    }
}
