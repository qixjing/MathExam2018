import java.util.ArrayList;
import java.util.Random;

//除法运算
//二年级除法，除数是一位数，商也是一位数，有余数的除法；表内除法
public class Division extends Operation{

	public Division(ArrayList<String> answerSet,int testNumber) {
		
		boolean isRemainder=false;          //是否需要产生余数
		Random rand=new Random(); //产生随机数
		
		firstNumber=rand.nextInt(9)+1;       //(除数)     随机数产生范围为[0-9)，所以随机数+1就能避免出现0和10的情况
		secondNumber=rand.nextInt(9)+1;           //(商)   随机产生第二个数，表内除法		
		answerNumber=firstNumber*secondNumber;      //(被除数)
				
		isRemainder=rand.nextBoolean();
		
		if(isRemainder)                       //需要产生随机数
		{	
			remainder=rand.nextInt(firstNumber-1);     //产生余数
			answerNumber=answerNumber+remainder;    //生成新的被除数
			answerSet.add("("+testNumber+")"+" "+answerNumber+" * "+firstNumber+" =");//把结果输出的集合中
			answerSet.add(" "+secondNumber+"..."+remainder); //把答案输出到集合中
		}
		else {                 //不需要产生余数的情况		
			answerSet.add("("+testNumber+")"+" "+answerNumber+" * "+firstNumber+" =");//把结果输出的集合中
			answerSet.add(" "+secondNumber); //把答案输出到集合中
		}
	}
}
