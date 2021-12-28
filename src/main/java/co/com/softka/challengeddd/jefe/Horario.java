package co.com.softka.challengeddd.jefe;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.jefe.values.Duracion;
import co.com.softka.challengeddd.jefe.values.IdHorario;

public class Horario extends Entity<IdHorario> {

    protected Duracion duracion;

    public Horario(IdHorario entityId, Duracion duracion) {
        super(entityId);
        this.duracion = duracion;
    }

    public void actualizarDuracion(Duracion duracion) {
        this.duracion = duracion;
    }
}
