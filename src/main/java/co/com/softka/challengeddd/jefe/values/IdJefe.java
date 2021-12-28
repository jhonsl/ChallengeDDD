package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.Identity;

public class IdJefe extends Identity {

    public IdJefe() {}

    private IdJefe(String id) {
        super(id);
    }

    public static IdJefe of(String id) {
        return new IdJefe(id);
    }
}
