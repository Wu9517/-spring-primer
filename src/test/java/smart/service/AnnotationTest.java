package smart.service;

import com.smart.annotation.NeedTest;
import com.smart.event.MailSender;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import java.lang.reflect.Method;

/**
 * @author wzy
 */
@ContextConfiguration("classpath*:/smart-context.xml")
public class AnnotationTest {
    @Test
    public void test() {
        Class clazz = MailSender.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            //获取方法上所标注的注解对象
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
