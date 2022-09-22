package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jira.nube.appear.ejb.modelo.CalificacionesEnt;

import java.util.List;

@Stateless
public class CalificacionesServiceImp extends AbstractServiceFacade<CalificacionesEnt>
                                        implements CalificacionesServiceLocal{

    @PersistenceContext(name="nubeDS")
    private EntityManager em;
    public CalificacionesServiceImp(){
        super(CalificacionesEnt.class);
    }

    @Override
    public List<CalificacionesEnt> listar() {
        Query consulta=em.createQuery("from CalificacionesEnt",CalificacionesEnt.class);
        return consulta.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
