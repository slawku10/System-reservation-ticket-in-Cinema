/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.kino.api.pdf;

import application.kino.model.Reservation;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PdfFacade {

    byte[] createPdf(List<Reservation> order);
    
}
