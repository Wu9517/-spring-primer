package com.smart.event;

import org.springframework.context.ApplicationListener;

/**
 * @author wzy
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {

    //队MailSendEvent事件进行处理
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mailSendEvent = event;
        System.out.println("MailSendEvent:向" + mailSendEvent.getTo() + "发送完一封邮件！");
    }
}
