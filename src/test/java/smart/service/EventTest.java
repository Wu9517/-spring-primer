package smart.service;

import com.smart.event.MailSender;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author wzy
 */
@ContextConfiguration("classpath*:/smart-context.xml")
public class EventTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("smart-context.xml");
        MailSender mailSender = (MailSender) ctx.getBean("mailSender");
        mailSender.sendMail("aaa@bbb.com");
    }
}
