/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.facade;

import application.kino.api.facade.ReservationFacade;
import application.kino.model.Reservation;
import application.kino.model.Showing;
import application.kino.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lenovo
 */
@Stateless
public class DefaultReservationFacade extends AbstractFacade<Reservation> implements ReservationFacade{

    @PersistenceContext(unitName = "cinemaPersistence")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DefaultReservationFacade() {
        super(Reservation.class);
    }

    public List<Reservation> findByUser(User user) {
        try {
            Query namedQuery = em.createNamedQuery("Reservation.findByUser").setParameter("userId", user.getId());
            return (List<Reservation>) namedQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Reservation> findByShowing(Showing show) {
        try {
            Query namedQuery = em.createNamedQuery("Reservation.findByShowing").setParameter("showingId", show.getId());
            return (List<Reservation>) namedQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }


}
