import java.util.ArrayList;
import java.util.Random;

//除法运算
//二年级除法，除数是一位数，商也是一位数，有余数的除法；表内除法
public class Division extends Operation{

	public Division(ArrayList<String> answerSet,int testNumber) {
		Random rand=new Random();
		
		do {
			
		firstNumber=rand.nextInt(99)+1;   //被除数
		secondNumber=rand.nextInt(9)+1;      //除数
		remainder=firstNumber%secondNumber;   //余数
		answerNumber=firstNumber/secondNumber; //商
				
		}while(answerNumber>=10 || firstNumber<secondNumber);
		
		if(remainder==0) {
			answerSet.add("("+testNumber+")"+" "+firstNumber+" / "+secondNumber+" =");//把结果输出的集合中
			answerSet.add(" "+answerNumber); //把答案输出到集合中
		}
		else {
			answerSet.add("("+testNumber+")"+" "+firstNumber+" / "+secondNumber+" =");//把结果输出的集合中
			answerSet.add(" "+answerNumber+"..."+remainder); //把答案输出到集合中
		}
		
		
		
	}
}

