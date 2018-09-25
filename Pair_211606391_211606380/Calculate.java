package com.java391;

public class Calculate {
	// 判断是否为操作符号
    public static boolean isOperator(String operator) {
        if (operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("/")
                || operator.equals("(") || operator.equals(")"))
            return true;
        else
            return false;
    }
 // 设置操作符号的优先级别
    public static int priority(String operator) {
        if (operator.equals("+") || operator.equals("-"))
            return 1;
        else if (operator.equals("*") || operator.equals("/"))
            return 2;
        else
            return 0;
    }
 // 做2值之间的计算
    public static String twoResult(String operator, String a, String b) {
        try {
            String op = operator;
            String rs = new String();
            double x = Double.parseDouble(b);
            double y = Double.parseDouble(a);
            boolean f = true;

            double z = 0.0;
            if (op.equals("+"))
                z = x + y;
            else if (op.equals("-"))
                z = x - y;
            else if (op.equals("*"))
                z = x * y;
            else if (op.equals("/"))
            {
                if(y==0) {
                    y=1;
                    z=999999;
                }
                z = x / y;
                if(z*y!=x) z=999999;
            }
            else
                z = 999999;
            if(z<0) z=999999;
            if(z!=(int)z) z=999999;
            return String.valueOf(z);
        } catch (NumberFormatException e) {
            System.out.println("input has something wrong!");
            return "Error";
        }
    }
}
