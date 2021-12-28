package co.com.softka.challengeddd.objetivo;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.challengeddd.objetivo.values.Descripcion;
import co.com.softka.challengeddd.objetivo.values.IdMejora;
import co.com.softka.challengeddd.objetivo.values.NuevaCaracteristica;

import java.util.Set;

public class Mejora extends Entity<IdMejora> {

    protected Descripcion descripcion;
    protected Set<NuevaCaracteristica> nuevasCaracteristicas;

    public Mejora(IdMejora entityId, Descripcion descripcion, Set<NuevaCaracteristica> nuevasCaracteristicas) {
        super(entityId);
        this.descripcion = descripcion;
        this.nuevasCaracteristicas = nuevasCaracteristicas;
    }

    public void actualizarNuevaDescripcionMejora(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarNuevaCaracteristica(NuevaCaracteristica nuevaCaracteristica) {
        this.nuevasCaracteristicas.add(nuevaCaracteristica);
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Set<NuevaCaracteristica> nuevasCaracteristicas() {
        return nuevasCaracteristicas;
    }
}
