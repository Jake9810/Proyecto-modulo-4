package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Local;
import jira.nube.appear.ejb.exception.SaveEntityException;
import jira.nube.appear.ejb.modelo.CalificacionesEnt;
import jira.nube.appear.ejb.modelo.KumonEnt;

import java.util.List;

@Local
public interface CalificacionesServiceLocal {

    List<CalificacionesEnt> listar();
    public CalificacionesEnt crear(CalificacionesEnt entity) throws SaveEntityException;
    public CalificacionesEnt actualiza(CalificacionesEnt entity);
    public void borrar(CalificacionesEnt entity);
}
