import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MathExam6348 {
	public static void main(String[] args) {
		StringBuffer strbuf = new StringBuffer();
		//检测输入的参数是否有误
		boolean check = check(args);
		if (check) {
			// 初始化获取题目和答案
			init(strbuf,args);
			// 将题目和答案的可变字符串转成二级制
			byte[] bytes = new String(strbuf).getBytes();
			// 将二进制传入文件输出流输出成out.txt
			try {
				FileOutputStream fos = new FileOutputStream("out.txt");
				try {
					fos.write(bytes);
				} catch (IOException e) {
					System.out.println("文件写出错误");
				}
			} catch (FileNotFoundException e) {
				System.out.println("文件未找到！！");
			}
			// 输出程序执行的结果
			System.out.println("题目已经生成，详情请见out.txt");
		}
	}
	/*
	 * 检测输入参数个数错误
	 * 检测输入参数只能为数字且最大值只有10000
	 * 解决参数为00000000000001的问题
	 * 解决参数为负数
	 * */
	public static boolean check(String[] s) {
		char[] ca = s[0].toCharArray();
		int k = 0;
		if (s.length == 0 || s.length > 2) {
			System.out.println("输入的参数个数错误！！");
			return false;
		}
		
		while (ca[k++] == '0');
		s[0] = new String(ca, k - 1, ca.length - k + 1);
		
		if (s[0].length() > 4) {
			System.out.println("数字过大");
			return false;
		}
		k = 0;
		while (!Character.isDigit(ca[k++])) {
			System.out.println("请输入一个正整数！！");
			return false;
		}
		return true;
	}
	/*
	 * 产生题目和答案
	 * */
	public static void init(StringBuffer strbuf, String[] s) {
		
			int result = 0; // 题目答案
			int remainder = 0; // 余数
			String operator = null; // 随机出来的运算符
			String[] mark_code = { "+", "-", "*", "/" }; // 小学1年级和2年级有的运算
			StringBuffer strbuf1 = new StringBuffer(); // 用于答案的拼接
			//
			for (int i = 1; i <= Integer.valueOf(s[0]); i++) {
				if (s.length == 1) {
					operator = mark_code[(int) (Math.random() * 2)];
				} else {
					if (Integer.valueOf(s[1]) == 1) {
						operator = mark_code[(int) (Math.random() * 2)];
					} else if (Integer.valueOf(s[1]) == 2) {
						operator = mark_code[(int) (Math.random() * 4)];
					} else {
						System.out.println("输入年级有误！！");
						System.exit(0);
					}
				}
				String number = "(" + i + ")" + " ";
				// 生成2个随机数
				int first = (int) (Math.random() * 100);
				int second = (int) (Math.random() * 100);
				// 判断随机运算符是要进行什么运算
				if (operator.equals("+")) {
					result = first + second;
				} else if (operator.equals("-")) {
					// 控制左边的数必须大于右边的数。
					if (first < second) {
						int t;
						t = first;
						first = second;
						second = t;
					}
					
					result = first - second;
				} else if (operator.equals("*")) {
					result = first * second;
				} else {
					// 当运算符为除时候 除数不能为0
					while (second == 0) {
						second = (int) (Math.random() * 100);
					}
					if (first % second == 0) {
						result = first / second;
					} else {
						if (first > second) {
							result = (int) (first / second);
							remainder = first - (int) (first / second) * second;
						} else {
							result = (int) (first / second);
							remainder = second;
						}
					}
				}
				// 如果为除法要考虑是否有余数输出
				if (operator.equals("/")) {
					strbuf1.append(number + first + " " + operator + " " + second + " " + "=" + " " + result + "..."
							+ remainder + "\r\n");
				} else {
					strbuf1.append(number + first + " " + operator + " " + second + " " + "=" + " " + result + "\r\n");
				}
				strbuf.append(number + first + " " + operator + " " + second + "\r\n");
			}
			// 将题目和答案拼接在strbuf可变字符串当中
			strbuf = strbuf.append("\r\n" + strbuf1);
		
	}

}