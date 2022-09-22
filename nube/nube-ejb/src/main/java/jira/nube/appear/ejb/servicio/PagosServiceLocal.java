package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Local;
import jira.nube.appear.ejb.exception.SaveEntityException;
import jira.nube.appear.ejb.modelo.PagosEnt;


import java.util.List;

@Local
public interface PagosServiceLocal {

    List<PagosEnt> listar();
    public PagosEnt crear(PagosEnt entity) throws SaveEntityException;
    public PagosEnt actualiza(PagosEnt entity);
    public void borrar(PagosEnt entity);
}
