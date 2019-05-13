package com.smart.SpEl;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wzy
 */
public class SpelHello {
    public static void main(String[] args) {
        //SpEL支出方法调用、属性调用及构造器调用等一系列调用方式。
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello'+' world'");
        String message = (String) exp.getValue();
        System.out.println(message);

        Expression exp2 = parser.parseExpression("'HelloWorld'.concat('!')");
        String message2 = (String) exp2.getValue();
        System.out.println(message2);

        User user = new SpelHello().new User("tom", 100);
        //指定user这个根对象作为求值目标对象，这样在求值表达式中就可以引用根对象属性
        EvaluationContext context = new StandardEvaluationContext(user);
        //获取属性值
        String username = (String) parser.parseExpression("username").getValue(context);
        System.out.println(username);
        //修改属性值
        parser.parseExpression("username").setValue(context, "bruch");
        System.out.println(user.getUsername());

        //SpEL编译器
        //1.创建解析设置
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, Compiler.class.getClassLoader());
        //2创建解析器
        SpelExpressionParser parser1 = new SpelExpressionParser(config);
        //3.表达式
        String expression = "isVipMember('Tom') && isVipMember('bruch')";
        //4.解析表达式
        SpelExpression spelExpression = parser1.parseRaw(expression);
        //5.通过表达式求值
        System.out.println(spelExpression.getValue(context));

    }

    class User {
        private String username;
        private Integer credits;
        private List lists;
        private Map maps;
        private Address address;

        public User() {
        }

        public User(String username, Integer credits) {
            this.username = username;
            this.credits = credits;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getCredits() {
            return credits;
        }

        public void setCredits(Integer credits) {
            this.credits = credits;
        }

        public List getLists() {
            return lists;
        }

        public void setLists(List lists) {
            this.lists = lists;
        }

        public Map getMaps() {
            return maps;
        }

        public void setMaps(Map maps) {
            this.maps = maps;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public boolean isVipMember(String username) {
            if (username.equals("Tom")) {
                return true;
            } else {
                return false;
            }
        }

        class Address {
            String province;
            Date city;

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public Date getCity() {
                return city;
            }

            public void setCity(Date city) {
                this.city = city;
            }
        }
    }
}
