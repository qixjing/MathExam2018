package xys;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class MathExam6368 {
	public static void main(String[] args) throws IOException {
		int[k] = new int[args.length];
		z[0] = Integer.parseInt(args[0]);
		z[1] = Integer.parseInt(args[1]);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要生成的题目数量:");
		n = z[0];
//		int n = sc.nextInt();
		for(;n<=0;){
			System.out.println("请重新输入:");	
			int n1 = sc.nextInt();
			n=n1;
		}
		System.out.println("--------------------------");
		int i;
		int x[] = new int[n+1];
		int y[] = new int[n+1];
		int z[] = new int[n+1];
		int z1[] = new int[n+1];
		System.out.println("请输入1或2来选择年龄");
		System.out.println("1:小学一年级。");
		System.out.println("2:小学二年级。");
		d = z[1];
//		int d = sc.nextInt();
		for(;d <= 0 || d >= 3;){
			System.out.println("请重新输入:");
			int d1 = sc.nextInt();
			d=d1;
		}
		int e = 0;
		char[] c = new char[n+1];
		System.out.println("-----------题目-----------");
		for(i = 1;i <= n;i++){
			z[i] = 0;
			e = (int) (0 + Math.random() * (2));
			if(d == 1){
				int a = (int) (0 + Math.random() * (11));
				int b = (int) (0 + Math.random() * (11));
				x[i] = a;
				y[i] = b;
				if(e == 0){
					c[i] = '+';
					z[i] = x[i] + y[i];
				}
				else{
					c[i] = '-';
					z[i] = x[i] - y[i];
				}
			}
			else if(d == 2){
				if(e == 0){
					int a = (int) (0 + Math.random() * (10));
					int b = (int) (0 + Math.random() * (10));
					x[i] = a;
					y[i] = b;
					c[i] = '*';
					z[i] = x[i] * y[i];
				}
				else{
					int a = (int) (0 + Math.random() * (10));
					int b = (int) (1 + Math.random() * (10));
					x[i] = a;
					y[i] = b;
					c[i] = '/';
					z[i] = x[i] / y[i];
					z1[i] = x[i] % y[i];
				}
			}
			System.out.println("(" + i + ") " + x[i] + c[i] + y[i] + "=");
			String word = "(" + i + ") " + x[i] + c[i] + y[i] + "=";
			String path = "D:\\java\\out.txt";
	        BufferedWriter out = new BufferedWriter(
	                new OutputStreamWriter(new FileOutputStream(path,true)));
	        out.write(word+"\r\n");
	        out.close();
		}
		System.out.println("-----------答案-----------");
		for(i = 1;i <= n;i++){
			if(z1[i] == 0){
				System.out.println("(" + i + ") " + x[i] + c[i] + y[i] + "=" + z[i]);
				String word = "(" + i + ") " + x[i] + c[i] + y[i] + "=" + z[i];
				String path = "D:\\java\\out.txt";
				BufferedWriter out = new BufferedWriter(
		               new OutputStreamWriter(new FileOutputStream(path,true)));
				out.write(word+"\r\n");
				out.close();
			}
			else{
				System.out.println("(" + i + ") " + x[i] + c[i] + y[i] + "=" + z[i] + "…" + z1[i]);
				String word = "(" + i + ") " + x[i] + c[i] + y[i] + "=" + z[i] + "…" + z1[i];
				String path = "D:\\java\\out.txt";
				BufferedWriter out = new BufferedWriter(
		               new OutputStreamWriter(new FileOutputStream(path,true)));
				out.write(word+"\r\n");
				out.close();
			}
				
		}

	}

}
