package jira.nube.appear.ejb.servicio;

import jakarta.persistence.EntityManager;
import jira.nube.appear.ejb.exception.SaveEntityException;
public abstract class AbstractServiceFacade<T> {

    private Class<T> claseEntiddad;

    public AbstractServiceFacade(Class<T> claseEntiddad){
        this.claseEntiddad=claseEntiddad;
    }

    public T crear(T entidad) throws SaveEntityException{
        EntityManager em=getEntityManager();
        em.persist(entidad);
        return entidad;
    }

    public T actualiza(T entidad){
        T entcopia;
        if(entidad!=null){
            entcopia=getEntityManager().merge(entidad);
            return  entcopia;
        }
        return null;
    }

    public void borrar(T entidad){
        getEntityManager().remove(getEntityManager().merge(entidad));
    }
    abstract protected EntityManager getEntityManager();

}
