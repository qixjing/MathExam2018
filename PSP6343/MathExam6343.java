import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;
//import java.io.OutputStream;
public class MathExam6343 {
	public static void main(String[] args) throws Exception{
		File file = new File("cc.txt");		//输出的文件
		int []n =new int [args.length] ;	//创建传入参数数组
		Scanner sc = new Scanner(System.in);			

		boolean flag = true;
		boolean flag1 = true;
		
		n[0] = Integer.parseInt(args[0]);	//对第一个传入参数限制
		while (flag) {
			if(n[0]>0 && n[0]<9999)
				flag = false;
			else {
				System.out.println("重新输入要出题个数");				
				n[0] = sc.nextInt();
				if(n[0]>0 && n[0]<9999)
					break;
				
			}
		}
		
	    n[1] = Integer.parseInt(args[1]);	//对第二个传入参数限制
	    while(flag1) {
	    	if(n[1]==1 || n[1]==2)
	    		flag1 = false;
	    	else {
	    		System.out.println("重新输入正确年级数");
	    		n[1] = sc.nextInt();
	    		if(n[1]==1 || n[1] == 2)
	    			break;
	    	}
	    }
		if(!file.exists())						//判断TXT是否存在
		{
		file.createNewFile();
		System.out.println("cc.txt创建完成");
		}
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);		


		//int g=sc.nextInt();
		int [] as = new int[n[0]+5];
		int [] bs = new int[n[0]+5];
		char [] cs = new char[n[0]+5];
		int [] ds = new int[n[0]+5];
		int[] es = new int [n[0]+5];
		//int x = sc.nextInt();
		
	
		if(n[1]==1) {
			for(int i =1;i<=n[0];i++) {			
			int a=(int)(Math.random()*100+1);   
			as[i] = a;													
	        int c=(int)(Math.random()*100+1);
	        {
	        	if(c%2==1) {
	        		cs[i] = '-';
	        	}
	        	else  {
	        		cs[i] = '+';
	        		}
	        }	        	        
	        int b=(int)(Math.random()*100+1);	//b值
	        bs[i] = b;
	        
	        if(c%2==1 && a<b) {
	        	int answer = a+b;
	        	cs[i]='+';
	        	ds[i]=(char) answer;
	        }
	        
	        else if(c%2==1 ) {
	        	int answer = a-b;
	        	ds[i] = (char) answer;

	        }
	        else {
	        	int answer =a+b;
	        	ds[i] = (char) answer;

	        }
		}
		}	
		
		if (n[1]==2) {
			for(int i =1;i<=n[0];i++) {
			int a=(int)(Math.random()*100+1);
			as[i] = a;
			int b=(int)(Math.random()*100+1);
			bs[i] = b;
			
			int c=(int)(Math.random()*4);
			if(c==0) {
				cs[i]='+';
				int answer = a+b;
				ds[i]= answer;
				
			}
			if(c==1) {
				cs[i]='-';
				int answer = a-b;
				ds[i]= answer;
			}
			if(c==2) {
				cs[i]='*';
				int answer = a*b;
				ds[i] = answer;
			}
			if(c==3) {
				cs[i]='/';
				if(a%b==0) {
				int answer = a/b;
				ds[i] = answer;
			}
				else{
					cs[i]='/';
					if(a/b==0 && a>b) {
					int answer = a/b ;
					ds[i] = answer;;
					}
					else {
					int answer = a/b;
					ds[i] = answer; 
					es[i] = a%b;
					}
				}
				}
		}
		}	
		for(int i=1;i<=n[0];i++) {
			//System.out.print("("+i+")");
			bw.write(String.valueOf("("+i+")"));
			//System.out.print(as[i]);
			bw.write(String.valueOf(as[i]));	
			//System.out.print(cs[i]);
			bw.write(String.valueOf(cs[i]));	
			//System.out.println(bs[i]);
			bw.write(String.valueOf(bs[i]));
			bw.newLine();
		}
		//System.out.println("-------------标准答案--------------");
		bw.write(String.valueOf("-------------标准答案--------------"));
		bw.newLine();
			
		for(int i=1;i<=n[0];i++) {
			//System.out.print("("+i+")");
			bw.write(String.valueOf("("+i+")"));
			//System.out.print(as[i]);
			bw.write(String.valueOf(as[i]));
			//System.out.print(cs[i]);
			bw.write(String.valueOf(cs[i]));
			//System.out.print(bs[i]);
			bw.write(String.valueOf(bs[i]));
			//System.out.print("="+ds[i]);
			bw.write(String.valueOf("="+ds[i]));
			if(es[i] != 0) {
				//System.out.println("...."+es[i]);
				bw.write(String.valueOf("...."+es[i]));
				bw.newLine();
				continue;
			}
			else {
				//System.out.print("\n");
			}
		
			bw.newLine();
		}
		bw.close();
		fw.close();
	}}