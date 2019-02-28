package application.kino.model;

import application.kino.model.Showing;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-28T12:54:46")
@StaticMetamodel(Hall.class)
public class Hall_ { 

    public static volatile CollectionAttribute<Hall, Showing> showingCollection;
    public static volatile SingularAttribute<Hall, Integer> id;
    public static volatile SingularAttribute<Hall, Integer> numOfPlaces;

}