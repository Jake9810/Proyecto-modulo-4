package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Local;
import jira.nube.appear.ejb.exception.SaveEntityException;
import jira.nube.appear.ejb.modelo.UsuariosEnt;

import java.util.List;

@Local
public interface UsuariosServiceLocal {
    List<UsuariosEnt>listar(UsuariosEnt entity);
    public UsuariosEnt crear(UsuariosEnt entity) throws SaveEntityException;
    public UsuariosEnt actualiza(UsuariosEnt entity);
    public void borrar(UsuariosEnt entity);
}
