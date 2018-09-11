package com.java6369.lesson01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MathExam6369 {
	private static int n;
	private static final String[] fuhao = {"+", "-"};
	static StringBuffer Topic = new StringBuffer(); 
	static StringBuffer Answer= new StringBuffer(); 

public static void main(String[] args) throws IOException {
	if (args.length == 0) {
        throw new IllegalArgumentException("不能输入零个参数");
    }
    String str = args[0].replaceFirst("^0*", "");
    if(str.length()>3) {
    	throw new IllegalArgumentException("参数过大");
    }
    for(int i =0;(str.charAt(i) < '0' || str.charAt(i++) > '9') && i < str.length();i++) {
    	throw new IllegalArgumentException("不要输入非数字");
    }
    n = Integer.parseInt(args[0]);
    Exam369();
    writeTo();
    System.out.println("一年级加减法请查看out.txt");
}
    private static void Exam369() {
        int result = 0; 
        int num1,num2,subScript;
		for (int i = 1; i <= n ; i++) {
			 num1 = (int) (Math.random() * 101);
			 num2 = (int) (Math.random() * 101);
			 subScript = (int) (Math.random() *2);
			String symbol = fuhao[subScript];
			switch (symbol) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				if (num1 <num2) {
					int m = num1;
					num1 = m;
					m = num2;
				}
				result =num1 - num2;
				break;
			default:
				System.out.println("unsupported sign!");
			}
			// 记录题目与答案
			Topic.append("("+i+") "+ num1 + " " + symbol + " " + num2 + "\r\n");
			Answer.append("("+i+") "+num1+" "+symbol+" "+num2+" "+"= "+result+ "\r\n");
		}
    }
    public static void writeTo() throws IOException {
    	  File file= new File("out.txt");
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			file.createNewFile();
		}
		OutputStream out = new FileOutputStream(file);
		byte[] question=Topic.toString().getBytes();
		byte[] answer=Answer.toString().getBytes();
		out.write(question);
		out.write(System.lineSeparator().getBytes());
		out.write(answer);
		out.close();
    }
}


