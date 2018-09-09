import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class MathExam6313 {
	
	//创建两个StringBuffer对象，用来保存输出的题目和标准答案
	private static StringBuffer topic = new StringBuffer();
	private static StringBuffer standAnswer = new StringBuffer();
	
	//保存4个运算符号
	private static String[] Operator = { " + ", " - ", " * ", " / " };

	public static void main(String[] args) {
		// 判断用户输入的参数是否符合要求

		if(judgmentParameter(args)){
			// 保存用户输入的题目数量
			int len = Integer.parseInt(args[0]);
			//保存年级，默认1年级
			int grade = 1;
			if(2 == args.length) {
				 grade = Integer.parseInt(args[1]);
			}
			//生成题目
			generatingTopic(len,grade);
			// 写入文件
			try {
				write313("out.txt");
				System.out.println("小学" + grade + "年级数学题题目已生成，请查看out.txt文件");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * 作用：生成题目
	 * @param len 用户要求生成的题目数量
	 * @param grade 年级
	 */
	private static void generatingTopic(int len,int grade) {
		for (int i = 1; i <= len; i++) {
			// 获取两个随机数，num1,num2表示参与计算的两个数字;
			int num1 = (int) (Math.random() * 101);
			int num2 = (int) (Math.random() * 101);
			
			// symbol代表运算符号;
			int index = (1 == grade) ? ((int) (Math.random() * 10)) % 2 : ((int) (Math.random() * 10)) % 4;
			String symbol = Operator[index];
			
			//确保小学1年级加法不会超过100
			while(1 == grade && 0 == index && num1 + num2 >= 100) {
				num1 = (int) (Math.random() * 101);
				num2 = (int) (Math.random() * 101);
			}
			// 计算结果
			int res = 0;
			int remainder = 0; // 余数
			switch (symbol) {
			case " + ":
				res = num1 + num2;
				break;
			case " - ":
				// 确保第一个数比第二个数大，避免相减出现负数，小学加减无负数
				if (num1 < num2) {
					int temp = num1;
					num1 = num2;
					num2 = temp;
				}
				res = num1 - num2;
				break;
			case " * ":
				res = num1 * num2;
				break;
			case " / ":
				//防止除数为0
				while(0 == num2) {
					num2 = (int) (Math.random() * 101);
				}
				res = num1 / num2;
				remainder = num1 % num2;
				break;
			}
			// 将题目和答案记录
			topic.append("(" + i + ") " + num1 + symbol + num2 + System.lineSeparator());
			if (symbol.equals(" / ")) {
				standAnswer.append("(" + i + ") " + num1 + symbol + num2 + " = " + res
						+ (remainder != 0 ? ("..." + remainder) : "") + System.lineSeparator());
			} else {
				standAnswer.append("(" + i + ") " + num1 + symbol + num2 + " = " + res + System.lineSeparator());
			}
		}
	}

	
	/**
	 * 作用：判断用户输入的参数是否合法
	 * @param args 用户输入的参数
	 * @return     当符合要求时返回 true，否则返回false
	 */
	private static boolean judgmentParameter(String[] args) {
		if (0 == args.length) {
			System.out.println("运行程序时请输入两个数字代表要生成的题数和年级。");
			return false;
		} else if (args.length > 2) {
			System.out.println("最多输入两个个数字参数，第一个代表题目数量，第二个代表年级");
			return false;
		} else {

			//去除第一个参数的前导0
			String str1 = args[0].replaceFirst("^0*", "");
			// 检验第一个参数是否都是数字
			Pattern pattern = Pattern.compile("[0-9]*");
			boolean matches = pattern.matcher(str1).matches();

			if (matches && str1.length() > 4) {
				System.out.println("第一个参数数字过大，请重新运行，输入参数");
				return false;
			} else if (!matches) {
				System.out.println("输入的第一个参数不是正整数，请重新运行，输入一个正整数");
				return false;
			}

			if (2 == args.length) {
				//去除第二个个参数的前导0
				String str2 = args[1].replaceFirst("^0*", "");
				// 检验第一个参数是否都是1或2
				Pattern compile = Pattern.compile("[1-2]?");
				boolean matches2 = compile.matcher(str2).matches();
				
				if (!matches2) {
					System.out.println("输入的第二个参数不是1或2，请重新运行，第二个参数输入1或2");
					return false;
				}
			}
		}
		return true;
	}

	
	/**
	 * 作用：将生成的题目和和答案写入指定文件
	 * @param filename       将要写入的文件名
	 * @throws IOException   当文件名不合法时抛出异常
	 */
	private static void write313(String filename) throws IOException {
		// 步骤1：确定输出的文件（目的地）
		// 如果filename中包含路径，必须确保路径已存在
		File file = new File(filename);
		File parentFile = file.getParentFile();
		if (parentFile != null && !parentFile.exists()) {
			parentFile.mkdirs();
			System.out.println("创建目录：" + parentFile);
		}
		file.createNewFile();
		// 步骤2：创建指向文件的输出流
		OutputStream out = new FileOutputStream(file);
		// 步骤3：写入数据
		out.write(topic.toString().getBytes());
		out.write(System.lineSeparator().getBytes());
		out.write(standAnswer.toString().getBytes());
		// 步骤4：关闭
		out.close();
	}
}