package co.com.softka.usecase.objetivo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.objetivo.Objetivo;
import co.com.softka.challengeddd.objetivo.commands.CrearObjetivo;

import javax.management.ObjectName;

public class CrearObjetivoUseCase extends UseCase<RequestCommand<CrearObjetivo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearObjetivo> requestCommand) {

        var command = requestCommand.getCommand();
        var Objetivo = new Objetivo(command.getIdObjetivo(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(Objetivo.getUncommittedChanges()));
    }
}
