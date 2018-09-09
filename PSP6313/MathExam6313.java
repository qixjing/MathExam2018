import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class MathExam6313 {
	
	//创建两个StringBuffer对象，用来保存输出的题目和标准答案
	private static StringBuffer topic = new StringBuffer();
	private static StringBuffer standAnswer = new StringBuffer();

	public static void main(String[] args) {

		//判断用户输入的参数是否符合输入要求
		if(judgmentParameter(args)) {
			 int len = Integer.parseInt(args[0]);
			//生成题目
			generatingTopic(len);
			//写入文件
			try {
				write("out.txt");
				System.out.println("小学一年级数学题题目已生成，请查看out.txt文件");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * 
	 * @param args 用户输入的参数
	 * @return     当符合要求时返回 true，否则返回false
	 */
	private static boolean judgmentParameter(String[] args) {
		if(0 == args.length) {
			System.out.println("运行程序时请输入一个数字代表要生成的题数。");
			return false;
		}else if(args.length > 1){
			System.out.println("只需要输入一个数字参数");
			return false;
		}else {
			//去除字符串的前导0
			String str = args[0].replaceFirst("^0*", "");
			//检验是否全为数字
			Pattern pattern = Pattern.compile("[0-9]*");
		    boolean matches = pattern.matcher(str).matches(); 
		    if(matches && str.length() > 4) {
				System.out.println("参数数字过大，请重新运行，输入参数");
				return false;
		    }else if(matches) {
		    	return true;
		    }else {
				System.out.println("输入的参数不是正整数，请重新运行，输入一个正整数");
				return false;
		    }
		}
	}
	
	
	/**
	 * 作用：生成题目
	 * @param len 用户要求生成的题目数量
	 */
	private static void generatingTopic(int len) {
		for(int i = 1; i <= len; i++) {
			//获取两个随机数，num1,num2表示参与计算的两个数字; 
			int num1 = (int) (Math.random()*101);
			int num2 = (int) (Math.random()*101);
			//确保第一个数比第二个数大，避免相减出现负数，小学一年级加减无负数
			if(num1 < num2) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			//symbol代表运算符号，当随机数为0得到  " + ",随机数为1得到" - ";
			String symbol = (0 == ((int) (Math.random()*10))%2)? " + " : " - ";
			//计算结果
			int res = (symbol.equals(" + ")) ? num1 + num2 :num1 - num2;
			//将题目和答案记录
			topic.append("(" + i + ") " + num1 + symbol + num2 + System.lineSeparator());
			standAnswer.append("(" + i + ") " + num1 + symbol + num2 + " = " + res + System.lineSeparator());
		}
	}
	
	
	/**
	 * 作用：将生成的题目和和答案写入指定文件
	 * @param filename     将要写入的文件名
	 * @throws IOException 当文件名不合法时抛出异常
	 */
	private static void write(String filename) throws IOException {
	    // 步骤1：确定输出的文件（目的地）
		// 如果filename中包含路径，必须确保路径已存在
		  File file = new File(filename);
		  File parentFile = file.getParentFile();
		  if(parentFile!=null&&!parentFile.exists()) {
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
