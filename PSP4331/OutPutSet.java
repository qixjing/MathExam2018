

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class OutPutSet {                //用于输出集合中的题目

	public OutPutSet(int n) {               //n用来判断有几个题目
		
		
		try ( PrintWriter w = new PrintWriter("out.txt")) //打印到out.txt文档
		{
			
			for(int i=0;i<=(2*n-2);i=i+2)
				w.println(MathExam4331.answerSet.get(i));  //输出题目
			
			w.println("");
			
			for(int i=0;i<=(2*n-2);i=i+2)
			{
				w.print(MathExam4331.answerSet.get(i));      //输出题目
				w.println(MathExam4331.answerSet.get(i+1));     //输出答案
				
			}
			w.close();//关闭流
		} catch(IOException e){
			
		}
				
	}
}
