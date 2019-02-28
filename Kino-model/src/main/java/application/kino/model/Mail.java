package application.kino.model;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class Mail implements Serializable {

    private String mailTo;
    private String subject;
    private String message;
    private byte[] attachment;

    public ByteArrayInputStream getInputStream() {
        return new ByteArrayInputStream(attachment);
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

}
