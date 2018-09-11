package Autyunsuan;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

//import java.util.Scanner;  //不需要这个


public class MathExam6388 {

	private static int n1,n2,x;    //定义三个静态成员
	private static String[] str1 ;
	private static String sun;   //创建新对象字符串

	public static void main(String args[]) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		int i =Integer.valueOf(args[0]).intValue();   //题目
		int g =Integer.valueOf(args[1]).intValue();   //年级
		//输出保存在文件中
		File file = new File("out6388.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		choiceGrade(i, g);
		
	}	
//	try { 
//		  while (b) { 
//			  System.out.print("请确认输入的题数(正整数)："); 
//			  String s = (String) br.readLine(); 
//			  for (int j = 0; j < s.length(); j++) { 
//				  if (!(s.charAt(j) >= 48 && s.charAt(j) <= 57)) {
//					  System.out.println("您输入的不是正整数!请重新输入."); 
//					  b = true; 
//					  break; 
//		} 
//		  else {
//			  b = false; 
//			  }
//		} 
//		    if (!b) { 
//		    int i = Integer.parseInt(s);
//		     if(i==0){
//		      System.out.println("您输入的不是正整数!请重新输入.");
//		      break;
//		     }
//		     
//		     System.out.println("您输入的是:" + i); 
//		    } 
//		   } 
//		  }
	//一年级加减法
	public static void G1( int n ) {
		str1 = new String[n];
		for (int i = 0; i < n ; i++) {
			int x = (int)(Math.random()*100+1);
			int y = (int)(Math.random()*100+1);
			int z = (int)(Math.random()*100+1);
			// 判断加法和减法 
//			for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
//				int n1 = (int)(Math.random()*100+1);
//				int n2 = (int)(Math.random()*100+1);
//				if(n1 > n2) {
//					if(n2 >= 10)
//						n2 = n2%10*10;
//					System.out.println("("+ i +") " + n1 +" - "+ n2 );
//					String str = ("("+ i +") " + n1 +" - "+ n2 + " = " + (n1-n2));
//					out.writeUTF(str);
//				}	
//				else {
//					if(n2 >= 10)
//						n2 = n2%10*10;
//					System.out.println("("+ i +") " + n1 +" + "+ n2 );
//					String str = ("("+ i +") " + n1 +" + "+ n2 + " = " + (n1+n2));
//					out.writeUTF(str);;
//				}
//			}
			if ( z == 0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " ");
				str1[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);
			}
			else {
				if (x-y < 0) {
					System.out.println("(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " ");
					str1[i] = "(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " " + (y-x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " ");
					str1[i] = "(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " " + (x-y);
				}
			}
		}
//		out.close
		System.out.println("------------标准答案------------");//输出答案
		for(String a:str1)
			System.out.println(a);
		SimpleDateFormat time = new SimpleDateFormat("aaaa年bb月cc日 dd:ee");
		System.out.println("211606388尹海川 "+time.format(new Date()));
	}
	
	//二年级乘除法
	public static void G2( int n ) {
		str1 = new String[n];
		for (int i = 0; i < n; i++) {
			n1 = new Random().nextInt(10) + 1;
			n2 = new Random().nextInt(10) + 1;
			x = (int)(Math.random()*2);
			if (   n1!=0 && n2!=0 && x == 0) {
				System.out.println("(" + (i+1) + ")" +" " + n1 + "*" + n2 + " " + "=" + " ");
				str1[i] = "(" + (i+1) + ")" +" " + n1 + "*" + n2 + " " + "=" + " " + (n1*n2);
			}
			else {
				if (n1-n2 < 0 ) {
					System.out.println("(" + (i+1) + ")" +" " + n2 + "/" + n1 + " " + "=" + " ");
					str1[i] = "(" + (i+1) + ")" +" " + n2 + "/" + n1 + " " + "=" + " " + (n2/n1) + judgementRemainder(n2,n1);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + n1 + "/" + n2 + " " + "=" + " ");
					str1[i] = "(" + (i+1) + ")" +" " + n1 + "/" + n2 + " " + "=" + " " + (n1/n2) + judgementRemainder(n1,n2);
				}
			}
		}
		System.out.println("-----------标准答案-----------");
		//输出答案
		for(String k:str1) {
			System.out.println(k);
		}
		//输出日期和姓名学号
		SimpleDateFormat sdf = new SimpleDateFormat("aaaa年bb月cc日 dd:ee");
		System.out.println("211606388尹海川" +sdf.format(new Date()));
	}
	
	//选择年级
	public static void choiceGrade( int e , int f ) {
		if ( f == 1 ) {
			G1(e);
		}
		else if ( f == 2) {
			G2(e);
		}
		else {
			System.out.println("啊噢，只有一年级二年级，这是个未知的领域");
		}
	}
	
	public static String judgementRemainder( int n1 , int n2 ) {
		if( (n1%n2) == 0) {
			
			sun = " ";
		}
		else {
			sun = "..." + (n1%n2) + " ";
		}
		return sun;
	}
}