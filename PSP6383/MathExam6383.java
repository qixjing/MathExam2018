import java.io.IOException;
import java.io.PrintWriter;

public class MathExam {
	//判断是否为纯数字
	public static boolean isNum(String str){ 
		   for(int i=0;i<str.length();i++){ 
		      int chr=str.charAt(i); 
		      if(chr<48 || chr>57) 
		         return false; 
		   } 
		   return true; 
		}
	//取一个随机数
	public static int GetRandomNum(){
		//(数据类型)(最小值+Math.random()*(最大值-最小值+1))
		return (int)(0+Math.random()*(100-0+1));
	}
	//生成题目(添加年级参数)
	
	public static void GetQuestion(int num,int Grade) {
		if(Grade==1) {
			String TempQuestion="";
			String TempAnswer="";
			for(int i=0;i<num;i++) {
				int Temp=GetRandomNum();
				int Temp2;
				if(GetRandomNum()>49) {
					Temp2=(int)(0+Math.random()*((100-Temp)-0+1));
					TempQuestion=TempQuestion+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" + "+String.valueOf(Temp2)+" ="+"\r\n";
					TempAnswer=TempAnswer+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" + "+String.valueOf(Temp2)+" = "+String.valueOf(Temp+Temp2)+"\r\n";
				}else {
					Temp2=(int)(0+Math.random()*(Temp-0+1));
					TempQuestion=TempQuestion+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" - "+String.valueOf(Temp2)+" ="+"\r\n";
					TempAnswer=TempAnswer+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" - "+String.valueOf(Temp2)+" = "+String.valueOf(Temp-Temp2)+"\r\n";
				}			
			}
			System.out.println(TempQuestion+"\r\n"+TempAnswer);
			OutAnswer(TempQuestion+"\r\n"+TempAnswer);
		}else {
			String Question="";
			String Answer="";
			for(int j=0;j<num;j++) {
				int Ismul=GetRandomNum();
				int mul1=(int)(0+Math.random()*(10-0+1));
				if(Ismul>49) {
					int mul2=(int)(0+Math.random()*(10-0+1));
					Question=Question+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" × "+String.valueOf(mul2)+" ="+"\r\n";
					Answer=Answer+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" × "+String.valueOf(mul2)+" = "+String.valueOf(mul1*mul2)+"\r\n";
				}else {
					int roo;
					//数据范围需要注意
					int mul2=(int)(1+Math.random()*(mul1-1+1));
					roo=mul1%mul2;
					if(roo==0) {
						Question=Question+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" ÷ "+String.valueOf(mul2)+" ="+"\r\n";
						Answer=Answer+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" ÷ "+String.valueOf(mul2)+" = "+String.valueOf(mul1/mul2)+"\r\n";	
					}else {
						Question=Question+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" ÷ "+String.valueOf(mul2)+" ="+"\r\n";
						Answer=Answer+"("+String.valueOf(j+1)+") "+String.valueOf(mul1)+" ÷ "+String.valueOf(mul2)+" = "+String.valueOf((int)mul1/mul2)+"..."+String.valueOf(roo)+"\r\n";
					}

					
				}
			}
			System.out.println(Question+"\r\n"+Answer);
			OutAnswer(Question+"\r\n"+Answer);
			
		}

	}
	//输出文件
	//记事本中需要/r/n才可以换行
	public static void OutAnswer(String str) {
		try {
			PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
			writer.println(str);
			writer.close();
		} catch ( IOException e ) {
            e.printStackTrace();
		}

	}
	//主函数
	public static void main(String[] args) {
		String Path;
		String Grade;
		int n=0;
		//System.out.println("GetPath:"+args.length);
		//判断命令行参数个数
		if(args.length!=2) {
			System.out.println("Error:001");
			return;
		}
		Path=args[0];
		Grade=args[1];
		//判断题目个数是否为纯数字
		if(!isNum(Path)){
			System.out.println("Error:002");
			return;		
		}
		//判断年级是否正确
		if(Integer.valueOf(Grade)!=1 && Integer.valueOf(Grade)!=2)
		{
			System.out.println("Error:003");
			return;		
		}
		n=Integer.valueOf(Path);
		//判断输入参数是否不为0
		if(n==0){
			System.out.println("Error:004");
			return;	
		}
		GetQuestion(n,Integer.valueOf(Grade));
	}

}
