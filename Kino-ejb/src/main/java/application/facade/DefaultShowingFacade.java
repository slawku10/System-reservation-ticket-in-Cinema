/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.facade;

import application.kino.api.facade.ShowingFacade;
import application.kino.model.Showing;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class DefaultShowingFacade extends AbstractFacade<Showing> implements ShowingFacade {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DefaultShowingFacade() {
        super(Showing.class);
    }
    
}
