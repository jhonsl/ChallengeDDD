package co.com.softka.challengeddd.objetivo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.challengeddd.objetivo.values.IdMejora;
import co.com.softka.challengeddd.objetivo.values.IdObjetivo;
import co.com.softka.challengeddd.objetivo.values.NuevaCaracteristica;

public class AgregarNuevaCaracteristica extends Command {

    private final IdObjetivo idObjetivo;
    private final IdMejora idMejora;
    private final NuevaCaracteristica nuevaCaracteristica;

    public AgregarNuevaCaracteristica(IdObjetivo idObjetivo, IdMejora idMejora, NuevaCaracteristica nuevaCaracteristica) {
        this.idObjetivo = idObjetivo;
        this.idMejora = idMejora;
        this.nuevaCaracteristica = nuevaCaracteristica;
    }

    public IdObjetivo getIdObjetivo() {
        return idObjetivo;
    }

    public NuevaCaracteristica getNuevaCaracteristica() {
        return nuevaCaracteristica;
    }

    public IdMejora getIdMejora() {
        return idMejora;
    }
}
