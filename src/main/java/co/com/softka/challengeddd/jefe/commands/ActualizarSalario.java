package co.com.softka.challengeddd.jefe.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.jefe.values.Salario;

public class ActualizarSalario extends Command {
    private final Salario salario;

    public ActualizarSalario(Salario salario) {
        this.salario = salario;
    }

    public Salario getSalario() {
        return salario;
    }
}
