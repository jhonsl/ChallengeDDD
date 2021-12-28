package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("Descripcion invalida");
        }
        if(this.value.length() < 20) {
            throw new IllegalArgumentException("La longitud minima es de 20 caracteres");
        }
        if(this.value.length() > 200) {
            throw new IllegalArgumentException("La longitud maxima es de 200 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Descripcion)) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
