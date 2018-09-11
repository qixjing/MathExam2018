import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class MathExam6445 {

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
	/**
	 * 检查输入的参数是否合法
	 * @param strN：题数
	 * @param strGrade：年级
	 * @return	合法返回true，否则返回false
	 */
	public static boolean check(String strN, String strGrade) {
		// 若题数不为数字
		if (!strN.matches("\\d*")) {
			// 若题数为负号+数字（即为负数）
			if (strN.matches("-\\d*")) {
				System.out.println("输入一个正确的数字哦，不能为负");
				return false;
			} else {
				// 题数为数字外的字符
				System.out.println("输入的题数必须是数字!");
				return false;
			}
		} else {
			// 字符串类型的题数转成整型
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
	/**
	 * 出题和给出答案至文件
	 */
	public static void work() {
		int num1, num2, op;
		String str = "", result = "";
		Random rand = new Random();
		for (int i = 1; i <= n; i++) {
			// 随机生成0~100的数
			num1 = rand.nextInt(101);
			num2 = rand.nextInt(101);
			if (grade == 1) {
				// 一年级只有加减
				op = rand.nextInt(2);
			} else
				// 二年级涉及乘除
				op = rand.nextInt(4);
			// op = 0加法，1减法，2乘法。3除法
			if (op == 0) {
				// 若两数之和超过100，不合理跳过
				if ((num1 + num2) > 100) {
					// 跳过但是不能减少题数，循环变量需要减一
					i--;
					continue;
				}
				// 字符串更新，需注意windows系统下，换行符为“\r\n”
				str += "(" + i + ") " + num1 + " + " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " + " + num2 + " = " + (num1 + num2) + "\r\n";
			} else if (op == 1) {
				// 两数之差出现负数，不合理跳过
				if ((num1 - num2) < 0) {
					// 同理，循环变量需要减一
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " - " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " - " + num2 + " = " + (num1 - num2) + "\r\n";
			} else if (op == 2) {
				// 乘除数值为0~10
				num1 = rand.nextInt(11);
				num2 = rand.nextInt(11);
				// 同理，两数之积超过100，不合理跳过
				if ((num1 * num2) > 100) {
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " * " + num2 + "\r\n";
				result += "(" + i + ") " + num1 + " * " + num2 + " = " + (num1 * num2) + "\r\n";
			} else {
				num1 = rand.nextInt(11);
				num2 = rand.nextInt(11);
				// 同理，除数不能为0，不合理跳过
				if (num2 == 0) {
					i--;
					continue;
				}
				str += "(" + i + ") " + num1 + " / " + num2 + "\r\n";
				if (num1 % num2 != 0) {
					result += "(" + i + ") " + num1 + " / " + num2 + " = " + (num1 / num2) + "..." + (num1 % num2)
							+ "\r\n";
				} else {
					result += "(" + i + ") " + num1 + " / " + num2 + " = " + (num1 / num2) + "\r\n";
				}
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
