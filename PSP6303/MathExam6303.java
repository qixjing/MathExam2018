
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class MathExam6303 {	
	private static int len;// 保存用户输入的题目数量
	@SuppressWarnings("unused ")
	private static int grade = 1;//默认是1年级
    private static final String[] sign = {"+", "-", "*", "/"};
    static StringBuffer questions = new StringBuffer(); // 用途：题目与答案的拼接
    static StringBuffer answers = new StringBuffer(); 
     // 四则运算符号表示
	private static void generateExam6303(int grade) {
        int result = 0;
        int remainder = 0;    	
		for (int i = 1; i <= len; i++) {
			// 获取两个随机数，参与计算的两个数字;
			int left = (int) (Math.random() * 100);
			int right = (int) (Math.random() * 10);
			int subScript = (1 == grade) ? 
					((int) (Math.random() *2)) : ((int) (Math.random() *4));
			String symbol = sign[subScript];
			switch (symbol) {
			case "+":
				result = left + right;
				break;
			case "-":
				// 确保第一个数比第二个数大，避免相减出现负数，小学一年级加减没有负数
				if (left < right) {
					int temp = left;
					left = right;
					right = temp;
				}
				result = left - right;
				break;
			case "*":
				result = left * right;
				break;
			case "/":
				while (right == 0) {
					right = (int) (Math.random() * 100);
				}
				result = left / right;
				if (left % right == 0) {
					break;
				} else {
					if (left < right) {
						remainder = left;
					} else if (left > right) {
						remainder = left % right;
					}
				}
				break;
			default:
				System.out.println("unsupported sign!");
			}
			// 记录题目与答案
			questions.append("(" + i + ") " + left + " " + symbol + " " + right + "\r\n");
			if (symbol.equals("/")&&(left % right != 0)) {
				if (remainder != 0 || (remainder == 0 && left == 0)) {
					answers.append("(" + i + ") " + left + " " + symbol + " " + right + " " + "= " 
				                      + result + "......"+remainder+ "\r\n");}
			}else {
				answers.append("(" + i + ") " + left + " " + symbol + " " + right + " " + "= " + result + "\r\n");}
		}
		questions.append("=======输出所有答案======" + "\r\n");
	}
    public static void write6303() throws IOException {
    	  File file= new File("out.txt");
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			file.createNewFile();
		}
		// 步骤2：创建指向文件的输出流
		OutputStream out = new FileOutputStream(file);
		// 步骤3：写数据
		byte[] question=questions.toString().getBytes();
		byte[] answer=answers.toString().getBytes();
		out.write(question);
		//out.write(System.lineSeparator().getBytes());
		out.write(answer);
		// 步骤4：关闭
		out.close();
    }
    @SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("请输入2个参数！");
        }else if (args.length > 2) {
            throw new IllegalArgumentException("最多两个参数！");
        }
        String str = args[0].replaceFirst("^0*", "");
        if(str.length()>4) {
        	throw new IllegalArgumentException("输入的第一个参数数值太大！");
        }
        for(int i =str.length();--i>=0;) {
			if (!Character.isDigit(str.charAt(i))) {
				throw new IllegalArgumentException("请输入正整数！");
			}
		}
		if (Integer.parseInt(args[0]) == 0) {
			throw new IllegalArgumentException("请输入参数（1为起始)！");
		}
        if(args.length == 2) {
	        String str2 = args[1].replaceFirst("^0*", "");// 用来去掉前面的0
	        if(str2.charAt(0) != '1' && str2.charAt(0) != '2') {
	        	throw new IllegalArgumentException("第二个参数请输入1或2！");
	        }
        }
        len = Integer.parseInt(args[0]);
        generateExam6303(Integer.parseInt(args[1]));
        write6303();
        System.out.println("题目已经生成，详情请见out.txt");
    }
}
