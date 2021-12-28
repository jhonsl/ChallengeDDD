package co.com.softka.usecase;

import co.com.softka.challengeddd.fabricación.values.IdFabricacion;
import co.com.softka.challengeddd.fabricación.values.Modelo;

public interface GastosService {

    String getFacturaByFabricacionModelo(Modelo modelo);
}
