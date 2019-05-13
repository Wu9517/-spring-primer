package com.smart.SpEl;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * @author wzy
 */
public class ObjectExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //1.加载java.lang.string
        Class stringClass = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(stringClass == java.lang.String.class);
        //2.调用静态方法
        Object randomValue = parser.parseExpression("T(java.lang.Math).random()").getValue();
        System.out.println(randomValue);
        //3.调用构造器(不能调用内部类)
        SpelHello spelHello = parser.parseExpression("new com.smart.SpEl.SpelHello()")
                .getValue(SpelHello.class);
        System.out.println(spelHello);
        //4.调用变量
        SpelHello.User user = new SpelHello().new User();
        EvaluationContext context = new StandardEvaluationContext(user);
        //为newUserName变量设置新值
        context.setVariable("newUserName", "Tom");
        //取变量值，并赋值
        parser.parseExpression("username=#newUserName").getValue(context);
        System.out.println(user.getUsername());
        //5.this变量值使用及集合List过滤：表达式?[selecExpression]
        List<Integer> lists = new ArrayList<Integer>();
        lists.addAll(Arrays.asList(150, 100, 90, 50, 100, 130, 70));
        context.setVariable("lists", lists);
        List<Integer> list2 = (List<Integer>) parser.parseExpression("#lists.?[#this>100]").getValue(context);
        System.out.println(list2);
        //6.集合Map过滤
        Map<String, Integer> maps = new HashMap<String, Integer>();
        maps.put("Tom", 95);
        maps.put("Jony", 110);
        maps.put("Morin", 85);
        context.setVariable("maps", maps);
        Map<String, Integer> copyMaps = (Map<String, Integer>) parser.parseExpression("#maps.?[value>90]").getValue(context);
        System.out.println(copyMaps);
        //7.集合运算转换：表达式：![projectionExpression]
        context.setVariable("lists", lists);
        List<Boolean> list3 = (List<Boolean>) parser.parseExpression("#lists.![#this>100]").getValue(context);
        System.out.println(list3);

    }
}
