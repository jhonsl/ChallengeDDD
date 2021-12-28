package co.com.softka.challengeddd.objetivo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.objetivo.events.FuncionalidadAgregada;
import co.com.softka.challengeddd.objetivo.events.MejoraAgregada;
import co.com.softka.challengeddd.objetivo.events.MetaCompletada;
import co.com.softka.challengeddd.objetivo.events.ObjetivoCreado;
import co.com.softka.challengeddd.objetivo.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Objetivo extends AggregateEvent<IdObjetivo> {

    protected Descripcion descripcion;
    protected Set<Mejora> mejoras;
    protected Set<Meta> metas;
    protected Set<Funcionalidad> funcionalidades;

    public Objetivo(IdObjetivo entityId, Descripcion descripcion) {
        super(entityId);
        appendChange(new ObjetivoCreado(descripcion)).apply();
    }

    private Objetivo(IdObjetivo entityId) {
        super(entityId);
        subscribe(new ObjetivoChange(this));
    }

    public static Objetivo from(IdObjetivo entityId, List<DomainEvent> events) {
        Objects.requireNonNull(entityId);

        var objetivo = new Objetivo(entityId);
        events.forEach(objetivo::applyEvent);

        return objetivo;
    }

    public Optional<Mejora> getMejoraById(IdMejora idMejora) {
        Objects.requireNonNull(idMejora);

        return mejoras()
                .stream()
                .filter(mejora -> mejora.identity().equals(idMejora))
                .findFirst();
    }

    public Optional<Meta> getMetaById(IdMeta idMeta) {
        Objects.requireNonNull(idMeta);

        return metas()
                .stream()
                .filter(meta -> meta.identity().equals(idMeta))
                .findFirst();
    }

    public Optional<Funcionalidad> getFuncionalidadById(IdFuncionalidad idFuncionalidad) {
        Objects.requireNonNull(idFuncionalidad);

        return funcionalidades()
                .stream()
                .filter(funcionalidad -> funcionalidad.identity().equals(idFuncionalidad))
                .findFirst();
    }

    public void agregarMejora(IdMejora idMejora, Descripcion descripcion, Set<NuevaCaracteristica> nuevasCaracteristicas) {
        Objects.requireNonNull(idMejora);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(nuevasCaracteristicas);

        appendChange(new MejoraAgregada(idMejora, descripcion, nuevasCaracteristicas)).apply();
    }

    public void agregarFuncionalidad(IdFuncionalidad idFuncionalidad, Descripcion descripcion) {
        Objects.requireNonNull(idFuncionalidad);
        Objects.requireNonNull(descripcion);

        appendChange(new FuncionalidadAgregada(idFuncionalidad, descripcion)).apply();
    }

    public void completarMeta(IdMeta idMeta) {
        Objects.requireNonNull(idMeta);

        appendChange(new MetaCompletada(idMeta)).apply();
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Set<Mejora> mejoras() {
        return mejoras;
    }

    public Set<Meta> metas() {
        return metas;
    }

    public Set<Funcionalidad> funcionalidades() {
        return funcionalidades;
    }
}
