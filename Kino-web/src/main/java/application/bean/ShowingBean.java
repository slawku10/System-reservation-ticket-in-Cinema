package application.bean;

import application.kino.model.Film;
import application.kino.model.Hall;
import application.kino.model.Showing;
import application.kino.api.facade.ShowingFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Lenovo
 */
@Named("showingBean")
@SessionScoped
public class ShowingBean implements Serializable {

    @EJB
    private ShowingFacade showingFacade;
    private List<Showing> showings;
    private Showing showing;

    @PostConstruct
    public void init() {
        showing = new Showing();
    }

    public List<Showing> findAllShowings() {
        showings = showingFacade.findAll();
        return showings;
    }

    public String addShow() {
        showingFacade.create(showing);
        return "success";
    }

    public void setHall(Hall hall) {
        showing.setIdHall(hall);
    }

    public void setFilm(Film film) {
        showing.setIdFilm(film);
    }

    public List<Showing> getShowings() {
        return showings;
    }

    public void setShowings(List<Showing> showings) {
        this.showings = showings;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

}
