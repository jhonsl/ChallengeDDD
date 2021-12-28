package co.com.softka.usecase.fabricacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.challengeddd.fabricación.Fabricacion;
import co.com.softka.challengeddd.fabricación.commands.AgregarMoto;

public class AgregarMotoUseCase extends UseCase<RequestCommand<AgregarMoto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarMoto> requestCommand) {

        var commando = requestCommand.getCommand();
        var fabricacion = Fabricacion.from(commando.getIdFabricacion(), retrieveEvents());

        fabricacion.agregarMoto(commando.getIdMoto(), commando.getCilindraje(), commando.getPrecio());

        emit().onResponse(new ResponseEvents(fabricacion.getUncommittedChanges()));
    }
}
