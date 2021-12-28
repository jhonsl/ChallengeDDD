package co.com.softka.challengeddd.jefe;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.challengeddd.jefe.events.EmpleadoEliminado;
import co.com.softka.challengeddd.jefe.events.JefeCreado;
import co.com.softka.challengeddd.jefe.events.EmpleadoAgregado;
import co.com.softka.challengeddd.jefe.events.TareaCompletada;
import co.com.softka.challengeddd.jefe.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Jefe extends AggregateEvent<IdJefe> {

    protected Nombre nombre;
    protected Edad edad;
    protected Set<Empleado> empleados;
    protected Set<Tarea> tareas;
    protected Set<Horario> horarios;


    public Jefe(IdJefe entityId, Nombre nombre, Edad edad) {
        super(entityId);
        appendChange(new JefeCreado(nombre, edad)).apply();
    }

    private Jefe(IdJefe entityId) {
        super(entityId);
        subscribe(new JefeChange(this));
    }

    public static Jefe from(IdJefe entityId, List<DomainEvent> events) {
        Objects.requireNonNull(entityId);

        var jefe = new Jefe(entityId);
        events.forEach(jefe::applyEvent);

        return jefe;
    }

    public Optional<Empleado> getEmpleadoById(IdEmpleado idEmpleado) {
        Objects.requireNonNull(idEmpleado);

        return empleados()
                .stream()
                .filter(empleado -> empleado.identity().equals(idEmpleado))
                .findFirst();
    }

    public Optional<Tarea> getTareaById(IdTarea idTarea) {
        Objects.requireNonNull(idTarea);

        return tareas()
                .stream()
                .filter(tarea -> tarea.identity().equals(idTarea))
                .findFirst();
    }

    public Optional<Horario> getHorarioById(IdHorario idHorario) {
        Objects.requireNonNull(idHorario);

        return horarios()
                .stream()
                .filter(horario -> horario.identity().equals(idHorario))
                .findFirst();
    }

    public void completarTarea(IdTarea idTarea) {
        Objects.requireNonNull(idTarea);

        appendChange(new TareaCompletada(idTarea)).apply();
    }

    public void agregarEmpleado(IdEmpleado idEmpleado, Nombre nombre, Edad edad, Salario salario) {
        Objects.requireNonNull(idEmpleado);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(salario);

        appendChange(new EmpleadoAgregado(idEmpleado, nombre, edad, salario)).apply();
    }

    public void eliminarEmpleado(IdEmpleado idEmpleado) {
        Objects.requireNonNull(idEmpleado);

        appendChange(new EmpleadoEliminado(idEmpleado)).apply();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Edad edad() {
        return edad;
    }

    public Set<Empleado> empleados() {
        return empleados;
    }

    public Set<Tarea> tareas() {
        return tareas;
    }

    public Set<Horario> horarios() {
        return horarios;
    }
}
