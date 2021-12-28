package co.com.softka.usecase.jefe;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.jefe.Jefe;
import co.com.softka.challengeddd.jefe.commands.EliminarEmpleado;

public class EliminarEmpleadoUseCase extends UseCase<RequestCommand<EliminarEmpleado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarEmpleado> requestCommand) {
        var command = requestCommand.getCommand();
        var jefe = Jefe.from(command.getIdJefe(), retrieveEvents());

        jefe.eliminarEmpleado(command.getIdEmpleado());

        emit().onResponse(new ResponseEvents(jefe.getUncommittedChanges()));
    }
}
