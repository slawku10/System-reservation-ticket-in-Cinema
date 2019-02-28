package application.mail;

import application.mail.Mail;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author Łukasz
 */
@Singleton
public class MailFacade {

    @Resource(name = "mail/kino")
    private Session mailSession;

    public void sendMail(Mail event) {
        try {
            Message m = new MimeMessage(mailSession);
            Address[] to = new InternetAddress[]{new InternetAddress(event.getMailTo())};

            m.setRecipients(Message.RecipientType.TO, to);
            m.setSubject(event.getSubject());
            m.setSentDate(new java.util.Date());
            m.setContent(createMail(event));
            m.saveChanges();

            Transport.send(m);
        } catch (MessagingException e) {
            Logger.getLogger(MailFacade.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Multipart createMail(Mail mailEvent) {
        Multipart multipart = new MimeMultipart();
        try {
            MimeBodyPart text = new MimeBodyPart();
            text.setText(mailEvent.getMessage(), "utf-8");
            multipart.addBodyPart(text);

            MimeBodyPart attachment = new MimeBodyPart();
            ByteArrayDataSource ds = new ByteArrayDataSource(mailEvent.getInputStream(), "application/pdf");
            attachment.setDataHandler(new DataHandler(ds));
            attachment.setFileName("Potwierdzenie.pdf");
            multipart.addBodyPart(attachment);
        } catch (MessagingException | IOException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }

        return multipart;
    }

}
