package co.com.softka.challengeddd.fabricación;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.challengeddd.fabricación.events.AvionAgregado;
import co.com.softka.challengeddd.fabricación.events.CarroAgregado;
import co.com.softka.challengeddd.fabricación.events.FabricacionCreada;
import co.com.softka.challengeddd.fabricación.events.MotoAgregada;

import java.util.HashSet;

public class FabricacionChange extends EventChange {

    public FabricacionChange(Fabricacion fabricacion) {

        apply((FabricacionCreada event) -> {
            fabricacion.modelo = event.getModelo();
            fabricacion.presupuesto = event.getPresupuesto();
            fabricacion.carros = new HashSet<>();
            fabricacion.motos = new HashSet<>();
            fabricacion.aviones = new HashSet<>();
        });

        apply((AvionAgregado event) -> {
            fabricacion.aviones.add(new Avion(
                    event.getIdAvion(),
                    event.getPrecio(),
                    event.getCantidadDeAsientos()
            ));
        });

        apply((CarroAgregado event) -> {
            fabricacion.carros.add(new Carro(
                    event.getIdCarro(),
                    event.getPrecio(),
                    event.getCantidadDeLLantas(),
                    event.getCantidadDeAsientos()
            ));
        });

        apply((MotoAgregada event) -> {
            fabricacion.motos.add(new Moto(
                    event.getIdMoto(),
                    event.getCilindraje(),
                    event.getPrecio()
            ));
        });
    }
}
