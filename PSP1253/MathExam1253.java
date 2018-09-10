
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class MathExam1253 { 
	public static void main(String[] args) {
		int grade = 1;
		if(args.length==2){
			if (args[1].equals("1") || args[1].equals("2")) {
				grade = Integer.valueOf(args[1]);
			} else {
				System.out.println("输入有误，程序结束");
				System.exit(0);
			}
		}
		if(args.length!=1 && args.length!=2 ){
			System.out.println("输入有误，程序结束");
			System.exit(0);
		}
			
		// TODO Auto-generated method stub
		boolean r = args[0].matches("[0-9]+");
		String h = args[0].substring(0, 1);
		int n = 0;
		if (r == true && args[0].length() < 5 && h != "0") {
			n = Integer.valueOf(args[0]);
		} else {
			System.out.println("输入有误，程序结束");
			System.exit(0);
		}
		
		Random rand = new Random();
		if (grade==1) {
			int d = 0;
			String x = "";
			String y = "";
			for (int i = 1; i <= n; i++) {
				int c = (rand.nextInt(2));// 0表示加法，1表示减法
				if (c == 0) {
					int a = (rand.nextInt(100));// 随机生成两个0-99的相加减的数,且之和不大于100
					int b = (rand.nextInt(100 - a));
					d = a + b;
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "+" + " " + b + " " + "=";// 将题目存入x
					y = y + "(" + i + ")" + " " + a + " " + "+" + " " + b + " " + "=" + " " + d;// 将题目及答案存入y

				} else {

					int a = (rand.nextInt(100));// 随机生成两个0-99的相加减的数,且b不大于a
					int b = (rand.nextInt(10));
					d = a - b;
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "-" + " " + b + " " + "=";// 将题目存入x
					y = y + "(" + i + ")" + " " + a + " " + "-" + " " + b + " " + "=" + " " + d;// 将题目及答案存入y

				}
			}
			String z = x;
			String k = y;
			try {
				File f = new File("out.txt");
				PrintStream f1 = new PrintStream(new FileOutputStream(f));
				System.setOut(f1);
				System.out.println(z);
				System.out.println(k);
			} catch (Exception e) {
			}
		} else {
			int d = 0;
			int d1 = 0;
			String x = "";
			String y = "";
			for (int i = 1; i <= n; i++) {
				int c = (rand.nextInt(2));// 0表示乘法法，1表示除法
				if (c == 0) {
					int a = (rand.nextInt(9)+1);// 随机生成两个1-9的相乘除的数
					int b = (rand.nextInt(9)+1);
					d = a * b;
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "*" + " " + b + " " + "=";// 将题目存入x
					y = y + "(" + i + ")" + " " + a + " " + "*" + " " + b + " " + "=" + " " + d;// 将题目及答案存入y
				} else {
					int a = (rand.nextInt(100));// 随机生成两个1-9的相乘除的数,且b不大于a,b不为0
					int b = (rand.nextInt(9)+1);
					d = a / b;
					d1 = a % b;
					if(a%b!=0) {
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "/" + " " + b + " " + "=";// 将题目存入x
					y = y + "(" + i + ")" + " " + a + " " + "/" + " " + b + " " + "=" + " " + d+"..."+d1;// 将题目及答案存入y

				}else {
					if (i != 1) {
						x = x + "\n";
						y = y + "\n";
					}
					x = x + "(" + i + ")" + " " + a + " " + "/" + " " + b + " " + "=";// 将题目存入x
					y = y + "(" + i + ")" + " " + a + " " + "/" + " " + b + " " + "=" + " " + d;// 将题目及答案存入y
				}
				}
			}
			String z = x;
			String k = y;
			try {
				File f = new File("out.txt");
				PrintStream f1 = new PrintStream(new FileOutputStream(f));
				System.setOut(f1);
				System.out.println(z);
				System.out.println(k);
			} catch (Exception e) {
			}
		}

	}
}
