import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

import java.util.Scanner;


public class MathExam6354 {

	private static Scanner in;
	private static int x,y,f,n;
	private static String[] str ;
	private static String rem;

	public static void main(String args[]) throws FileNotFoundException, InterruptedException {
		in = new Scanner(System.in);
		n = in.nextInt();
		g = in.nextInt();
		File file = new File("out6354.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		CG(n, g);
		
	}
	
	//一年级加法出题
	public static void go( int n ) {
		str = new String[n];
		for (int i = 0; i < n ; i++) {
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
			if ( f == 0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " ");
				str[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);
			}
			else {
				if (x-y < 0) {
					System.out.println("(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " " + (y-x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " " + (x-y);
				}
			}
		}
		System.out.println("--------标准答案---------");
		for (int i = 0; i < n; i++) {
			System.out.println(ans [i]);		
		}
	}
	public static void gt( int n ) {
		str = new String[n];
		for (int i = 0; i < n; i++) {
			x = (int)(Math.random()*10);
			y = (int)(Math.random()*10);
			f = (int)(Math.random()*2);
			
			if ( f == 0 && y!=0 && x!=0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " ");
				str[i] = "(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " " + (x*y);
			}
			else {
				if (x-y < 0 ) {
					System.out.println("(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " " + (y/x) +(x%y);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " " + (x/y) +(x%y) ;
				}
			}
		}
		System.out.println("--------标准答案--------");
		for (int i = 0; i < n; i++) {
			System.out.println(ans [i]);		
		}
	}
	public static void CG( int n , int g ) {
		if ( g == 1 ) {
			go(n);
		}
		else if ( g == 2) {
			gt(n);
		}
	}
}