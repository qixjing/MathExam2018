import java.util.ArrayList;
import java.util.Random;

//减法运算
public class Subtraction extends Operation {
	
	public Subtraction(ArrayList<String> answerSet,int testNumber) {
		
			Random rand = new Random();
			firstNumber=rand.nextInt(100);
			if((firstNumber/10)>0)   //是两位数  (根据教学大纲，两位数只能减个位数或者整十数)
			{
				do {
					secondNumber=rand.nextInt(10);        //输出个位数
					int n=0;
					n=rand.nextInt(2);         //判断是否需要变成整十数   0:不变  1：变
					if(n==0) 
						answerNumber=firstNumber-secondNumber;
					else 
					{
						secondNumber=secondNumber*10;
						answerNumber=firstNumber-secondNumber;
					}
								
				}while(answerNumber<0);
			}
			else {                 //是一位数
					int n;
					secondNumber=rand.nextInt(9);
					if(secondNumber>firstNumber) // bug修复：如果第二个数比第一个数大，就交换位置
					{
						n=firstNumber;
						firstNumber=secondNumber;
						secondNumber=n;
						
					}
					answerNumber=firstNumber-secondNumber;

			}
			answerSet.add("("+testNumber+")"+" "+firstNumber+" - "+secondNumber+" =");//把结果输出的集合中
			answerSet.add(" "+answerNumber); //把答案输出到集合中
			
		
	}
}
