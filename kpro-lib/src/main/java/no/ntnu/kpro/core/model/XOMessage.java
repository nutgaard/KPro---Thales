/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.kpro.core.model;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Nicklas
 */
public class XOMessage implements Comparable<XOMessage> {
    private final String from;
    private final String to;
    private final String subject;
    private final List<InputStream> attachments;
    private final String htmlBody;
    private final String strippedBody;
    private final XOMessageGrading grading;
    private final XOMessagePriority priority;
    private final XOMessageType type;

    public XOMessage(String from, String to, String subject, String body) {
        this(from, to, subject, body, XOMessageGrading.BEGRENSET, XOMessagePriority.DEFERRED, XOMessageType.DRILL);
    }

    public XOMessage(String from, String to, String subject, String body, XOMessageGrading grading, XOMessagePriority priority, XOMessageType type) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.attachments = new LinkedList<InputStream>();
        this.htmlBody = body;
        this.strippedBody = body.replaceAll("\\<.*?>","");
        this.grading = grading;
        this.priority = priority;
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }
    public void addAttachment(InputStream is) {
        this.attachments.add(is);
    }
    public List<InputStream> getAttachments() {
        return attachments;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public String getStrippedBody() {
        return strippedBody;
    }

    public XOMessageGrading getGrading() {
        return grading;
    }

    public XOMessagePriority getPriority() {
        return priority;
    }

    public XOMessageType getType() {
        return type;
    }

    public int compareTo(XOMessage o) {
        return 0;
    }

    @Override
    public String toString() {
        return "XOMessage{" + "from=" + from + ", to=" + to + ", subject=" + subject + ", strippedBody=" + strippedBody + '}';
    }
    
}
