package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jira.nube.appear.ejb.modelo.AlumnoEnt;

import java.util.List;


@Stateless
public class AlumnosServiceImp extends AbstractServiceFacade<AlumnoEnt>
                                implements AlumnosServiceLocal{

    @PersistenceContext(name="nubeDS")
    private EntityManager em;

    public AlumnosServiceImp(){
        super(AlumnoEnt.class);
    }

    @Override
    public List<AlumnoEnt> listar() {
        Query consulta=em.createQuery("from AlumnoEnt",AlumnoEnt.class);
        return consulta.getResultList();
    }

    @Override
    public AlumnoEnt getAlumno(Integer id) {
        return em.find(AlumnoEnt.class, id);
    }



    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
