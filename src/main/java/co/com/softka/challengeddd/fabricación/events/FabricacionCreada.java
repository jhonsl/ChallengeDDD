package co.com.softka.challengeddd.fabricación.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.fabricación.values.Modelo;
import co.com.softka.challengeddd.fabricación.values.Presupuesto;

public class FabricacionCreada extends DomainEvent {

    private final Modelo modelo;
    private final Presupuesto presupuesto;

    public FabricacionCreada(Modelo modelo, Presupuesto presupuesto) {
        super("Softka.fabricacion.fabricacionCreada");
        this.modelo = modelo;
        this.presupuesto = presupuesto;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }
}
