package com.java391;

import java.io.*;
import java.util.*;
public class Expression {
    private ArrayList expression = new ArrayList();// 存储中序表达式

    private ArrayList right = new ArrayList();// 存储右序表达式

    private String expresult;// 结果


    public String getExpresult() {
        return expresult;
    }

    // 依据输入信息创建对象，将数值与操作符放入ArrayList中
    Expression(String input) {
        StringTokenizer st = new StringTokenizer(input, "+-*/()", true);
        while (st.hasMoreElements()) {
            String s=st.nextToken();
            expression.add(s);
        }
    }
    //将中序表达式转换为右序表达式
    private void toRight() {
        Stack aStack = new Stack();
        String operator;
        int position = 0;
        while (true) {
            if (Calculate.isOperator((String) expression.get(position))) {
                if (aStack.top == -1
                        || ((String) expression.get(position)).equals("(")) {
                    aStack.push(expression.get(position));
                } else {
                    if (((String) expression.get(position)).equals(")")) {
                        while(true){
                            if (aStack.top != -1&&!((String) aStack.top()).equals("(")) {
                                operator = (String) aStack.pop();
                                right.add(operator);
                            }else{
                                if(aStack.top != -1)
                                    aStack.pop();
                                break;
                            }
                        }
                    } else {
                        while(true){
                            if (aStack.top != -1&& Calculate.priority((String) expression
                                    .get(position)) <= Calculate
                                    .priority((String) aStack.top())
                                    ) {
                                operator = (String) aStack.pop();
                                if (!operator.equals("("))
                                    right.add(operator);
                            }else{
                                break;
                            }

                        }
                        aStack.push(expression.get(position));
                    }
                }
            } else
                right.add(expression.get(position));
            position++;
            if (position >= expression.size())
                break;
        }
        while (aStack.top != -1) {
            operator = (String) aStack.pop();
            if(!operator.equals("("))
                right.add(operator);
        }
    }

    // 对右序表达式进行求值
    boolean getResult() {


        this.toRight();

        Stack aStack = new Stack();
        String op1, op2, is = null;
        String temp="";
        Iterator it = right.iterator();
        while (it.hasNext()) {
            is = (String) it.next();
            if (Calculate.isOperator(is)) {
                op1 = (String) aStack.pop();
                op2 = (String) aStack.pop();
                temp = Calculate.twoResult(is, op1, op2);
                double td = Double.parseDouble(temp.trim());
                if(td==999999.0){
                    return false;

                }
                aStack.push(temp);
            } else
                aStack.push(is);
        }
        expresult = (String) aStack.pop();

        it = expression.iterator();
        while (it.hasNext()) {
            String tempstr = (String) it.next();
            System.out.print(tempstr);

        }
        System.out.println("=" + expresult);
        return true;

    }
}
