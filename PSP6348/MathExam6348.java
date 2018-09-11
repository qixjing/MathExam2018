import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MathExam6348 {
	/*
	 * 主函数功能： 1.check函数检测输入参数是否有问题 2.init函数初始化获得题目和答案 3.OutPutFile函数将题目输出为out.txt文件
	 */
	public static void main(String[] args) {
		// 创建一个可变字符串用来拼接题目和答案
		StringBuffer stringBuffer = new StringBuffer();
		// 检测输入的参数是否有误
		if (!check(args))
			return;
		// 初始化获取题目和答案
		init(stringBuffer, args);
		outPutFile(stringBuffer);
	}

	/*
	 * 检测输入参数个数错误 检测输入参数只能为数字且最大值只有10000 解决参数为00000000000001之类的问题 解决参数为负数
	 */
	public static boolean check(String[] s) {
		char[] allChar = s[0].toCharArray();
		char[] charArray = s[1].toCharArray();
		int k = 0;
		// 控制输入的参数只能为0、1、2个
		if (s.length == 0 || s.length > 2) {
			System.out.println("输入的参数个数错误！！");
			return false;
		}
		if (s[0].equals("0")) {
			System.out.println("输入题目数量0无意义");
			return false;
		}
		//控制第二个参数只能是1、2
		if (s.length == 2) {
			if (!(s[1].equals("1") || s[0].equals("2"))) {
				System.out.println("第二个参数只能为1、2");
				return false;
			}
		}
		
		// 去掉第一个参数前面所有的数字0
		k=0;
		while (allChar[k++] == '0');
		s[0] = new String(allChar, k - 1, allChar.length - k + 1);
		// 控制算数的题目数量不超过10000道题目
		if (s[0].length() > 4) {
			System.out.println("题目数量过大，请输入10000以内的数");
			return false;
		}
		// 检测第一个参数是个数字
		k = 0;
		while (!Character.isDigit(allChar[k++])) {
			System.out.println("请输入一个正整数！！");
			return false;
		}
		return true;
	}
	/*
	 * init函数产生题目和答案
	 */
	public static void init(StringBuffer strbuf, String[] s) {

		int result = 0; // 表示题目答案
		int remainder = 0; // 表示余数
		String operator = null; // 表示随机出来的运算符
		String[] mark_code = { "+", "-", "*", "/" }; // 小学1年级和2年级所有的运算
		StringBuffer strbuf1 = new StringBuffer(); // 用于答案的拼接
		// for循环拼接题目和答案
		for (int i = 1; i <= Integer.valueOf(s[0]); i++) {
			// 判断年级 判断该年级对应的运算
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
			// 题目序号
			String number = "(" + i + ")" + " ";
			// 生成2个随机数
			int first = (int) (Math.random() * 100);
			int second = (int) (Math.random() * 100);
			// 按照年级需求生成指定的题目
			if (operator.equals("+")) {
				if (s.length == 2 && s[1].equals("2")) {
					// 二年级的加法题目答案不超过100
					while (first + second > 100) {
						first = (int) (Math.random() * 100);
						second = (int) (Math.random() * 100);
					}
				} else {
					while (first + second > 100) {
						// 1年级的加法：
						// 1. 答案不超过100
						// 2. 可以是2位数+个位数
						// 3. 可以是2位数+整的10位数
						if (first % 2 == 0) {
							first = (int) (Math.random() * 100);
							second = (int) (Math.random() * 100);
							if (second > 10)
								second = second / 10;
						} else {
							first = (int) (Math.random() * 100);
							if (first > 10)
								second = second / 10 * 10;
							second = (int) (Math.random() * 100);
						}
					}
				}
				result = first + second;
			} else if (operator.equals("-")) {
				// 控制左边的数必须大于右边的数。
				if (first < second) {
					int t;
					t = first;
					first = second;
					second = t;
				}
				if (!(s.length == 2 && s[1].equals("2"))) {
					// 2年级的减法：
					// 1. 答案不能为负数
					// 2. 可以是2位数-个位数
					// 3. 可以是2位数-整的10位数
					if (second > 10)
						second = second / 10 * 10;
					result = first - second;
				} else {
					result = first - second;
				}
			} else if (operator.equals("*")) {
				// 控制乘法只能是99乘法表上面的
				while (first > 10 || second > 10) {
					first = (int) (Math.random() * 10);
					second = (int) (Math.random() * 10);
				}
				result = first * second;
			} else {
				// 当运算符为除时候 除数不能为0
				while (second == 0) {
					second = (int) (Math.random() * 100);
				}
				// 控制除数只能是小于等于10
				while (second > 10) {
					second /= 10;
				}
				if (first % second == 0) {
					result = first / second;
				} else { // 控制不能整除将答案和余数都显示出来
					if (first > second) {
						result = (int) (first / second);
						remainder = first - (int) (first / second) * second;
					} else {
						result = (int) (first / second);
						remainder = second;
					}
				}
			}
			// 如果为除法要考虑是否有余数拼接在答案后面
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

	public static void outPutFile(StringBuffer strbuf) {

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