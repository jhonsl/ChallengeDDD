package co.com.softka.challengeddd.jefe.values;

import co.com.sofka.domain.generic.Identity;
import co.com.softka.challengeddd.fabricación.values.IdAvion;

public class IdEmpleado extends Identity {

    public IdEmpleado() {}

    private IdEmpleado(String id) {
        super(id);
    }

    public static IdEmpleado of(String id) {
        return new IdEmpleado(id);
    }
}
