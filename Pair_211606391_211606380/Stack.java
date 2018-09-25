package com.java391;

import java.util.*;
public class Stack {
    private LinkedList list=new LinkedList();
    int top=-1;
    public void push(Object value){
        top++;
        list.addFirst(value);
    }
    public Object pop(){
        Object temp=list.getFirst();
        top--;
        list.removeFirst();
        return temp;

    }
    public Object top(){
        return list.getFirst();
    }

}
