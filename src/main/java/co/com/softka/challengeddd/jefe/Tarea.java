package co.com.softka.challengeddd.jefe;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.jefe.values.Completado;
import co.com.softka.challengeddd.jefe.values.Descripcion;
import co.com.softka.challengeddd.jefe.values.IdTarea;

public class Tarea extends Entity<IdTarea> {

    protected Completado completado;
    protected Descripcion descripcion;

    public Tarea(IdTarea entityId, Completado completado, Descripcion descripcion) {
        super(entityId);
        this.completado = completado;
        this.descripcion = descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public void actualizarCompletado(Completado completado) {
        this.completado = completado;
    }

    public Completado completado() {
        return completado;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
