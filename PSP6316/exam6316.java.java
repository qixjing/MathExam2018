package com.java.exam1;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class exam1 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("out.txt");
		//����ָ���ļ������������
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		// TODO Auto-generated method stub	
		Scanner s=new Scanner(System.in);
		System.out.println("�������꼶��");
		int grade = s.nextInt();
		if(grade == 2) { //�ж��꼶��Ĭ��Ϊ1�꼶
			grade_two();
		}else { 
			grade_one();
		}
		}
		

	
		public static void grade_one() {	
			System.out.println("��������Ҫ�������Ŀ��");
			Scanner s=new Scanner(System.in);
			int n = s.nextInt();
			int ai[]=new int[n];
			int aj[]=new int[n];
			int ax[]=new int[n];
			int m1=1;
			for(int a=0; a<n;a++)
			{
				int i=(int) Math.floor(Math.random()*20+1); //������������涨��Χ����������Ϊ0
				int j=(int) Math.floor(Math.random()*20+1); //������������涨��Χ����������Ϊ0
				int x=(int) Math.floor(Math.random()*2+1); //������������涨��Χ����������Ϊ0
				ai[a]=i; //���������������
				aj[a]=j;//���������������
				ax[a]=x;//���������������
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
			if(ax[a1]%2==1) 
			{
			System.out.println("("+ m2 +") "+ ai[a1] +" + "+ aj[a1] +" = "+(ai[a1]+aj[a1]));
			}else {
			System.out.println("("+ m2 +") "+ ai[a1] +" - "+ aj[a1] +" = "+(ai[a1]-aj[a1]));
			}
			m2++;
		}
	}
			
		public static void grade_two() {
			System.out.println("��������Ҫ�������Ŀ��");
			Scanner s=new Scanner(System.in);
			int m = s.nextInt();
			double ai[]=new double[m]; 
			double aj[]=new double[m];
			double ax[]=new double[m];
			int m1=1;
			for(int a=0; a<m;a++)
			{
				int i=(int) Math.floor(Math.random()*10+1);//������������涨��Χ����������Ϊ0
				int j=(int) Math.floor(Math.random()*10+1);//������������涨��Χ����������Ϊ0
				int x=(int) Math.floor(Math.random()*2+1);//������������涨��Χ����������Ϊ0
				ai[a]=i;//���������������
				aj[a]=j;//���������������
				ax[a]=x;//���������������
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
			    B[m-1]=(int) (ai[a1]%aj[a1]); //��������������
			if(ax[a1]%2==1) 
			{
			System.out.println("("+ m2 +") "+ ai[a1] +" * "+ aj[a1] +" = "+(ai[a1]*aj[a1]));
			}else {
				if(ai[a1]%aj[a1]==0)
				{
					System.out.println("("+ m2 +") "+ ai[a1] +" / "+ aj[a1] +" = "+floor(ai[a1]/aj[a1]));
				}else {
					System.out.println("("+ m2 +") "+ ai[a1] +" / "+ aj[a1] +" = "+floor((ai[a1]/aj[a1]))+"..."+B[m-1]);
			}
				}
			m2++;
		}
		
	
	}

		private static String floor(double d) {
			// TODO Auto-generated method stub
			return null;
		}
		
	
}