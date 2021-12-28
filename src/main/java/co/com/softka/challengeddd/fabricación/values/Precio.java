package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Integer> {

    private final int value;

    public Precio(int value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Precio)) return false;
        Precio precio = (Precio) o;
        return value == precio.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
