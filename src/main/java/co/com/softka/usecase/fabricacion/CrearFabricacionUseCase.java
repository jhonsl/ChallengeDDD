package co.com.softka.usecase.fabricacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.fabricación.Fabricacion;
import co.com.softka.challengeddd.fabricación.commands.CrearFabricacion;

public class CrearFabricacionUseCase extends UseCase<RequestCommand<CrearFabricacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFabricacion> requestCommand) {
        var command = requestCommand.getCommand();
        var fabricacion = new Fabricacion(command.getIdFabricacion(), command.getModelo(), command.getPresupuesto());

        emit().onResponse(new ResponseEvents(fabricacion.getUncommittedChanges()));
    }
}
