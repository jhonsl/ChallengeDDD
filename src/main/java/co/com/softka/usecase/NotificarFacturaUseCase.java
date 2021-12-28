package co.com.softka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.softka.challengeddd.fabricación.events.FabricacionCreada;

public class NotificarFacturaUseCase extends UseCase<TriggeredEvent<FabricacionCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<FabricacionCreada> fabricacionCreadaTriggeredEvent) {

        var event = fabricacionCreadaTriggeredEvent.getDomainEvent();
        var gastosService = getService(GastosService.class).orElseThrow();
        var send = getService(SendFacturaService.class).orElseThrow();
        var factura = gastosService.getFacturaByFabricacionModelo(event.getModelo());

        send.sendFactura(factura, "Softka technologies");
    }
}
