import java.util.ArrayList;
import java.util.Random;

//乘法运算类
//二年级表内乘法
public class Multiplication extends Operation{

	public  Multiplication(ArrayList<String> answerSet,int testNumber) {
		
		Random rand=new Random(); //产生随机数
		
		firstNumber=rand.nextInt(9)+1;//随机数产生范围为[0-9)，所以随机数+1就能避免出现0和10的情况
		secondNumber=rand.nextInt(9)+1;//随机产生第二个数，表内乘法
		answerNumber=firstNumber*secondNumber;
		answerSet.add("("+testNumber+")"+" "+firstNumber+" * "+secondNumber+" =");//把结果输出的集合中
		answerSet.add(" "+answerNumber); //把答案输出到集合中
	
	}
	
}
