package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Completado implements ValueObject<Boolean> {

    private final boolean value;

    public Completado(boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Completado)) return false;
        Completado that = (Completado) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
