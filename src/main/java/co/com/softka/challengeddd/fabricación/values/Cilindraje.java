package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cilindraje implements ValueObject<Integer> {

    private final int value;

    public Cilindraje(int value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value < 100) {
            throw new IllegalArgumentException("El cilindraje minimo es de 100 cc");
        }
        if(this.value > 1000) {
            throw new IllegalArgumentException("El cilindraje maximo es de 1000 cc");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cilindraje)) return false;
        Cilindraje that = (Cilindraje) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
