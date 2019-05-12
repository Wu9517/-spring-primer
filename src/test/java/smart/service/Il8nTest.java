package smart.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author wzy
 */
@ContextConfiguration("classpath*:/smart-context.xml")
public class Il8nTest extends AbstractTransactionalTestNGSpringContextTests {

    @Test
    public void test() {
        //加载中文资源文件
        ResourceBundle rb1 = ResourceBundle.getBundle("il8n/resource", Locale.CHINA);
        //加载英文资源文件
        ResourceBundle rb2 = ResourceBundle.getBundle("il8n/resource", Locale.ENGLISH);
        System.out.println(rb1.getString("username"));
        System.out.println(rb2.getString("username"));

        //通过ApplicationContext直接访问国际化信息资源
        String[] configs = {"smart-context.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(configs);
        //直接通过容器访问国际化信息资源
        String str1 = context.getMessage("password", new Object[0], Locale.CHINA);
        String str2 = context.getMessage("password", new Object[0], Locale.ENGLISH);
        System.out.println(str1);
        System.out.println(str2);
    }
}
