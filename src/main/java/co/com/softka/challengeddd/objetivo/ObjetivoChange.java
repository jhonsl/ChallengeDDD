package co.com.softka.challengeddd.objetivo;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.challengeddd.objetivo.events.FuncionalidadAgregada;
import co.com.softka.challengeddd.objetivo.events.MejoraAgregada;
import co.com.softka.challengeddd.objetivo.events.MetaCompletada;
import co.com.softka.challengeddd.objetivo.events.ObjetivoCreado;
import co.com.softka.challengeddd.objetivo.values.Completado;

import java.util.HashSet;

public class ObjetivoChange extends EventChange {
    public ObjetivoChange(Objetivo objetivo) {

        apply((ObjetivoCreado event) -> {
            objetivo.descripcion = event.getDescripcion();
            objetivo.mejoras = new HashSet<>();
            objetivo.metas = new HashSet<>();
            objetivo.funcionalidades = new HashSet<>();
        });

        apply((MejoraAgregada event) -> {
            objetivo.mejoras.add(new Mejora(
                    event.getIdMejora(),
                    event.getDescripcion(),
                    event.getNuevasCaracteristicas()
            ));
        });

        apply((MetaCompletada event) -> {
            var meta = objetivo.getMetaById(event.getIdMeta())
                    .orElseThrow(() -> new IllegalArgumentException("La meta no existe"));

            meta.actualizarCompletado(new Completado(true));
        });

        apply((FuncionalidadAgregada event) -> {
            objetivo.funcionalidades.add(new Funcionalidad(
                    event.getIdFuncionalidad(),
                    event.getDescripcion()
            ));
        });
    }
}
