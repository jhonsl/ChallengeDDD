package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Modelo implements ValueObject<String> {

    private final String value;

    public Modelo(String value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("Argumento invalido");
        }
        if(this.value.length() < 3) {
            throw new IllegalArgumentException("La longitud minima es de 3 caracteres");
        }
        if(this.value.length() > 20) {
            throw new IllegalArgumentException("La longitud maxima es de 20 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modelo)) return false;
        Modelo modelo = (Modelo) o;
        return Objects.equals(value, modelo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
