package com.smart.SpEl;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.Map;

/**
 * @author wzy
 */
public class CollectionExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //1.数组表达式解析
        int[] array1 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue();
        int[][] array2 = (int[][]) parser.parseExpression("new int[2][3]").getValue();
        System.out.println(array1);
        System.out.println(array2);

        //2.list表达式解析

        List list = (List) parser.parseExpression("{1,2,3,4,5}").getValue();
        System.out.println(list);
        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue();
        System.out.println(listOfLists);

        //3.列表字符串解析
        Map userInfo = (Map) parser.parseExpression("{username:'Tom',credits:100}").getValue();
        List userInfo2 = (List) parser.parseExpression("{{username:'Tome',credits:100},{username:'Tome',credits:100}}").getValue();
        System.out.println(userInfo);
        System.out.println(userInfo2);

        //4.从数组，List,Map中取值
        //数组，List取值
        SpelHello.User user = new SpelHello().new User();
        user.setLists(list);
        EvaluationContext context = new StandardEvaluationContext(user);
        Integer interest1 = (Integer) parser.parseExpression("lists[0]").getValue(context);
        System.out.println(interest1);
        //Map中取值
        user.setMaps(userInfo);
        String interest2 = (String) parser.parseExpression("maps['username']").getValue(context);
        System.out.println(interest2);
    }

}
