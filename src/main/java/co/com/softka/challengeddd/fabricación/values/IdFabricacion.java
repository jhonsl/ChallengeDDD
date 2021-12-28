package co.com.softka.challengeddd.fabricación.values;

import co.com.sofka.domain.generic.Identity;

public class IdFabricacion extends Identity {

    public IdFabricacion() {}

    private IdFabricacion(String id) {
        super(id);
    }

    public static IdFabricacion of(String id) {
        return new IdFabricacion(id);
    }
}
