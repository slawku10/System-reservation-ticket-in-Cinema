package application.entity;

import application.entity.Showing;
import application.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-19T22:38:44")
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile SingularAttribute<Reservation, User> idUser;
    public static volatile SingularAttribute<Reservation, Showing> idShowing;
    public static volatile SingularAttribute<Reservation, String> placeKind;
    public static volatile SingularAttribute<Reservation, Double> price;
    public static volatile SingularAttribute<Reservation, Integer> id;
    public static volatile SingularAttribute<Reservation, Integer> place;
    public static volatile SingularAttribute<Reservation, String> status;

}