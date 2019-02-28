package application.entity;

import application.entity.Showing;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-19T22:38:44")
@StaticMetamodel(Hall.class)
public class Hall_ { 

    public static volatile CollectionAttribute<Hall, Showing> showingCollection;
    public static volatile SingularAttribute<Hall, Integer> id;
    public static volatile SingularAttribute<Hall, Integer> numOfPlaces;

}