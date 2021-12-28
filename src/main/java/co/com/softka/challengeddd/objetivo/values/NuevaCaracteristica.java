package co.com.softka.challengeddd.objetivo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NuevaCaracteristica implements ValueObject<String> {

    private final String value;

    public NuevaCaracteristica(String value) {
        this.value = Objects.requireNonNull(value);
        validations();
    }

    public void validations() {
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("Caracteristica invalida");
        }
        if(this.value.length() < 10) {
            throw new IllegalArgumentException("La longitud minima es de 10 caracteres");
        }
        if(this.value.length() > 200) {
            throw new IllegalArgumentException("La longitud maxima es de 200 caracteres");
        }
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NuevaCaracteristica)) return false;
        NuevaCaracteristica that = (NuevaCaracteristica) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
