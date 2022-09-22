package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jira.nube.appear.ejb.modelo.AlumnoEnt;
import jira.nube.appear.ejb.modelo.MateriasEnt;
import jira.nube.appear.ejb.modelo.PagosEnt;

import java.util.List;

@Stateless
public class CatalogosServiceImp implements CatalogosServiceLocal {
    @Inject
    private MateriasServiceLocal materiasSerive;
   /* @Inject
    private PagosServiceLocal pagosService;*/
   @Inject
   private AlumnosServiceLocal alumnosService;

    @Override
    public List<MateriasEnt> getCatalogoMaterias() {
        return materiasSerive.listar();
    }

    /*@Override
    public List<PagosEnt> getCatalogoPagos() {
        return pagosService.listar();
    }*/

    @Override
    public List<AlumnoEnt> getCatalogoAlumnos(){
        return alumnosService.listar();
    }
}
