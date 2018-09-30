import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import java.util.Scanner;

public class ExamMath391 {
		public static void main(String[] args) throws FileNotFoundException {
			File file = new File("out.txt");
			//创建指向文件的数据输出流
			if(!file.exists())	
			{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			}
			DataOutputStream out = new DataOutputStream(new FileOutputStream(file));	
			// TODO Auto-generated method stub	
			int n=Integer.parseInt(args[0]);
			int grade=Integer.parseInt(args[1]);
			System.out.println("请输入年级：");
			if(grade == 2)  //判断年级，默认为1年级
		 {
					System.out.println("请输入需要出题的数目：");
					Scanner s=new Scanner(System.in);
					int m = s.nextInt();
					double aa[]=new double[m]; 
					double bb[]=new double[m];
					double cc[]=new double[m];
					int m1=1;
					for(int a=0; a<m;a++)
					{
						int i=(int) Math.floor(Math.random()*10+1);//生成随机数，规定范围，并让他不为0
						int j=(int) Math.floor(Math.random()*10+1);//生成随机数，规定范围，并让他不为0
						int x=(int) Math.floor(Math.random()*2+1);//生成随机数，规定范围，并让他不为0
						aa[a]=i;//将随机数存入数组
						bb[a]=j;//将随机数存入数组
						cc[a]=x;//将随机数存入数组
						if(x%2==1) {
						System.out.println("(" + m1 + ") "+ i +" * " + j + "=");
						}else {
						System.out.println("(" + m1 + ") "+ i + " / " + j + "= ");
						}
						m1++;
					}	
					System.out.println("                  ");		
					int m2=1;
					for(int a1=0;a1<m;a1++)
					{
						int B[]=new int[m];  
					    B[m-1]=(int) (aa[a1]%bb[a1]); //将余数存入数组
					if(cc[a1]%2==1) 
					{
					System.out.println("("+ m2 +") "+ aa[a1] +" * "+ bb[a1] +" = "+(aa[a1]*bb[a1]));
					}else {
						if(aa[a1]%bb[a1]==0)
						{
							System.out.println("("+ m2 +") "+ aa[a1] +" / "+ bb[a1] +" = "+floor(aa[a1]/bb[a1]));
						}else {
							System.out.println("("+ m2 +") "+ aa[a1] +" / "+ bb[a1] +" = "+floor((aa[a1]/bb[a1]))+"..."+B[m-1]);
					}
						}
					m2++;
				}
				
			
			}

			else {	
					System.out.println("请输入需要出题的数目：");
					Scanner s=new Scanner(System.in);
					int aa[]=new int[n];
					int bb[]=new int[n];
					int cc[]=new int[n];
					int m1=1;
					for(int a=0; a<n;a++)
					{
						int i=(int) Math.floor(Math.random()*20+1); //生成随机数，规定范围，并让他不为0
						int j=(int) Math.floor(Math.random()*20+1); //生成随机数，规定范围，并让他不为0
						int x=(int) Math.floor(Math.random()*2+1); //生成随机数，规定范围，并让他不为0
						aa[a]=i; //将随机数存入数组
						bb[a]=j;//将随机数存入数组
						cc[a]=x;//将随机数存入数组
						if(x%2==1) {		//判断加减法
						System.out.println("(" + m1 + ") "+ i +" + " + j + "=");
						}else {
						System.out.println("(" + m1 + ") "+ i + " - "+j+"= ");
						}
						m1++;  //序号持续增加
						}
						
					System.out.println("                  ");		
					int m2=1;
					for(int a1=0;a1<n;a1++)
					{
					if(cc[a1]%2==1) 
					{
					System.out.println("("+ m2 +") "+ aa[a1] +" + "+ bb[a1] +" = "+(aa[a1]+bb[a1]));
					}else {
					System.out.println("("+ m2 +") "+ aa[a1] +" - "+ bb[a1] +" = "+(aa[a1]-bb[a1]));
					}
					m2++;
					}
			}
		}
				
			private static String floor(double d) {
				// TODO Auto-generated method stub
				return null;
			}
			
		
	}