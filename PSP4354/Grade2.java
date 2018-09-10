package chenbin211614354;

import java.util.ArrayList;
import java.util.Random;

public class Grade2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("乘法");
		w(list);
		System.out.println("除法");
		z(list);

	}

	public static void w(ArrayList<String> list) {
		// 乘法运算方法
		Random r = new Random();
		int i = 0;
		int answer = 0;
		int a = 0;
		int b = 0;
		for (i = 0; i < 10; i++) {
			a = r.nextInt(9 + 1);
			// a为第一个随机数
			b = r.nextInt(9 + 1);
			// b为第二个随机数
			answer = a * b;
			String answer1 = String.valueOf(answer);
			String a1 = String.valueOf(a);
			String b1 = String.valueOf(b);
			list.add("(" + (i + 1) + ")" + a1 + "*" + b1 + "=");
			list.add(answer1);
		}
		for (i = 0; i <= 2 * 10 - 2; i = i + 2) {
			System.out.println(list.get(i));
		}
		System.out.print("\n");
		for (i = 0; i <= 2 * 10 - 2; i = i + 2) {
			System.out.print(list.get(i));
			System.out.println(list.get(i + 1));

		}
	}

	public static void z(ArrayList<String> list) {
		// 除法运算
		Random r = new Random();
		int i = 0;
		int a = 0;
		int b = 0;
		int answer = 0;
		for (i = 0; i < 10; i++) {
			a = r.nextInt(9 + 1);
			// a为第一个随机数
			b = r.nextInt(9 + 1);
			// b为第二个随机数
			answer = a/b;
			String answer1 = String.valueOf(answer);
			String a1 = String.valueOf(a);
			String b1 = String.valueOf(b);
			list.add("(" + i + 1 + ")" + a + "/" + b + "=");
			list.add(answer1);
		}
		for (i = 0; i <= 2 * 10 - 2; i = i + 2) {
			System.out.println(list.get(i));
		}
		System.out.print("\n");
		for (i = 0; i <= 2 * 10 - 2; i = i + 2) {
			System.out.print(list.get(i));
			System.out.println(list.get(i + 1));
		}
	}
}