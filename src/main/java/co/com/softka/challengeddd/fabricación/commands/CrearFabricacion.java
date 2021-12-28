package co.com.softka.challengeddd.fabricación.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.fabricación.values.IdFabricacion;
import co.com.softka.challengeddd.fabricación.values.Modelo;
import co.com.softka.challengeddd.fabricación.values.Presupuesto;

public class CrearFabricacion extends Command {

    private final IdFabricacion idFabricacion;
    private final Modelo modelo;
    private final Presupuesto presupuesto;

    public CrearFabricacion(IdFabricacion idFabricacion, Modelo modelo, Presupuesto presupuesto) {
        this.idFabricacion = idFabricacion;
        this.modelo = modelo;
        this.presupuesto = presupuesto;
    }

    public IdFabricacion getIdFabricacion() {
        return idFabricacion;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }
}
