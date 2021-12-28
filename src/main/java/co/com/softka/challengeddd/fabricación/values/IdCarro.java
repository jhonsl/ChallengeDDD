package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.Identity;

public class IdCarro extends Identity {

    public IdCarro() {}

    private IdCarro(String id) {
        super(id);
    }

    public static IdCarro of(String id) {
        return new IdCarro(id);
    }
}
