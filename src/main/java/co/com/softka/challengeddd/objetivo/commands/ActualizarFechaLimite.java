package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.FechaLimite;
import co.com.softka.challengeddd.objetivo.values.IdMeta;

public class ActualizarFechaLimite extends Command {

    private final IdMeta idMeta;
    private final FechaLimite fechaLimite;

    public ActualizarFechaLimite(IdMeta idMeta, FechaLimite fechaLimite) {
        this.idMeta = idMeta;
        this.fechaLimite = fechaLimite;
    }

    public IdMeta getIdMeta() {
        return idMeta;
    }

    public FechaLimite getFechaLimite() {
        return fechaLimite;
    }
}
