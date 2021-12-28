package co.com.softka.challengeddd.objetivo;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdFuncionalidad;

public class Funcionalidad extends Entity<IdFuncionalidad> {

    protected Descripcion descripcion;

    public Funcionalidad(IdFuncionalidad entityId, Descripcion descripcion) {
        super(entityId);
        this.descripcion = descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
