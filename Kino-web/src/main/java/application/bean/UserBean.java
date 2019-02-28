package application.bean;

import application.kino.model.Reservation;
import application.kino.model.Showing;
import application.kino.model.User;
import application.kino.api.facade.ReservationFacade;
import application.kino.api.facade.UserFacade;
import application.kino.model.Mail;
import application.kino.api.pdf.PdfFacade;
import application.web.filter.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private ReservationFacade reservationFacade;
    @EJB
    private PdfFacade pdfFacade;
    @EJB
    private UserFacade userFacade;

    @Resource(mappedName = "jms/queueDest")
    private Queue queueDest;
    @Inject
    @JMSConnectionFactory("jms/queue")
    private JMSContext context;

    private User user;
    private Showing showing;

    private List<Reservation> myReservations;
//    private List<String> ticketKinds;

    @PostConstruct
    public void init() {
        user = new User();
        user.setRole("notEmployee");
        myReservations = new ArrayList<>();
    }

    public String register() {
        userFacade.create(user);
        return "success";
    }

    public String login() {
        if ((user = userFacade.login(user)) != null) {
            if ("employee".equals(user.getRole())) {
                HttpSession session = Util.getSession();
                session.setAttribute("user", user);
                return "adminUser";
            }
            HttpSession session = Util.getSession();
            session.setAttribute("user", user);
            return "success";
        } else {
            return "fail";
        }
    }

    public String selectShow(Showing showing) {
        setShowing(showing);
        return "hallSelected";
    }

    public void addReservation(int place) {
        Reservation reservation = new Reservation();
        reservation.setPlace(place);
        reservation.setIdShowing(showing);
        reservation.setIdUser(user);
        reservation.setStatus("rezerwacja");
        reservation.setPrice(Showing.DEFAOULT_PRICE);

        myReservations.add(reservation);
    }

    public void sendEmailConfirmation() {
        Mail mail = new Mail();
        mail.setMailTo(user.getEmail());
        mail.setMessage("Potwierdzenie rezerwacji");
        mail.setSubject("KinoCK potwierdzenie rezerwacji");
        mail.setAttachment(pdfFacade.createPdf(myReservations));

        sendJMSMessageToQueueDest(mail);
    }

    private void sendJMSMessageToQueueDest(Mail mail) {
        try {
            ObjectMessage message = context.createObjectMessage();
            message.setObject(mail);
            context.createProducer().send(queueDest, message);
        } catch (JMSException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Reservation> findMyReservations() {
        myReservations = reservationFacade.findByUser(user);
        return myReservations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reservation> getMyReservations() {
        return myReservations;
    }

    public void setMyReservations(List<Reservation> myReservations) {
        this.myReservations = myReservations;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

}
