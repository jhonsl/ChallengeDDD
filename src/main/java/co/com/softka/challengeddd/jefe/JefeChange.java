package co.com.softka.challengeddd.jefe;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.challengeddd.jefe.events.EmpleadoEliminado;
import co.com.softka.challengeddd.jefe.events.JefeCreado;
import co.com.softka.challengeddd.jefe.events.EmpleadoAgregado;
import co.com.softka.challengeddd.jefe.events.TareaCompletada;
import co.com.softka.challengeddd.jefe.values.Completado;

import java.util.HashSet;

public class JefeChange extends EventChange {
    public JefeChange(Jefe jefe) {

        apply((JefeCreado event) ->{
            jefe.nombre = event.getNombre();
            jefe.edad = event.getEdad();
            jefe.empleados = new HashSet<>();
            jefe.tareas = new HashSet<>();
            jefe.horarios = new HashSet<>();
        });

        apply((EmpleadoAgregado event) -> {
            var numEmpleados = jefe.empleados().size();
            if(numEmpleados > 20 ) {
                throw new IllegalArgumentException("Solo puede haber 20 empleados por jefe");
            }
            jefe.empleados.add(new Empleado(
                    event.getIdEmpleado(),
                    event.getNombre(),
                    event.getEdad(),
                    event.getSalario()
            ));
        });

        apply((EmpleadoEliminado event) -> {
            var empleado = jefe.getEmpleadoById(event.getIdEmpleado())
                    .orElseThrow(() -> new IllegalArgumentException("El empleado no existe"));

            jefe.empleados.remove(empleado);
        });

        apply((TareaCompletada event) -> {
            var tarea = jefe.getTareaById(event.getIdTarea())
                    .orElseThrow(() -> new IllegalArgumentException("La tarea no existe"));

            tarea.actualizarCompletado(new Completado(true));
        });
    }
}
