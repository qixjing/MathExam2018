import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.print.attribute.standard.Sides;

public class MathExam6330 {		
	// 生成小学一年级数学加减计算题
	public static void getFirstGradeMathSubject(int n,int grade){
		/* 定义两个数组分别用于存放算式和答案
		 注意:数组左闭右开,数组长度应当为n+1，否则会引起数组越界
		 */
		String[] mathSubjectArray = new String[n+1];
		mathSubjectArray[0]="";
		String[] sumArray = new String[n+1];
		sumArray[0]=null;
		for(int i=1;i<=n;i++){
		    int firstNumber;
		    int secondNumber;
		    int	thirdNumber;
		    String randomSymbol=null;
		    Random randomNumber=new Random();
		    /* 取三个在[0，21)之间的整数,前两个随机整数作为算式的因子,
			第三个随机数作为确定算式符号的依据，当该随机数大于10时,
		       算式为加法，反之为减法
		    */
		    firstNumber=randomNumber.nextInt(21);
		    secondNumber=randomNumber.nextInt(21-firstNumber);
		    thirdNumber=randomNumber.nextInt(21);
		    if(thirdNumber>10){
		    	randomSymbol="+";
		    }else{
		    	randomSymbol="-";
		    }
		    mathSubjectArray[i]="("+i+")"+" "+firstNumber+randomSymbol+secondNumber+" = ";
		    if(randomSymbol.equals("-")){
		    	if((firstNumber-secondNumber)>=0){
		    		sumArray[i]=firstNumber-secondNumber+"";
		    	}else{
		    		sumArray[i]=secondNumber-firstNumber+"";
		    		mathSubjectArray[i]="("+i+")"+" "+secondNumber+randomSymbol+firstNumber+" = ";
		    	}
		    }else{
		    	sumArray[i]=firstNumber+secondNumber+"";
		    }
		}
		saveMathAnswer(mathSubjectArray, sumArray);
		getMathAnswer();
	}
	
	// 生成小学二年级乘除计算题
	public static void getSecondGradeMathSuject(int n,int grade){
		/* 定义两个数组分别用于存放算式和答案
		 注意:数组左闭右开,数组长度应当为n+1，否则会引起数组越界
		 */
		String[] mathSubjectArray = new String[n+1];
		mathSubjectArray[0]="";
		String[] sumArray = new String[n+1];
		sumArray[0]=null;
		for(int i=1;i<=n;i++){
		    int firstNumber;
		    int secondNumber;
		    int	thirdNumber;
		    String randomSymbol=null;
		    Random randomNumber=new Random();
		    /* 取两个在1-9之间的随机整数作为算式的因子,
			第三个随机数作为确定算式符号的依据，当该随机数大于4时,
		       算式为乘法，反之为除法
		    */
		    firstNumber=randomNumber.nextInt(9)+1;
		    secondNumber=randomNumber.nextInt(9)+1;
		    thirdNumber=randomNumber.nextInt(9);
		    if(thirdNumber>4){
		    	randomSymbol="×";
		    }else{
		    	randomSymbol="÷";
		    }
		    mathSubjectArray[i]="("+i+")"+" "+firstNumber+randomSymbol+secondNumber+" = ";
		    // 定义商和余数
    		String quotient=null;
    		String remainder=null;
    		// 判断算式是乘法运算还是除法运算
		    if(randomSymbol.equals("÷")){
		    	// 当算式为除法时，重新生成两个因数，使得两个因数小于81
		    	firstNumber=randomNumber.nextInt(80)+1;
		    	secondNumber=randomNumber.nextInt(80)+1;
		    	// 判断被除数是否大于除数
		    	if(firstNumber>secondNumber){
		    		// 判断是否能够整除
		    		if((firstNumber%secondNumber)==0){
		    			quotient=firstNumber/secondNumber+"";
		    			sumArray[i]=quotient;
		    		}else{
		    			quotient=firstNumber/secondNumber+"";
		    			remainder=firstNumber%secondNumber+"";
		    			sumArray[i]=quotient+"..."+remainder;
		    		}
		    	// 修改因数后要相应的修改算式
		    	mathSubjectArray[i]="("+i+")"+" "+firstNumber+randomSymbol+secondNumber+" = ";
		    	}else{
		    		//当被除数小于除数时将被除数和除数互换
		    		if((secondNumber%firstNumber)==0){
		    			quotient=secondNumber/firstNumber+"";
		    			sumArray[i]=quotient;
		    		}else{
		    			quotient=secondNumber/firstNumber+"";
		    			remainder=secondNumber%firstNumber+"";
		    			sumArray[i]=quotient+"..."+remainder;
		    		}
		    		mathSubjectArray[i]="("+i+")"+" "+secondNumber+randomSymbol+firstNumber+" = ";
		    	}
		    }else{
		    	sumArray[i]=firstNumber*secondNumber+"";
		    }
		}
		saveMathAnswer(mathSubjectArray, sumArray);
		getMathAnswer();	
	}
	
