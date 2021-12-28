package co.com.softka.challengeddd.jefe.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.jefe.values.Edad;
import co.com.softka.challengeddd.jefe.values.Nombre;

public class JefeCreado extends DomainEvent {

    private final Nombre nombre;
    private final Edad edad;

    public JefeCreado(Nombre nombre, Edad edad) {
        super("Softka.jefe.jefeCreado");
        this.nombre = nombre;
        this.edad = edad;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }
}
