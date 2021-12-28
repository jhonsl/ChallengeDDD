package co.com.softka.challengeddd.objetivo.values;

import co.com.sofka.domain.generic.Identity;
import co.com.softka.challengeddd.jefe.values.IdHorario;

public class IdFuncionalidad extends Identity {

    public IdFuncionalidad() {}

    private IdFuncionalidad(String id) {
        super(id);
    }

    public static IdFuncionalidad of(String id) {
        return new IdFuncionalidad(id);
    }
}
