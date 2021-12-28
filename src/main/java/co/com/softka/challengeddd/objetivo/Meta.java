package co.com.softka.challengeddd.objetivo;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.objetivo.values.Completado;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.FechaLimite;
import co.com.softka.challengeddd.objetivo.values.IdMeta;

public class Meta extends Entity<IdMeta> {

    protected Completado completado;
    protected FechaLimite fechaLimite;
    protected Descripcion descripcion;

    public Meta(IdMeta entityId, Completado completado, FechaLimite fechaLimite, Descripcion descripcion) {
        super(entityId);
        this.completado = completado;
        this.fechaLimite = fechaLimite;
        this.descripcion = descripcion;
    }

    public void actualizarFechaLimite(FechaLimite fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void actualizarCompletado(Completado completado) {
        this.completado = completado;
    }

    public Completado completado() {
        return completado;
    }

    public FechaLimite fechaLimite() {
        return fechaLimite;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
