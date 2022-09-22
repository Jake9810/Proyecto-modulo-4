package jira.nube.appear.ejb.servicio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jira.nube.appear.ejb.modelo.UsuariosEnt;

import java.util.List;

@Stateless
public class UsuariosServiceImp extends AbstractServiceFacade<UsuariosEnt>
                                implements UsuariosServiceLocal{
    @PersistenceContext(name="nubeDS")
    private EntityManager em;

    public UsuariosServiceImp(){
        super(UsuariosEnt.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<UsuariosEnt> listar(UsuariosEnt entity) {
        Query consulta=em.createQuery("from UsuariosEnt",UsuariosEnt.class);
        return consulta.getResultList();
    }
}
