package application.bean;

import application.kino.model.Hall;
import application.kino.api.facade.HallFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Lenovo
 */
@Named("hallBean")
@SessionScoped
public class HallBean implements Serializable {

    @EJB
    private HallFacade hallFacade;
    private List<Hall> halls;

    public List<Hall> findAllHalls() {
        halls = hallFacade.findAll();
        return halls;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

}
