package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.Identity;

public class IdHorario extends Identity {

    public IdHorario() {}

    private IdHorario(String id) {
        super(id);
    }

    public static IdHorario of(String id) {
        return new IdHorario(id);
    }
}
