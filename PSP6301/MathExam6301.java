import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MathExam6301 {
	//测试参数大小
	public static void para(int n1){
		if(n1>0 && n1<=50) {
			operation(n1);
		}
		else if(n1>50) {
			System.out.println("题数输入的数字太大！");
	}
		else{
			System.out.println("题数需为正整数！");
	}

}
	//测试参数首位
	private static void number(String args1, int num){  
		int g=0;
		for(int i=0;i<args1.length();i++) {
			if(args1.charAt(i)!='0') {g++;}
			else {break;}
		}
			if(g>0) {
				para(num);	
			}
			else if(g==0) {
				System.out.println("题数首位不可为0！");
			}
		}
	//运算
	public static void operation(int n){
		File file = new File("out.txt");
		OutputStream out;
		try {
			out = new FileOutputStream(file);
			int[] an= new int[n];
			String random = "";
			String[] Symbol= {"+","-"};
				for(int i=0;i<n;i++) {
					int index = (int)(Math.random()*(Symbol.length));
					random = Symbol[index]; //随机调用Symbol1中的元素
					if(random.equals("+")) {
						int a = (int)(Math.random()*(50+1));//随机选择0~50之间的数
						int b = (int)(Math.random()*(50+1));
						System.out.printf("("+(i+1)+") "+a+" + "+b+" = "+"\n");
						an[i]=a+b;
						String output = "("+(i+1)+") "+a+" + "+b+" = "+"\n";
						out.write(output.getBytes());
					}
					else{
						int a = (int)(Math.random()*(100+1));
						int b = (int)(Math.random()*a);
						System.out.printf("("+(i+1)+") "+a+" - "+b+" = "+"\n");
						an[i]=a-b;
						String output = "("+(i+1)+") "+a+" - "+b+" = "+"\n";
						out.write(output.getBytes());
						}
				}
			
			
			String flag = "\n";
			out.write(flag.getBytes());
			//输入答案
			Scanner in = new Scanner(file);
			int j=0;
			while(in.hasNextLine()&&j!=n) {
				String s = in.nextLine()+an[j]+"\n";
				out.write(s.getBytes());
				j++;
			}
			//时间
			Date date = new Date();
			String time = "yyyy年MM月 dd日  HH:mm";
			SimpleDateFormat sdf = new SimpleDateFormat(time);
			String now = "			211606301   蔡振翼    "+sdf.format(date)+"\n";
			out.write(now.getBytes());
			out.close();
		} catch (IOException e) {
			System.out.println("抛异常");
		}
	}
	public static void main(String[] args){
		int [] num = new int[args.length];	
		String regex = "\\d*";
		if(args.length==0) {
			System.out.println("请输入参数！");
		}
		else if(args[0].matches(regex)) {//判断第一个参数是否是数字
			num[0]=Integer.parseInt(args[0]);  //将第一个参数从String转化为Int
			if(args.length>=2) {
				System.out.println("只可输入一个参数！");
			}
			
			else{
				number(args[0],num[0]);	
			}
			}
		else {
			System.out.println("题数需为正整数！");
		}
		}
	}

