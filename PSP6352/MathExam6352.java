
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.io.OutputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MathExam6352 {

	int FN, SN;		
	int symbol;	
	static int grade;
	static int count;		
	int result;		
	String cutLine = "==============答案==============";
	
	String[] str_MathQuestion = new String[100+1];	
	String[] str_MathAnswer = new String[100+1];

	public MathExam6352(){
		String count_Default = "10";	
		String grade_Default = "2";
		inPut(count_Default, grade_Default);
		mathProblem(count);
		outPut();
	}
	
	
	public MathExam6352(String args0){
		String grade_Default = "2";
		inPut(args0, grade_Default);
		mathProblem(count);
		outPut();
	}
	
	
	public MathExam6352(String args0,String args1){
		inPut(args0, args1);
		mathProblem(count);
		outPut();
	}

	private void inPut(String str0,String str1) {
		boolean flag1 = true;	
		boolean flag2 = true;
		
		Scanner in = new Scanner(System.in);
		String regex1 = "0*[1-9]{1}[0-9]{0,1}";		
		String regex2 = "0*[1-2]{1}{0}";
		Pattern pattern1 = Pattern.compile(regex1);
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher1,matcher2;
		
		while (true) {
			
			matcher1 = pattern1.matcher(str0);
			matcher2 = pattern2.matcher(str1);
			
			try {
				flag1 = matcher1.matches();
				flag2 = matcher2.matches();
				
				if(!flag1 || !flag2){		
						throw new NumberFormatException();		
				} else {	
					count = Integer.valueOf(str0);
					grade = Integer.valueOf(str1);
				}
			} catch (NumberFormatException e) {
				if(!flag1){
					System.out.println("输入错误，只能输入99以内的数量，请按重新输入题目数量 : ");
					str0 = in.next();
				} 
				if(!flag2){
					System.out.println("输入错误，年级为\"1\"或\"2\" ，请按重新输入年级 : ");
					str1 = in.next();
				}
				continue;
			}			
			in.close();
			break;
		}
	}
	
	private void outPut() {
		File file = new File("out.txt");
		Date date = new Date();/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String currentTime = "\r\n         211606352   陈彬   " + sdf.format(date);
		byte[] bytesdate = currentTime.getBytes();

		if(!file.exists()){	
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("文件创建时出现错误!");
			}
		}
		
		try {
			String str = "\r\n";
			byte[] bytes = str.getBytes();		
			byte[] bytescut = cutLine.getBytes();
			
			FileOutputStream fos = new FileOutputStream(file);	
			for (int i = 0; i < count; i++) {
				byte[] b_MathQuestion = str_MathQuestion[i].getBytes();
				fos.write(b_MathQuestion);
				fos.write(bytes);
			}
			fos.write(bytescut);
			fos.write(bytes);
			fos.flush();	
			for (int i = 0; i < count; i++) {
				byte[] b_MathAnswer = str_MathAnswer[i].getBytes();
				fos.write(b_MathAnswer);
				fos.write(bytes);
			}
			fos.write(bytesdate);
			fos.flush();
			fos.close();	
			
			System.out.print("-------  本次共生成" + count + "道小学"+ grade + "年级算数题，请打开out.txt文件查看详情    -------"); 

			
		} catch (FileNotFoundException e) {
			System.out.println("未找到指定文件!");
		} catch (IOException e) {
			System.out.println("文件写入有误!");
		} 
		
	}
	
	
	private void mathProblem(int count) {	
		Random rnd = new Random();
		
		for (int i = 0; i < count; i++) {
			symbol = rnd.nextInt(grade*2);
			FN = (int)(Math.random()*20+1);
			SN = (int)(Math.random()*20+1);
			
			if(grade == 1){
				switch (symbol) {
				case 0:
					add(FN,SN,i);
					break;
					
				case 1:
					sub(FN,SN,i);
					break;
					
				default:
					break;
				}
			} else {
				switch (symbol) {
				case 0:
					add(FN,SN,i);
					break;
					
				case 1:
					sub(FN,SN,i);
					break;
					
				case 2:
					mul(FN,SN,i);
					break;
					
				case 3:
					div(i);
					break;
					
				default:
					break;
				}
			}
			
		}
	}

	private void add(int n1, int n2,int i) {
		result = n1 + n2;
		str_MathQuestion[i] = "( " + (i+1) +" ) " + n1 + " + " + n2 + " = ";
		str_MathAnswer[i] = "( " + (i+1) +" ) " + n1 + " + " + n2 + " = " + result;
	}
	
	
	private void sub(int n1, int n2,int i) {
		if (n1 < n2) {		
			int num;
			num = n1;
			n1 = n2;
			n2 = num;
		}
		result = n1 - n2;
		str_MathQuestion[i] = "( " + (i+1) +" ) " + n1 + " - " + n2 + " = ";
		str_MathAnswer[i] = "( " + (i+1) +" ) " + n1 + " - " + n2 + " = " + result;
	}
	
	
	private void mul(int n1, int n2,int i) {
		if (n1 > 9) {
			n1 = (int)(Math.random()*10);
		} 
		if (n2 > 9) {
			n2 = (int)(Math.random()*10);
		}
		result = n1 * n2;
		str_MathQuestion[i] = "( " + (i+1) +" ) " + n1 + " x " + n2 + " = ";
		str_MathAnswer[i] = "( " + (i+1) +" ) " + n1 + " x " + n2 + " = " + result;
	}
	
	
	private void div(int i) {
		while(true){
			int n1 = (int)(Math.random()*82);
			int n2 = (int)(Math.random()*81+1);
			if(n1 % n2 == 0){
				result = n1 / n2;
				str_MathQuestion[i] = "( " + (i+1) +" ) " + n1 + " / " + n2 + " = ";
				str_MathAnswer[i] = "( " + (i+1) +" ) " + n1 + " / " + n2 + " = " + result;
			}else if(n1 % n2 != 0){
				result = n1 / n2;
				str_MathQuestion[i] = "( " + (i+1) +" ) " + n1 + " / " + n2 + " = ";
				str_MathAnswer[i] = "( " + (i+1) +" ) " + n1 + " / " + n2 + " = " + result + "..." + (n1 % n2);
			}
			break;
		}
	}
	
	
	public static void main(String[] args) {
		if(args.length == 0){
			new MathExam6352();
		} else if(args.length == 1){
			new MathExam6352(args[0]);
		}
		else if(args.length == 2){
			new MathExam6352(args[0], args[1]);
		}else {
			new MathExam6352(args[0], args[1]);
		}
		
	}

}
