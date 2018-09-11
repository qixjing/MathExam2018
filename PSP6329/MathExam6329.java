import java.io.BufferedReader;				
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MathExam6329{
public static void main(String[] args)throws IOException {    
	String s;
	args=new String[2];
	int x=0,y=0;
		x=Integer.parseInt(args[0]);
		y=Integer.parseInt(args[1]);
	//将字符串参数强制转换成int型

	File file = new File ("out.txt");
	if(!file.exists())	
	{
	file.createNewFile();

	}	
	FileWriter fw = new FileWriter(file);
	BufferedWriter bw = new BufferedWriter(fw);
	int no=1,m=0,number = 0;
	int [] a =new int[x+1];
	int [] b =new int[x+1];
	int [] c =new int[x+1];
	//+1防止数组越界
	Random r=new Random();
	while(no<=x){
		{	
			bw.write(String.valueOf('('));
			bw.write(String.valueOf(no));
			bw.write(String.valueOf(')'));
			bw.write(String.valueOf(' '));
		}//序号
		if(y==1){
			number = (int)Math.ceil((r.nextDouble()*2.0));b[m]=number;
		for(;;){
			number = (int)Math.floor((r.nextDouble()*100.0));a[m]=number;
			number = (int)Math.floor((r.nextDouble()*100.0));c[m]=number;
			if(b[m]==1)if(a[m]+c[m]<100)break;
			if(b[m]==2)if(a[m]-c[m]>=0)break;
		}
		}
		//一年级
		if(y==2){number = (int)Math.ceil((r.nextDouble()*4.0));
		b[m]=number;
		{
			if(b[m]==1||b[m]==2)
				for(;;){
				number = (int)Math.floor((r.nextDouble()*100.0));a[m]=number;
				number = (int)Math.floor((r.nextDouble()*100.0));c[m]=number;
				if(b[m]==1)if(a[m]+c[m]<100)break;
				if(b[m]==2)if(a[m]-c[m]>=0)break;
			}
			else for(;;){
				number = (int)Math.ceil((r.nextDouble()*99.0));a[m]=number;
				number = (int)Math.ceil((r.nextDouble()*9.0));c[m]=number;
				if(b[m]==3)if(a[m]*c[m]<100)break;
				if(b[m]==4)if(a[m]%c[m]==0&&a[m]>=c[m])break;
			}
		}
		}//二年级
		bw.write(String.valueOf(a[m]));
		bw.write(String.valueOf(' '));
		if(b[m]==1)bw.write(String.valueOf('+'));
		else if(b[m]==2)bw.write(String.valueOf('-'));
		else if(b[m]==3)bw.write(String.valueOf('*'));
		else if(b[m]==4)bw.write(String.valueOf('/'));
		bw.write(String.valueOf(' '));
	 	bw.write(String.valueOf(c[m]));
	 	bw.write(String.valueOf(' '));
	 	bw.write(String.valueOf('='));
	 	bw.write(String.valueOf(' '));
	 	no++;
	 	m++;
	 	bw.newLine();
	}	bw.write(String.valueOf(" -----------------------标准答案 -----------------------"));
	bw.newLine();
	int i=0,z=0;
	for(no=1;i<m;i++)
	{
		{	
			bw.write(String.valueOf('('));
			bw.write(String.valueOf(no));
			bw.write(String.valueOf(')'));
			bw.write(String.valueOf(' '));
			bw.write(String.valueOf(a[i]));
			bw.write(String.valueOf(' '));
			if(b[i]==1){bw.write(String.valueOf('+'));z=a[i]+c[i];}
			else if(b[i]==2){bw.write(String.valueOf('-'));z=a[i]-c[i];}
			else if(b[i]==3){bw.write(String.valueOf('*'));z=a[i]*c[i];}
			else if(b[i]==4){bw.write(String.valueOf('/'));z=a[i]/c[i];}
			bw.write(String.valueOf(' '));
		 	bw.write(String.valueOf(c[i]));
		 	bw.write(String.valueOf(' '));
		 	bw.write(String.valueOf('='));
		 	bw.write(String.valueOf(' '));
		 	bw.write(String.valueOf(z));
		 	bw.newLine();
		}
//		时间
	}bw.close();
}
}