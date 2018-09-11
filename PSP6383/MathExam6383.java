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
		return (int)(1+Math.random()*(100-0+1));
	}
	//生成题目
	
	public static void GetQuestion(int num) {
		String TempQuestion="";
		String TempAnswer="";
		for(int i=0;i<num;i++) {
			int Temp=GetRandomNum();
			int Temp2;
			if(GetRandomNum()>49) {
				Temp2=(int)(1+Math.random()*((100-Temp)-0+1));
				TempQuestion=TempQuestion+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" + "+String.valueOf(Temp2)+" ="+"\r\n";
				TempAnswer=TempAnswer+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" + "+String.valueOf(Temp2)+" = "+String.valueOf(Temp+Temp2)+"\r\n";
			}else {
				Temp2=(int)(1+Math.random()*(Temp-0+1));
				TempQuestion=TempQuestion+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" - "+String.valueOf(Temp2)+" ="+"\r\n";
				TempAnswer=TempAnswer+"("+String.valueOf(i+1)+") "+String.valueOf(Temp)+" - "+String.valueOf(Temp2)+" = "+String.valueOf(Temp-Temp2)+"\r\n";
			}			
		}
		System.out.println(TempQuestion+"\r\n"+TempAnswer);
		OutAnswer(TempQuestion+"\r\n"+TempAnswer);
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
		int n=0;
		//System.out.println("GetPath:"+args.length);
		//判断命令行参数个数
		if(args.length!=1) {
			System.out.println("Error:001");
			return;
		}
		Path=args[0];
		//判断是否为纯数字
		if(!isNum(Path)){
			System.out.println("Error:002");
			return;		
		}
		n=Integer.valueOf(Path);
		//判断输入参数是否不为0
		if(n==0){
			System.out.println("Error:004");
			return;	
		}
		//System.out.println(GetRandomNum()+"|"+n+"\n");
		GetQuestion(n);
	}

}
