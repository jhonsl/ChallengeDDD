package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Salario implements ValueObject<Integer> {

    private final int value;

    public Salario(int value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value <= 0) {
            throw new IllegalArgumentException("El salario debe ser positiva");
        }
        if(this.value < 800000) {
            throw new IllegalArgumentException("El salario minimo es de 800000 pesos");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salario)) return false;
        Salario salario = (Salario) o;
        return value == salario.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
