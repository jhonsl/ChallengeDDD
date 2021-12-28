package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Edad implements ValueObject<Integer> {

    private final int value;

    public Edad(int value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value <= 0) {
            throw new IllegalArgumentException("La edad debe ser positiva");
        }
        if(this.value < 18) {
            throw new IllegalArgumentException("La edad minima es de 18 años");
        }
        if(this.value > 60) {
            throw new IllegalArgumentException("La edad maxima es de 60 años");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edad)) return false;
        Edad edad = (Edad) o;
        return value == edad.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
