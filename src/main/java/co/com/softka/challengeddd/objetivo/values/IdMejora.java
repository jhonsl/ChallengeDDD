package co.com.softka.challengeddd.objetivo.values;

import co.com.sofka.domain.generic.Identity;

public class IdMejora extends Identity {

    public IdMejora() {}

    private IdMejora(String id) {
        super(id);
    }

    public static IdMejora of(String id) {
        return new IdMejora(id);
    }
}
