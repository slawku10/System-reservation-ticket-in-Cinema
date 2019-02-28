/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.facade;

import application.kino.api.facade.FilmFascade;
import application.kino.model.Film;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class DefaultFilmFacade extends AbstractFacade<Film> implements FilmFascade {

    @PersistenceContext(unitName = "cinemaPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DefaultFilmFacade() {
        super(Film.class);
    }
    
}
