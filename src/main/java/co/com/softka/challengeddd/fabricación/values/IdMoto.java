package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.Identity;

public class IdMoto extends Identity {

    public IdMoto() {}

    private IdMoto(String id) {
        super(id);
    }

    public static IdMoto of(String id) {
        return new IdMoto(id);
    }
}
