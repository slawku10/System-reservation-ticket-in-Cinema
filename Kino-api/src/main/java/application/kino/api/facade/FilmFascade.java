/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.kino.api.facade;

import application.kino.model.Film;
import javax.ejb.Remote;

@Remote
public interface FilmFascade  extends DefaultFascade<Film> {
    
}
