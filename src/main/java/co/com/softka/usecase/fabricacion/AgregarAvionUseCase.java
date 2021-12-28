package co.com.softka.usecase.fabricacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.fabricación.Fabricacion;
import co.com.softka.challengeddd.fabricación.commands.AgregarAvion;

public class AgregarAvionUseCase extends UseCase<RequestCommand<AgregarAvion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarAvion> requestCommand) {
        var command = requestCommand.getCommand();
        var fabricacion = Fabricacion.from(command.getIdFabricacion(), retrieveEvents());

        fabricacion.agregarAvion(command.getIdAvion(), command.getPrecio(), command.getCantidadDeAsientos());

        emit().onResponse(new ResponseEvents(fabricacion.getUncommittedChanges()));
    }
}
