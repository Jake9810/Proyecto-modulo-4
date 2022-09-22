package jira.nube.appear.ejb.servicio;

import jira.nube.appear.ejb.exception.SaveEntityException;
import jira.nube.appear.ejb.modelo.AlumnoEnt;



import java.util.List;

public interface AlumnosServiceLocal {

    List<AlumnoEnt> listar();
    public AlumnoEnt crear(AlumnoEnt entity) throws SaveEntityException;
    public  AlumnoEnt actualiza(AlumnoEnt entity);

    public void borrar(AlumnoEnt entity);

    public AlumnoEnt getAlumno(Integer id);
}
