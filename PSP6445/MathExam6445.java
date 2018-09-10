import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class MathExam6445{

	static int n, grade;

	public static void main(String[] args) {
		if (check(args[0], args[1])) {
			create();
			try {
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("out.txt")), true));
			} catch (FileNotFoundException e) {
				System.out.println("输出重定向失败失败！");
				e.printStackTrace();
			}
			work();
		}
	}

	public static boolean check(String strN, String strGrade) {
		if (!strN.matches("\\d*")) {
			if (strN.matches("-\\d*")) {
				System.out.println("输入一个正确的数字哦，不能为负");
				return false;
			} else {
				System.out.println("输入的题数必须是数字!");
				return false;
			}
		} else {
			n = Integer.parseInt(strN);
			if (n > 100) {
				System.out.println("输入的题数过大，体谅下小学生哦");
				return false;
			}
		}

		if (!strGrade.matches("[1-2]")) {
			System.out.println("年级只能是 1 或者 2 哦");
			return false;
		} else {
			grade = Integer.parseInt(strGrade);
		}
		return true;
	}

	public static void work() {
		int num1, num2, op;
		String str = "", result = "";
		Random rand = new Random();
		for (int i = 1; i <= n; i++) {
			num1 = rand.nextInt(101);
			num2 = rand.nextInt(101);
			if (grade == 1)
				op = rand.nextInt(2);
			else
				op = rand.nextInt(4);
			if (op == 0) {
				if ((num1 + num2) > 100) {
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " + " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " + " + num2 + " = " + (num1 + num2) + "\r\n";
			} else if (op == 1) {
				if ((num1 - num2) < 0) {
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " - " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " - " + num2 + " = " + (num1 - num2) + "\r\n";
			} else if (op == 2) {
				if ((num1 * num2) > 100) {
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " * " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " * " + num2 + " = " + (num1 * num2) + "\r\n";
			} else {
				if (num2 == 0) {
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " / " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " / " + num2 + 
						" = " + (num1 / num2) + "..." + (num1 % num2) + "\r\n";
			}
		}
		System.out.println(str);
		System.out.print(result);
	}

	public static void create() {
		File file = new File("out.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("文件创建失败！");
				e.printStackTrace();
			}
		}
	}
}
