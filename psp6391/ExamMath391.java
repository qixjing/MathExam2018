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
			//����ָ���ļ������������
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
			System.out.println("�������꼶��");
			if(grade == 2)  //�ж��꼶��Ĭ��Ϊ1�꼶
		 {
					System.out.println("��������Ҫ�������Ŀ��");
					Scanner s=new Scanner(System.in);
					int m = s.nextInt();
					double aa[]=new double[m]; 
					double bb[]=new double[m];
					double cc[]=new double[m];
					int m1=1;
					for(int a=0; a<m;a++)
					{
						int i=(int) Math.floor(Math.random()*10+1);//������������涨��Χ����������Ϊ0
						int j=(int) Math.floor(Math.random()*10+1);//������������涨��Χ����������Ϊ0
						int x=(int) Math.floor(Math.random()*2+1);//������������涨��Χ����������Ϊ0
						aa[a]=i;//���������������
						bb[a]=j;//���������������
						cc[a]=x;//���������������
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
					    B[m-1]=(int) (aa[a1]%bb[a1]); //��������������
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
					System.out.println("��������Ҫ�������Ŀ��");
					Scanner s=new Scanner(System.in);
					int aa[]=new int[n];
					int bb[]=new int[n];
					int cc[]=new int[n];
					int m1=1;
					for(int a=0; a<n;a++)
					{
						int i=(int) Math.floor(Math.random()*20+1); //������������涨��Χ����������Ϊ0
						int j=(int) Math.floor(Math.random()*20+1); //������������涨��Χ����������Ϊ0
						int x=(int) Math.floor(Math.random()*2+1); //������������涨��Χ����������Ϊ0
						aa[a]=i; //���������������
						bb[a]=j;//���������������
						cc[a]=x;//���������������
						if(x%2==1) {		//�жϼӼ���
						System.out.println("(" + m1 + ") "+ i +" + " + j + "=");
						}else {
						System.out.println("(" + m1 + ") "+ i + " - "+j+"= ");
						}
						m1++;  //��ų�������
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