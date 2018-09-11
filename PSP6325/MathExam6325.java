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
		System.out.println("请输入需要生成的题目数量(范围：1-100)以及几年级的题目(1或2年级)：");
		int n;
		int grade;
		int flag = 0;// 输入最后是否以空格结尾
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String regex = "(([1-9]|[1-9][0-9]|100)( ?)(1?|2{1}))";// 符合输入格式的正则表达式
		if (input.matches(regex)) {
			for (int i = 0; i < input.length(); i++) { // 只输入了题目数量
				if ((input.substring(i, i + 1)).equals(" ")) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) { // 不是以空格结尾
				n = Integer.valueOf(input);
				grade = 1; // 默認一年級
				getFirstGradeMath(n, grade);
				return;
			}
			if (input.endsWith(" ")) { // 只输入题目数 + 一个空格
				n = Integer.valueOf(input.substring(0, input.length() - 1));
				grade = 1;
				getFirstGradeMath(n, grade);
				return;
			} else { // 输入格式正确 题目数 + 空格 + 几年级
				String[] spiltArray = null;
				spiltArray = input.split(" ");// 用空格分割字符串 分割成兩個數組
				n = Integer.valueOf(spiltArray[0]);
				grade = Integer.valueOf(spiltArray[1]);
				if (grade == 1) {
					getFirstGradeMath(n, grade);
				} else {
					getSecondGradeMath(n, grade);
				}
				return;
			}
		} else {
			System.out.println(
					"抱歉 輸入格式有誤" + "正確輸入格式:\n生成的题目数(範圍：1-100)" + " " + "生成几年级(1或2年级)" + "\n注意:若未指定年级，则默认生成一年级数学题");
		}
	}

	private static void getSecondGradeMath(int n, int grade) {
		// TODO 自动生成的方法存根
		String[] Calculate = new String[n + 1];// 定义两个数组分别用來存放算式和计算结果
		String[] Result = new String[n + 1];
		Calculate[0] = "";
		Result[0] = null;
		for (int i = 1; i <= n; i++) {
			int numberOne;
			int numberTwo;
			int number;
			String randomSign = null;
			Random randomNumber = new Random();
			numberOne = randomNumber.nextInt(9) + 1;/* 取两个在1-9之间的随机整数作为算式的因子 */
			numberTwo = randomNumber.nextInt(9) + 1;
			number = randomNumber.nextInt(9);/* 第三個隨機數決定符號 大於4為‘*’ 反之為‘/’ */
			if (number > 4) {
				randomSign = "×";
			} else {
				randomSign = "÷";
			}
			Calculate[i] = "(" + i + ")" + " " + numberOne + ' ' + randomSign + ' ' + numberTwo + " = ";
			// 定义商和余数
			String quotient = null;
			String remainder = null;
			// 判断算式是乘法运算还是除法运算
			if (randomSign.equals("÷")) {// 当算式为除法时，重新生成两个因数，使得两个因数小于81
				numberOne = randomNumber.nextInt(80) + 1;
				numberTwo = randomNumber.nextInt(80) + 1;
				// 判断被除数是否大于除数
				if (numberOne > numberTwo) {// 判断是否能够整除
					if ((numberOne % numberTwo) == 0) {
						quotient = numberOne / numberTwo + "";
						Result[i] = quotient;
					} else {
						quotient = numberOne / numberTwo + "";
						remainder = numberOne % numberTwo + "";
						Result[i] = quotient + "..." + remainder;
					}
					// 修改因数后要相应的修改算式
					Calculate[i] = "(" + i + ")" + " " + numberOne + ' ' + randomSign + ' ' + numberTwo + " = ";
				} else {
					// 当被除数小于除数时将被除数和除数互换
					if ((numberTwo % numberOne) == 0) {
						quotient = numberTwo / numberOne + "";
						Result[i] = quotient;
					} else {
						quotient = numberTwo / numberOne + "";
						remainder = numberTwo % numberOne + "";
						Result[i] = quotient + "..." + remainder;
					}
					Calculate[i] = "(" + i + ")" + " " + numberTwo + randomSign + numberOne + " = ";
				}
			} else {
				Result[i] = numberOne * numberTwo + "";
			}
		}
		outputAnswer(Calculate, Result);
		getAnswer();
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