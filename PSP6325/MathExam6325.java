import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MathExam6325 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n;
		int grade = 1;
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		n = Integer.valueOf(input);
		if (n >= 1 && n <= 100) {
			getFirstGradeMath(n, grade);
		} else
			System.out.println("警告！ 输入格式有误！");
	}

	private static void getFirstGradeMath(int n, int grade) {
		// TODO 自动生成的方法存根
		String[] Calculate = new String[n + 1];
		String[] Result = new String[n + 1];// 两个数组 一个存放算式 一个存放结果
		Calculate[0] = "";
		Result[0] = null;
		for (int i = 1; i <= n; i++) {
			int numberOne;
			int numberTwo;
			int number;
			String randomSign = null;
			Random randomNumber = new Random();
			numberOne = randomNumber.nextInt(51);
			numberTwo = randomNumber.nextInt(51);// 设置两个数大小均不超过50
			number = randomNumber.nextInt(101);// 设置第三个随机数
			if (number > 50) { // 随机数大于50为‘+’ 使得随机出来的‘+’‘-’概率均为50%
				randomSign = "+";
			} else {
				randomSign = "-";
			}
			Calculate[i] = "(" + i + ")" + " " + numberOne + " " + randomSign + " " + numberTwo + " = ";
			if (randomSign.equals("-")) {
				if ((numberOne - numberTwo) >= 0) {
					Result[i] = numberOne - numberTwo + "";
				} else {
					Calculate[i] = "(" + i + ")" + " " + numberTwo + " " + randomSign + " " + numberOne + " = ";
					Result[i] = numberTwo - numberOne + "";
				}
			} else {
				Result[i] = numberOne + numberTwo + "";
			}
		}
		outputAnswer(Calculate, Result);
		getAnswer();
	}

	private static void getAnswer() {
		// TODO 自动生成的方法存根
		File file = new File("out.txt");
		BufferedReader pr = null;
		String str = "";
		try {
			pr = new BufferedReader(new FileReader(file));
			try {
				while ((str = pr.readLine()) != null) {
					System.out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void outputAnswer(String[] Calculate, String[] Result) {
		// TODO 自动生成的方法存根
		File file = new File("out.txt");
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				file.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		BufferedWriter save = null;
		String str = "";
		try {
			save = new BufferedWriter(new FileWriter(file));
			for (int i = 1; i < Calculate.length; i++) {// 输出运算式子
				str = Calculate[i];
				save.write(str);
				save.newLine();
				save.flush();
			}
			save.newLine();
			save.flush();
			for (int i = 1; i < Calculate.length; i++) { // 输出含标准答案的式子
				str = Calculate[i] + Result[i];
				save.write(str);
				save.newLine();
				save.flush();
			}
			save.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}