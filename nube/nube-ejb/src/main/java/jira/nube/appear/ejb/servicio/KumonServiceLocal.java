package jira.nube.appear.ejb.servicio;


import jakarta.ejb.Local;
import jira.nube.appear.ejb.exception.SaveEntityException;
import jira.nube.appear.ejb.modelo.KumonEnt;

import java.util.List;

@Local
public interface KumonServiceLocal {

    List<KumonEnt> listar();
    public KumonEnt crear(KumonEnt entity) throws SaveEntityException;;
    public KumonEnt actualiza(KumonEnt entity);
    public void borrar(KumonEnt entity);
}
