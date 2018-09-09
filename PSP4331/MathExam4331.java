

//主方法


import java.util.ArrayList;
import java.util.Random;

class MathExam4331{
	
	static ArrayList<String> answerSet;      //答案集合
	static int testNumber=0;                  //题号	
	static int n=0;							//题数
	static String errMessage;           //错误信息
	static int grade=1;            //年级，默认为一年级
	static boolean isErro=true;      //是否错误
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length==0 || args.length>2) {
			isErro=false;
			errMessage="参数不能为空，且参数个数需小于等于2";
		}
		else if(!args[0].matches("\\d*")) {
			isErro=false;
			errMessage="第一个参数不全为数字，请输入数字";
		}
		else if(args[0].length()>5 && args[0].matches("1|1\\d*")) {      
			isErro=false;
			errMessage="第一个参数错误，题目数量需大于0小于9999";
		} 
		else if(args.length==2) {
			if(!args[1].matches("\\d*")) {
				isErro=false;
				errMessage="第二个参数错误，年级需全为数字";
			}
			else if(!args[1].matches("[12]"))
			{
				isErro=false;
				errMessage="第二个参数错误，年级需为数字1或2";
			}
			
			
		}
		
		if(isErro) {          //n输入合法的时候
		
		n=Integer.valueOf(args[0]);
		if(args.length==2 && Integer.valueOf(args[1])==2) {			
			grade=2;
		}
		else 
			grade=0;
		answerSet=new ArrayList();
		Random rand=new Random();
		
		for(int i=1;i<=n;i++) {
			int s=rand.nextInt(2);
			s=s+grade;
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
				case 2:                    //乘法
				{
					testNumber++;
					Multiplication opp=new Multiplication(answerSet,testNumber);
					break;
				}
				case 3:                  //除法
				{
					testNumber++;
					Division opp=new Division(answerSet,testNumber);
					break;
				}
			}
			
		}
		
		//输出题目(测试)
		OutPutSet ops=new OutPutSet(n);
		}
		else
			System.out.println(errMessage);
		
	}

}
