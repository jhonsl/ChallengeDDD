package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Presupuesto implements ValueObject<Long> {

    private final Long value;

    public Presupuesto(Long value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value < 0) {
            throw new IllegalArgumentException("El presupuesto debe ser positivo");
        }
        if(this.value == 0) {
            throw new IllegalArgumentException("No hay presupuesto para la fabricacion");
        }
    }

    @Override
    public Long value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Presupuesto)) return false;
        Presupuesto that = (Presupuesto) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
