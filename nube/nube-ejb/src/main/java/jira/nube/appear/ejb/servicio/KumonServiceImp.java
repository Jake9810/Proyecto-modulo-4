package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jira.nube.appear.ejb.exception.SaveEntityException;
import jira.nube.appear.ejb.modelo.KumonEnt;


import java.util.List;

@Stateless
public class KumonServiceImp extends AbstractServiceFacade<KumonEnt>
                                implements KumonServiceLocal {

    @PersistenceContext(name="nubeDS")
    private EntityManager em;

    public KumonServiceImp(){
        super(KumonEnt.class);
    }



    @Override
    public List listar() {
        Query consulta=em.createQuery("from KumonEnt", KumonEnt.class);
        return consulta.getResultList();
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }



}
