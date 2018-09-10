package com.PSP6302;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MathExam6302 {
	@SuppressWarnings("unused")
	private static int len;
	private static final String[] Operator = {"+", "-"};
	static StringBuffer problem = new StringBuffer(); 
	static StringBuffer answer= new StringBuffer(); 

@SuppressWarnings("unused")
public static void main(String[] args) throws IOException {
	String str = args[0].replaceFirst("^0*", "");
	if (args.length == 0) {
        throw new IllegalArgumentException("参数不为零");
    }
    if(str.length()>4) {
    	throw new IllegalArgumentException("参数过大");
    }
    for(int i =0;(str.charAt(i) < '0' || str.charAt(i++) > '9') && i < str.length();i++) {
    	throw new IllegalArgumentException("不要输入非数字");
    }
    len= Integer.parseInt(args[0]);
    MathExam();
    write6302();
    System.out.println("一年级加减法请查看out.txt");
}
    private static void MathExam() {
        int result = 0; 
        int num1,num2,m;
        //SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd HH:mm");
		for (int i = 1; i <= len ; i++) {
			 num1 = (int) (Math.random() * 101);
			 num2 = (int) (Math.random() * 101);
			 m = (int) (Math.random() *2);
			String symbol = Operator[m];
			switch (symbol) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				if (num1 <num2) {
					int t = num1;
					num1 = t;
					t = num2;
				}
				result =num1 - num2;
				break;
			default:
				System.out.println("unsupported sign!");
			}
			// 记录题目与答案
			problem.append("("+i+") "+ num1 + " " + symbol + " " + num2 + "\r\n");
			//problem.append("----------标准答案----------");
			answer.append("("+i+") "+num1+" "+symbol+" "+num2+" "+"= "+result+ "\r\n");
		}
		answer.append("211606302 曾丽丽 "+DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,Locale.CHINESE).format(new java.util.Date()));
    }
    public static void write6302() throws IOException {
		// 步骤1：确定输出的文件（目的地）
		// 如果filename中包含路径，必须确保路径已存在
		File file = new File("out.txt");
		File parentFile = file.getParentFile();
		if (parentFile != null && !parentFile.exists()) {
			parentFile.mkdirs();
			System.out.println("创建目录：" + parentFile);
		}
		file.createNewFile();
		// 步骤2：创建指向文件的输出流
		OutputStream out = new FileOutputStream(file);
		// 步骤3：写入数据
		out.write(problem.toString().getBytes());
		out.write(System.lineSeparator().getBytes());
		out.write(answer.toString().getBytes());
		// 步骤4：关闭
		out.close();
}
}
