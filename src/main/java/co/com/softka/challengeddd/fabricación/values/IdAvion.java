package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.Identity;

public class IdAvion extends Identity {

    public IdAvion() {}

    private IdAvion(String id) {
        super(id);
    }

    public static IdAvion of(String id) {
        return new IdAvion(id);
    }
}
