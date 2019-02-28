package application.pdf;

import application.entity.Reservation;
import com.itextpdf.text.DocumentException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Łukasz
 */
@Stateless
public class PdfFacade {

    public byte[] createPdf(List<Reservation> order) {
        ByteArrayOutputStream outStream;
        try {
            outStream = PdfItext.createPdf(order);
            return outStream.toByteArray();
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(PdfFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
