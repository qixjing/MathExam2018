package chenbin211614354;

import java.util.ArrayList;
import java.util.Random;

public class Grade2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Random random = new Random();
		int i = 0;
		int j=0;
		boolean g = false;
		for (i = 0; i < 10; i++) {
			g = random.nextBoolean();
			if (g == false) {
				w(list,j);               // 调用乘法运算方法
				j++;
			} else if (g == true) {
				z(list,j);               // 调用除法运算方法
				j++;
			}

		}
		p(list);
	}

	public static void w(ArrayList<String> list,int j) {
		// 乘法运算方法
		Random r = new Random();
		int i = 0;
		int answer = 0;
		int a = 0;
		int b = 0;
		a = r.nextInt(9 + 1);
		// a为第一个随机数
		b = r.nextInt(9 + 1);
		// b为第二个随机数
		answer = a * b;
		String answer1 = String.valueOf(answer);
		String a1 = String.valueOf(a);
		String b1 = String.valueOf(b);
		list.add("(" + (j + 1) + ")" + a1 + "*" + b1 + "=");
		list.add(answer1);
	}

	public static void z(ArrayList<String> list,int j) {
		// 除法运算方法
		Random r = new Random();
		int i = 0;
		int a = 0;
		int b = 0;
		int answer = 0;
		a = r.nextInt(9) + 1;
		// a为第一个随机数
		b = r.nextInt(9) + 1;
		// b为第二个随机数
		answer = a / b;
		String answer1 = String.valueOf(answer);
		String a1 = String.valueOf(a);
		String b1 = String.valueOf(b);
		list.add("(" +( j + 1) + ")" + a1 + "/" + b1 + "=");
		list.add(answer1);
	}

	public static void p(ArrayList<String> list) {
		// 新建一个方法用来专门输出
		int i = 0;
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
	
	
	
	
	
	