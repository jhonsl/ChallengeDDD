package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Integer> {

    private final int value;

    public Duracion(int value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value < 0) {
            throw new IllegalArgumentException("Duracion invalida");
        }
        if(this.value == 0) {
            throw new IllegalArgumentException("La duracion no puede ser 0");
        }
        if(this.value > 100) {
            throw new IllegalArgumentException("La duracion maxima es de 100 horas");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Duracion)) return false;
        Duracion duracion = (Duracion) o;
        return value == duracion.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
