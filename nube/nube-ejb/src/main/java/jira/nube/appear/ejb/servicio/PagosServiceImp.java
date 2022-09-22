package jira.nube.appear.ejb.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jira.nube.appear.ejb.modelo.PagosEnt;

import java.util.List;

public class PagosServiceImp extends AbstractServiceFacade<PagosEnt>
                            implements PagosServiceLocal{

    @PersistenceContext(name="nubeDS")
    private EntityManager em;

    public PagosServiceImp(){
        super(PagosEnt.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<PagosEnt> listar() {
        Query consulta =em.createQuery("from PagosEnt", PagosEnt.class);
        return consulta.getResultList();
    }
}
