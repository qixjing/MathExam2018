
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class MathExam6303 {	
	private static int len;// �����û��������Ŀ����
	@SuppressWarnings("unused ")
	private static int grade = 1;//Ĭ����1�꼶
    private static final String[] sign = {"+", "-", "*", "/"};
    static StringBuffer questions = new StringBuffer(); // ��;����Ŀ��𰸵�ƴ��
    static StringBuffer answers = new StringBuffer(); 
     // ����������ű�ʾ
	private static void generateExam6303(int grade) {
        int result = 0;
        int remainder = 0;    	
		for (int i = 1; i <= len; i++) {
			// ��ȡ���������������������������;
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
				// ȷ����һ�����ȵڶ������󣬱���������ָ�����Сѧһ�꼶�Ӽ�û�и���
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
			// ��¼��Ŀ���
			questions.append("(" + i + ") " + left + " " + symbol + " " + right + "\r\n");
			if (symbol.equals("/")&&(left % right != 0)) {
				if (remainder != 0 || (remainder == 0 && left == 0)) {
					answers.append("(" + i + ") " + left + " " + symbol + " " + right + " " + "= " 
				                      + result + "......"+remainder+ "\r\n");}
			}else {
				answers.append("(" + i + ") " + left + " " + symbol + " " + right + " " + "= " + result + "\r\n");}
		}
		questions.append("=======������д�======" + "\r\n");
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
		// ����2������ָ���ļ��������
		OutputStream out = new FileOutputStream(file);
		// ����3��д����
		byte[] question=questions.toString().getBytes();
		byte[] answer=answers.toString().getBytes();
		out.write(question);
		//out.write(System.lineSeparator().getBytes());
		out.write(answer);
		// ����4���ر�
		out.close();
    }
    @SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("������2��������");
        }else if (args.length > 2) {
            throw new IllegalArgumentException("�������������");
        }
        String str = args[0].replaceFirst("^0*", "");
        if(str.length()>4) {
        	throw new IllegalArgumentException("����ĵ�һ��������ֵ̫��");
        }
        for(int i =str.length();--i>=0;) {
			if (!Character.isDigit(str.charAt(i))) {
				throw new IllegalArgumentException("��������������");
			}
		}
		if (Integer.parseInt(args[0]) == 0) {
			throw new IllegalArgumentException("�����������1Ϊ��ʼ)��");
		}
        if(args.length == 2) {
	        String str2 = args[1].replaceFirst("^0*", "");// ����ȥ��ǰ���0
	        if(str2.charAt(0) != '1' && str2.charAt(0) != '2') {
	        	throw new IllegalArgumentException("�ڶ�������������1��2��");
	        }
        }
        len = Integer.parseInt(args[0]);
        generateExam6303(Integer.parseInt(args[1]));
        write6303();
        System.out.println("��Ŀ�Ѿ����ɣ��������out.txt");
    }
}
