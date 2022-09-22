package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Local;
import jira.nube.appear.ejb.exception.SaveEntityException;
import jira.nube.appear.ejb.modelo.MateriasEnt;

import java.util.List;

@Local
public interface MateriasServiceLocal {

    List<MateriasEnt> listar();
    public MateriasEnt crear(MateriasEnt entity) throws SaveEntityException;
    public MateriasEnt actualiza(MateriasEnt entity);
    public void borrar(MateriasEnt entity);

    public MateriasEnt getMateria(Integer id);

}
