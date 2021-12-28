package co.com.softka.challengeddd.objetivo.values;

import co.com.sofka.domain.generic.Identity;

public class IdObjetivo extends Identity {

    public IdObjetivo() {}

    private IdObjetivo(String id) {
        super(id);
    }

    public static IdObjetivo of(String id) {
        return new IdObjetivo(id);
    }
}
