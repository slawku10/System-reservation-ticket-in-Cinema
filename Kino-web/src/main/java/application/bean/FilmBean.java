package application.bean;

import application.kino.api.facade.FilmFascade;
import application.kino.model.Film;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "filmBean")
@RequestScoped
public class FilmBean {

    @EJB
    private FilmFascade filmFascade;

    private Film film;

    @PostConstruct
    public void init() {
        film = new Film();
    }

    public FilmBean() {
    }

    public List<Film> findAll() {
        return filmFascade.findAll();
    }

    public String addFilm() {
        filmFascade.create(film);
        return "success";
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

}
