package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CantidadDeLLantas implements ValueObject<Integer> {

    private final int value;

    public CantidadDeLLantas(int value) {
        this.value = Objects.requireNonNull(value);
    }

    public void validations() {
        if(this.value < 0) {
            throw new IllegalArgumentException("El valor debe ser positivo");
        }
        if(this.value < 3) {
            throw new IllegalArgumentException("Un carro debe tener por lo menos 3 llantas");
        }
        if(this.value > 15) {
            throw new IllegalArgumentException("La Cantidad excede el limite");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CantidadDeLLantas)) return false;
        CantidadDeLLantas that = (CantidadDeLLantas) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
