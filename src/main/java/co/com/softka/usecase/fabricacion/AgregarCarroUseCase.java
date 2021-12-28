package co.com.softka.usecase.fabricacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.fabricación.Fabricacion;
import co.com.softka.challengeddd.fabricación.commands.AgregarCarro;

public class AgregarCarroUseCase extends UseCase<RequestCommand<AgregarCarro>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCarro> requestCommand) {

        var command = requestCommand.getCommand();
        var fabricacion = Fabricacion.from(command.getIdFabricacion(), retrieveEvents());

        fabricacion.agregarCarro(command.getIdCarro(), command.getPrecio(), command.getCantidadDeLLantas(), command.getCantidadDeAsientos());

        emit().onResponse(new ResponseEvents(fabricacion.getUncommittedChanges()));
    }
}
