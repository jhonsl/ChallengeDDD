package co.com.softka.usecase.jefe;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.jefe.Jefe;
import co.com.softka.challengeddd.jefe.commands.AgregarEmpleado;

public class AgregarEmpleadoUseCase extends UseCase<RequestCommand<AgregarEmpleado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarEmpleado> requestCommand) {
        var command = requestCommand.getCommand();
        var jefe = Jefe.from(command.getIdJefe(), retrieveEvents());

        if(jefe.empleados().size() > 20) {
            throw new BusinessException(command.getIdJefe().value(), "No se puede tener mas empleados");
        }
        jefe.agregarEmpleado(command.getIdEmpleado(), command.getNombre(), command.getEdad(), command.getSalario());

        emit().onResponse(new ResponseEvents(jefe.getUncommittedChanges()));
    }
}
