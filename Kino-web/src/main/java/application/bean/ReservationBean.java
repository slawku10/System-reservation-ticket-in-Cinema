package application.bean;

import application.kino.model.Reservation;
import application.kino.model.Showing;
import application.kino.api.facade.ReservationFacade;
import application.kino.api.mail.MailFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Lenovo
 */
@Named("reservationBean")
@SessionScoped
public class ReservationBean implements Serializable {

    @EJB
    private MailFacade mailFacade;
    @EJB
    private ReservationFacade reservationFacade;
    private List<Reservation> reservations;
    private List<Integer> freePlaces;

    @PostConstruct
    public void init() {
    }

    public String ticketReserve(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            reservationFacade.create(reservation);
        }

        return "ticketReserved";
    }

    public void ticketBuy() {

    }

    public void ticketCancelReservation() {

    }

    public String ticketUpdatePrices(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            if ("normalny".equals(reservation.getPlaceKind())) {
                reservation.setPrice(Showing.DEFAOULT_PRICE);
            } else if ("ulgowy".equals(reservation.getPlaceKind())) {
                reservation.setPrice(Showing.DEFAOULT_PRICE / 2);
            }
        }

        return "toConfirm";
    }

    public List<Integer> findFreePlaces(Showing show) {
        List<Integer> reservedPlaces = new ArrayList<>();
        reservations = reservationFacade.findByShowing(show);
        for (Reservation r : reservations) {
            reservedPlaces.add(r.getPlace());
        }

        freePlaces = new ArrayList<>();
        for (int i = 1; i < show.getIdHall().getNumOfPlaces() + 1; i++) {
            freePlaces.add(i);
        }

        for (Iterator<Integer> it = reservedPlaces.iterator(); it.hasNext();) {
            Integer i = it.next();
            freePlaces.remove(i);
        }

        return freePlaces;
    }

    public void cancelReservation(Reservation r) {
        reservationFacade.remove(r);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Integer> getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(List<Integer> freePlaces) {
        this.freePlaces = freePlaces;
    }

}
