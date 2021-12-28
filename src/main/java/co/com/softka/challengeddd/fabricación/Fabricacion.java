package co.com.softka.challengeddd.fabricación;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.fabricación.events.AvionAgregado;
import co.com.softka.challengeddd.fabricación.events.CarroAgregado;
import co.com.softka.challengeddd.fabricación.events.FabricacionCreada;
import co.com.softka.challengeddd.fabricación.events.MotoAgregada;
import co.com.softka.challengeddd.fabricación.values.*;
import co.com.softka.challengeddd.jefe.values.IdJefe;
import co.com.softka.challengeddd.objetivo.values.IdObjetivo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Fabricacion extends AggregateEvent<IdFabricacion> {

    protected IdJefe idJefe;
    protected IdObjetivo idObjetivo;

    protected Modelo modelo;
    protected Presupuesto presupuesto;
    protected Set<Carro> carros;
    protected Set<Moto> motos;
    protected Set<Avion> aviones;

    public Fabricacion(IdFabricacion entityId, Modelo modelo, Presupuesto presupuesto) {
        super(entityId);
        appendChange(new FabricacionCreada(modelo, presupuesto)).apply();
    }

    private Fabricacion(IdFabricacion entityId) {
        super(entityId);
        subscribe(new FabricacionChange(this));
    }

    public static Fabricacion from(IdFabricacion entityId, List<DomainEvent> events) {
        Objects.requireNonNull(entityId);

        var fabricacion = new Fabricacion(entityId);
        events.forEach(fabricacion::applyEvent);

        return fabricacion;
    }

    public Optional<Carro> getCarroById(IdCarro idCarro) {
        Objects.requireNonNull(idCarro);

        return carros()
                .stream()
                .filter(carro -> carro.identity().equals(idCarro))
                .findFirst();
    }

    public Optional<Moto> getMotoById(IdMoto idMoto) {
        Objects.requireNonNull(idMoto);

        return motos()
                .stream()
                .filter(moto -> moto.identity().equals(idMoto))
                .findFirst();
    }

    public Optional<Avion> getAvionById(IdAvion idAvion) {
        Objects.requireNonNull(idAvion);

        return aviones()
                .stream()
                .filter(avion -> avion.identity().equals(idAvion))
                .findFirst();
    }

    public void agregarCarro(IdCarro entityId, Precio precio, CantidadDeLLantas cantidadDeLLantas, CantidadDeAsientos cantidadDeAsientos) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(cantidadDeLLantas);
        Objects.requireNonNull(cantidadDeAsientos);

        appendChange(new CarroAgregado(entityId, precio, cantidadDeLLantas, cantidadDeAsientos)).apply();
    }

    public void agregarMoto(IdMoto entityId, Cilindraje cilindraje, Precio precio) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(cilindraje);
        Objects.requireNonNull(precio);

        appendChange(new MotoAgregada(entityId, cilindraje, precio)).apply();
    }

    public void agregarAvion(IdAvion entityId, Precio precio, CantidadDeAsientos cantidadDeAsientos) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(cantidadDeAsientos);

        appendChange(new AvionAgregado(entityId, precio, cantidadDeAsientos)).apply();
    }

    public IdJefe idJefe() {
        return idJefe;
    }

    public IdObjetivo idObjetivo() {
        return idObjetivo;
    }

    public Modelo modelo() {
        return modelo;
    }

    public Presupuesto presupuesto() {
        return presupuesto;
    }

    public Set<Carro> carros() {
        return carros;
    }

    public Set<Moto> motos() {
        return motos;
    }

    public Set<Avion> aviones() {
        return aviones;
    }

}
