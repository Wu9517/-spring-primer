package com.smart.SpEl;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author wzy
 */
public class OperatorExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //1.关系运算符
        boolean trueValue = parser.parseExpression("2==2").getValue(Boolean.class);
        System.out.println(trueValue);
        //2.字符串比较符
        trueValue = parser.parseExpression("\"black\"<\"block\"").getValue(Boolean.class);
        System.out.println(trueValue);
        //3.nstanceof运算符
        trueValue = parser.parseExpression("'xzy' instanceof T(int)").getValue(Boolean.class);
        System.out.println(trueValue);
        //4.正则运算符
        trueValue = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        System.out.println(trueValue);
        //5.逻辑运算符
        trueValue = parser.parseExpression("true && false").getValue(Boolean.class);
        System.out.println(trueValue);
        //6.算术运算符
        Integer sum = parser.parseExpression("1+1").getValue(Integer.class);
        System.out.println(sum);
        String sum2 = parser.parseExpression("'Hello'+' '+'world '").getValue(String.class);
        System.out.println(sum2);
        //7.安全导航运算符（Groovy语言），验证对象是否为空
        SpelHello.User user = new SpelHello().new User("Tom", 100);
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        String city = parser.parseExpression("address?.city").getValue(context, String.class);
        //没有值是会打印null，而不会报空指针异常
        System.out.println(city);
        //8.三元运算符
        String result = parser.parseExpression("'Hello'=='world'?'Hello':'world'").getValue(String.class);
        System.out.println(result);
        //Elvis,Groove的三目运算符：<var>?:<value>
        result = parser.parseExpression("username?:'用户名为空'").getValue(context, String.class);
        System.out.println(result);

    }
}
