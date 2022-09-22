package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jira.nube.appear.ejb.modelo.AlumnoEnt;
import jira.nube.appear.ejb.modelo.MateriasEnt;
import jira.nube.appear.ejb.modelo.PagosEnt;

import java.util.List;

@Local
public interface CatalogosServiceLocal {

    List<MateriasEnt> getCatalogoMaterias();
    //List<PagosEnt> getCatalogoPagos();
    public List<AlumnoEnt> getCatalogoAlumnos();
}
