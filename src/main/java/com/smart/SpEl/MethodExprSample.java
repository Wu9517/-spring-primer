package com.smart.SpEl;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author wzy
 */
public class MethodExprSample {
    public static void main(String[] args) {
        SpelHello.User user = new SpelHello().new User("Tom", 100);
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //1.调用String方法
        String subString = parser.parseExpression("'String SpEL'.substring(7)").getValue(String.class);
        System.out.println(subString);
        //调用方法，可调用实例和静态方法，不可调用私有方法
        Boolean isCorrect = parser.parseExpression("isVipMember('Tom')").getValue(context, Boolean.class);
        System.out.println(isCorrect);
    }
}
