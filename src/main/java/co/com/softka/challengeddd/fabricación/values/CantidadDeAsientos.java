package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CantidadDeAsientos implements ValueObject<Integer> {

    private final int value;

    public CantidadDeAsientos(int value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value <= 0) {
            throw new IllegalArgumentException("La cantidad de asientos debe ser mayor a 0");
        }
        if(this.value > 100) {
            throw new IllegalArgumentException("Cantidad de asientos invalida");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CantidadDeAsientos)) return false;
        CantidadDeAsientos that = (CantidadDeAsientos) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
