import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MathExam7246 {
	
	final static int GRADE1MAX = 20;
	final static int GRADE2MAX = 100;
	static int number1, number2, number3;// 两个运算数以及运算结果
	static int fuhao;// 0,1,2,3分别对应加、减、乘、除
	static int num;
	static String[] strArrayQ;// 存放待写入txt文件的题目
	static String[] strArrayA;// 存放待写入txt文件的答案
	final static String FILENAME = "out.txt";
	
	public static void main(String args[]) throws IOException {
		if (args.length == 1 || args.length ==2) {
			// 处理参数输入问题
			try {
				num = Integer.parseInt(args[0]);
				if (num < 0) {
					System.out.println("题目数量为负！请重新运行！");
				}else if (num == 0) {
					System.out.println("请输入合适的题目数量！");
				}
			} catch(NumberFormatException e) {
				System.out.println("题目数量选项非整数！请重新运行！");
			}
		}else {
			System.out.println("参数个数有误！请重新运行！");
			System.exit(0);
		}
		strArrayQ = new String[num];
		strArrayA = new String[num];
		grade1();
		createTxt();
		writeToTxt();
	}
	
	private static void grade1() {
		// 一年级
		int result = 0;
		for(int i = 1; i <= num; i++) {
			number1 = (int)(Math.random()*(GRADE1MAX+1));
			fuhao = (int)(Math.random()*2);// 符号仅为加、减
			if(fuhao == 0) {
				number2 = (int)(Math.random()*(GRADE1MAX+1));
				result = number1 + number2;
				// 记录题目和答案
				strArrayQ[i-1] = "(" + i + ") " + number1 + " + " + number2 + " =";
				strArrayA[i-1] = "(" + i + ") " + number1 + " + " + number2 + " = " + result;
			}else if(fuhao ==1) {
				do {
					number2 = (int)(Math.random()*(GRADE1MAX+1));
				}while(number2 > number1);
				result = number1 - number2;
				// 记录题目和答案
				strArrayQ[i-1] = "(" + i + ") " + number1 + " - " + number2 + " =";
				strArrayA[i-1] = "(" + i + ") " + number1 + " - " + number2 + " = " + result;
			}
		}
	}
	
	private static void createTxt() throws IOException {
		// 创建文件在默认位置
		File file = new File(FILENAME);
		file.createNewFile();
	}
	
	private static void writeToTxt() {
		// 向txt文件中写入内容
		File file = new File(FILENAME);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			// 具体写入内容
			for (int i = 0; i < num; i++) {
				fw.write(strArrayQ[i]);
				fw.write("\r\n");
			}
			fw.write("--------------标准答案--------------");
			fw.write("\r\n");
			for (int i = 0; i < num; i++) {
				fw.write(strArrayA[i]);
				fw.write("\r\n");
			}
			fw.write("     " + txtFoot());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static String txtFoot() {
		// 脚部信息生成
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		String timeStr = df.format(new Date());
		return "211617246 张竣淇 " + timeStr;
	}
}
