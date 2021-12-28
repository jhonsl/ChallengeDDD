package co.com.softka.challengeddd.objetivo.values;

import co.com.sofka.domain.generic.Identity;

public class IdMeta extends Identity {

    public IdMeta() {}

    private IdMeta(String id) {
        super(id);
    }

    public static IdMeta of(String id) {
        return new IdMeta(id);
    }
}