	// 保存生成的题目及答案
	public static void saveMathAnswer(String[] mathSubjectArray, String[] sumArray){
		File file=new File("out.txt");
		if(!file.exists()){
			File parent=file.getParentFile();
			if(parent!=null  && !parent.exists()){
				file.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		BufferedWriter bw=null;
		String str="";
		try{
			bw=new BufferedWriter(new FileWriter(file));
			// 保存算式
			for(int i=1;i<mathSubjectArray.length;i++){
				str=mathSubjectArray[i];
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			bw.newLine();
			bw.flush();
			// 生成答案
			for(int i=1;i<mathSubjectArray.length;i++){
				str=mathSubjectArray[i]+sumArray[i];
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 输出生成的题目和答案
	public static void getMathAnswer(){
		File file=new File("out.txt");
		BufferedReader br=null;
		String str="";
		try {
			br=new BufferedReader(new FileReader(file));
			try {
				while((str=br.readLine())!=null){
					System.out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
			System.out.println("请输入:想要生成的题目数(1-100) 生成几年级的题目(1或2年级)");
			Scanner sc=new Scanner(System.in);
			String input=sc.nextLine();
			// 书写符合输入格式的正则表达式，过滤不符合格式的输入
			String regex="(([1-9]|[1-9][0-9]|100)( ?)(1?|2{1}))";
			int n;
			int grade;
			// 判断输入是否以空格结尾
			int flag=0;
			if(input.matches(regex)){
				//只输入题目数的情况,如:10
				for(int i=0;i<input.length();i++){
					if((input.substring(i,i+1)).equals(" ")){
						flag=1;
						break;
					}
				}
				if(flag==0){
					n=Integer.valueOf(input);
					grade=1;
					getFirstGradeMathSubject(n, grade);
					return ;
				}
				// 输入为题目数+一个空格的情况,如:10+一个空格
				if(input.endsWith(" ")){
					n=Integer.valueOf(input.substring(0, input.length()-1));
					grade=1;
					getFirstGradeMathSubject(n, grade);
					return ;
				}else{
					// 输入符合格式，如:10 1或2时的情况
					String[] spiltArray=null;
					spiltArray=input.split(" ");
					n=Integer.valueOf(spiltArray[0]);
					grade=Integer.valueOf(spiltArray[1]);
					if(grade==1){
						getFirstGradeMathSubject(n, grade);
					}else{
						getSecondGradeMathSuject(n, grade);
					}
					return ;
				}
			}else{
				System.out.println("输入格式错误!"
				+ "请按照如下格式输入:\n想要生成的题目数(1-100)"+" "
				+ "生成几年级的题目(1或2年级)"
				+ "\n注:如果没有指定年级，则默认生成一年级数学的题目");
			}
		
		}
	}

