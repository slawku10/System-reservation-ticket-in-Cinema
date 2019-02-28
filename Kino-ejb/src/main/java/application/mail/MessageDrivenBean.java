package application.mail;

import application.kino.api.mail.MailFacade;
import application.kino.model.Mail;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Lenovo
 */
@MessageDriven(mappedName = "jms/queueDest", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
    , @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageDrivenBean implements MessageListener {

    @EJB
    private MailFacade mailFacade;

    public MessageDrivenBean() {
    }

    @Override
    public void onMessage(Message message) {
        ObjectMessage tmp = (ObjectMessage) message;
        try {
            Serializable mail = tmp.getObject();
            mailFacade.sendMail((Mail) mail);
        } catch (JMSException ex) {
            Logger.getLogger(MessageDrivenBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
