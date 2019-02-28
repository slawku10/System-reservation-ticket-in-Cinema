/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.kino.api.facade;

import application.kino.model.Reservation;
import application.kino.model.Showing;
import application.kino.model.User;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface ReservationFacade extends DefaultFascade<Reservation> {

    List<Reservation> findByShowing(Showing show);

    List<Reservation> findByUser(User user);
}
