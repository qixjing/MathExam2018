

//主方法


import java.util.ArrayList;
import java.util.Random;

class MathExam4331{
	
	static ArrayList<String> answerSet;      //答案集合
	static int testNumber=0;                  //题号	
	static int n=0;                            //题数
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length!=0) {     //n输入合法的时候
		
		n=Integer.valueOf(args[0]);
		answerSet=new ArrayList();
		Random rand=new Random();
		
		for(int i=1;i<=n;i++) {
			int s=rand.nextInt(2);
			switch(s) {
				case 0:                          //为加号时
				{
					testNumber++;
					AddOperation opp=new AddOperation(answerSet,testNumber);
					break;
				}
				case 1:                      //为减号时
				{
					testNumber++;
					Subtraction opp=new Subtraction(answerSet,testNumber);
					break;
				}
			}
			
		}
		
		//输出题目(测试)
		OutPutSet ops=new OutPutSet(n);
		}
		else
			System.out.println("输入有误，请输入小于20000的数字");
		
	}

}
