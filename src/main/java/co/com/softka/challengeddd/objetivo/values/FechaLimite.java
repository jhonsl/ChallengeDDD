package co.com.softka.challengeddd.objetivo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaLimite implements ValueObject<String> {

    private final LocalDate date;
    private final String format;

    public FechaLimite(int day, int month, int year) {
        try {
            date = LocalDate.of(year,month,day);
            if(date.isEqual(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha limite debe ser diferente a la actual");
            }
            if(date.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha debe estar despues a la actual");
            }
        }
        catch (DateTimeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        format = generateFormat();
    }

    private String generateFormat() {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FechaLimite)) return false;
        FechaLimite that = (FechaLimite) o;
        return Objects.equals(date, that.date) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, format);
    }
}
