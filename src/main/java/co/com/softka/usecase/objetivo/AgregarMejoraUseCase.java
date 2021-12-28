package co.com.softka.usecase.objetivo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.objetivo.Objetivo;
import co.com.softka.challengeddd.objetivo.commands.AgregarMejora;

public class AgregarMejoraUseCase extends UseCase<RequestCommand<AgregarMejora>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarMejora> requestCommand) {

        var command = requestCommand.getCommand();
        var objetivo = Objetivo.from(command.getIdObjetivo(), retrieveEvents());

        objetivo.agregarMejora(command.getIdMejora(), command.getDescripcion(), command.getNuevasCaracteristicas());

        emit().onResponse(new ResponseEvents(objetivo.getUncommittedChanges()));
    }
}
