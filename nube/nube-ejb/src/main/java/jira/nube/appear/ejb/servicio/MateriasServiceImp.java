package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jira.nube.appear.ejb.modelo.MateriasEnt;

import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class MateriasServiceImp extends AbstractServiceFacade<MateriasEnt>
                                implements MateriasServiceLocal{

    @PersistenceContext(name="nubeDS")
    private EntityManager em;

    public MateriasServiceImp(){
        super(MateriasEnt.class);
    }

    @Override
    public MateriasEnt getMateria(Integer id) {
        return em.find(MateriasEnt.class,id);
    }

    @Override
    public List<MateriasEnt> listar(){
        Query consulta=em.createQuery("from MateriasEnt",MateriasEnt.class);
        return consulta.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
