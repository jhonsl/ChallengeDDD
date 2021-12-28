package co.com.softka.usecase.jefe;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.jefe.Jefe;
import co.com.softka.challengeddd.jefe.commands.CrearJefe;

public class CrearJefeUseCase extends UseCase<RequestCommand<CrearJefe>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearJefe> requestCommand) {
        var command = requestCommand.getCommand();
        var jefe = new Jefe(command.getIdJefe(), command.getNombre(), command.getEdad());

        emit().onResponse(new ResponseEvents(jefe.getUncommittedChanges()));
    }
}
