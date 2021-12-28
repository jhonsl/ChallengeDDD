package co.com.softka.usecase.objetivo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.objetivo.Objetivo;
import co.com.softka.challengeddd.objetivo.commands.AgregarFuncionalidad;

public class AgregarFuncionalidadUseCase extends UseCase<RequestCommand<AgregarFuncionalidad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarFuncionalidad> requestCommand) {

        var command = requestCommand.getCommand();
        var objetivo = Objetivo.from(command.getIdObjetivo(), retrieveEvents());

        objetivo.agregarFuncionalidad(command.getIdFuncionalidad(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(objetivo.getUncommittedChanges()));
    }
}
