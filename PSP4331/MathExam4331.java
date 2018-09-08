package PSP4331;

//主方法


import java.util.ArrayList;
import java.util.Random;

class MathExam4331{
	
	static ArrayList<String> answerSet; //答案集合
	static int testNumber=0;//题号	
	static int n=10;//题数
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		answerSet=new ArrayList();
		//Random rand = new Random();
		//int s=rand.nextInt(2);
		for(int i=1;i<=n;i++) {
			switch(0) {
				case 0:                          //为加号时
				{
					testNumber++;
					AddOperation opp=new AddOperation(answerSet,testNumber);
					break;
				}
				case 1:                      //为减号时
				{
					Subtraction opp=new Subtraction();
					break;
				}
			}
			
		}
		
		//输出题目(测试)
		OutPutSet ops=new OutPutSet(n);
		
	}

}
