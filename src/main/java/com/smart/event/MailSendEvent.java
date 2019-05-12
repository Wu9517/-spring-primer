package com.smart.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author wzy
 */
public class MailSendEvent extends ApplicationContextEvent {

    //发送目的地
    private String to;

    public MailSendEvent(ApplicationContext source) {
        super(source);
    }

    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
