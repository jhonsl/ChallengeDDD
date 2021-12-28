package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("Nombre invalido");
        }
        if(this.value.length() < 4) {
            throw new IllegalArgumentException("La longitud minima es de 4 caracteres");
        }
        if(this.value.length() > 30) {
            throw new IllegalArgumentException("La longitud maxima es de 30 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nombre)) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(value, nombre.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
