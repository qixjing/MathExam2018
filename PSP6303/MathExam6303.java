import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MathExam6303 {	
	private static int len;// 用户输入的题目数量
    private static final String[] sign = {"+", "-"};
    static StringBuffer questions = new StringBuffer(); // 用途：题目与答案的拼接
    static StringBuffer answers = new StringBuffer(); 
     // 四则运算符号表示
	private static void generateExam6303() {
        int result = 0;   	
		for (int i = 1; i <= len; i++) {
			// 获取两个随机数，参与计算的两个数字;
			int left = (int) (Math.random() * 100);
			int right = (int) (Math.random() * 100);
			int subScript = (int) (Math.random() *2);
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
			default:
				System.out.println("unsupported sign.");
			}
			// 记录题目与答案
			questions.append("("+i+") "+ left + " " + symbol + " " + right + "\r\n");
			
			answers.append("("+i+") "+left+" "+symbol+" "+right+" "+"= "+result+ "\r\n");
		}
		questions.append("=======输出所有答案======"+"\r\n");
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
        if (args.length < 1) {
            throw new IllegalArgumentException("请输入1个参数(1为起始)！");
        }
      
        if (args.length > 1) {
            throw new IllegalArgumentException("至多输入1个参数！");
        }
        String str = args[0].replaceFirst("^0*", "");// 去掉前面的0
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
		len = Integer.parseInt(args[0]);
        generateExam6303();
        write6303();
        System.out.println("一年级计算题题目已经生成，详情请见out.txt");
    }
}

