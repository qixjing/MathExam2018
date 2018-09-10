package chenbin211614354;

import java.util.ArrayList;
import java.util.Random;

public class Grade1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("减法");
		x(list);
		System.out.println("加法");
		y(list);
	}

	public static void x(ArrayList<String> list) {
		// 減法运算方法
		Random r = new Random();
		int i = 0;
		int answer = 0;
		int a = 0;
		int b = 0;
		for (i = 0; i < 10; i++) {
			do {
				a = r.nextInt(100);
				// a为第一个随机数
				b = r.nextInt(100);
				// b为第二个随机数
				answer = a - b;
			} while (answer < 0);
			String answer1 = String.valueOf(answer);
			String a1 = String.valueOf(a);
			String b1 = String.valueOf(b);
			list.add("(" + (i + 1) + ") " + a1 + " - " + b1 + " = ");
			list.add(answer1);
		}
		for (i = 0; i <= 2 * 10 - 2; i = i + 2) {
			System.out.println(list.get(i));
		}
		System.out.print("\n");
		for (i = 0; i <= 2*10 - 2; i = i + 2) {
			System.out.print(list.get(i));
			System.out.println(list.get(i + 1));
		}
	}

	public static void y(ArrayList<String> list) {
		// 加法运算
		Random r = new Random();
		int i = 0;
		int answer = 0;
		int a = 0;
		int b = 0;
		for (i = 0; i < 10; i++) {
			do {
				a = r.nextInt(100);
				// a为第一个随机数
				b = r.nextInt(100);
				// b为第二个随机数
				answer = a + b;
			} while (answer >= 100);
			String answer1 = String.valueOf(answer);
			String a1 = String.valueOf(a);
			String b1 = String.valueOf(b);
			list.add("(" + (i + 1) + ") " + a1 + " - " + b1 + " = ");
			list.add(answer1);
		}
		for(i=0;i<2*10-2;i=i+2) {
			System.out.println(list.get(i));
		}
		System.out.print("\n");
		for (i = 0; i <= 2 * 10 - 2; i = i + 2) {
			System.out.print(list.get(i));
			System.out.println(list.get(i + 1));
		}
	}
}
		
		
		
			
	

