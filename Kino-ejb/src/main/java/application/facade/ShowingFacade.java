/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.facade;

import application.entity.Showing;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Łukasz
 */
@Stateless
public class ShowingFacade extends AbstractFacade<Showing> {

    @PersistenceContext(unitName = "cinemaPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShowingFacade() {
        super(Showing.class);
    }
    
}
