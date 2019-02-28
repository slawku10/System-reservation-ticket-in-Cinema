package application.entity;

import application.entity.Film;
import application.entity.Hall;
import application.entity.Reservation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-19T22:38:44")
@StaticMetamodel(Showing.class)
public class Showing_ { 

    public static volatile SingularAttribute<Showing, Film> idFilm;
    public static volatile SingularAttribute<Showing, Hall> idHall;
    public static volatile SingularAttribute<Showing, Date> dateStart;
    public static volatile CollectionAttribute<Showing, Reservation> reservationCollection;
    public static volatile SingularAttribute<Showing, Integer> id;
    public static volatile SingularAttribute<Showing, Date> dateEnd;

}