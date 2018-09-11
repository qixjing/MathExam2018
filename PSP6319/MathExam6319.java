package Work01.Math;

import java.util.Scanner;

public class MathExam6319 {
	public static void main(String[] args){

		Scanner g=new Scanner(System.in);
		System.out.println("请输入你所在的年级(1或2)：");
		int grade=g.nextInt();
		if(grade==1) {
			one();
		}else if(grade==2) {
			two();
		}
		
	}
	public static void thire() {
		
	}
	
	public static void one() {
		System.out.println("题目的数量：");
		Scanner n=new Scanner(System.in);
		int x=n.nextInt();
		int i[]=new int[x];
		int j[]=new int[x];
		int k[]=new int[x];
		int l=0;
		for(int m=0;m<x;m++) {
			int a=(int)(0+Math.random()*10);
			int b=(int)(0+Math.random()*10);
			int c=(int)(0+Math.random()*3);
			i[m]=a;
			j[m]=b;
			k[m]=c;
			l++;
			if(c==0) {
				System.out.println(" ("+l+") " + a + " + " + b + " = ");
			}else if(a<b){
				System.out.println(" ("+l+") " + b + " - " + a+" = ");
			}else {
				System.out.println(" ("+l+") " + a + " - " + b + " = ");
			}
		}
		System.out.println("---------------标准答案---------------");		
		int y=0;
		for(int z=0;z<x;z++) {
			y++;
			if(k[z]==0) {
				System.out.println(" ("+y+") " + i[z] + " + " + j[z] + " = " + (i[z]+j[z]));
			}else if(i[z]<j[z]){
				System.out.println(" ("+y+") "+j[z]+" - "+i[z]+" = "+(j[z]-i[z]));
			}else {
				System.out.println(" ("+y+") "+i[z]+ " - "+j[z]+" = "+(i[z]-j[z]));
			}
	}
	}

	public static void two() {
		System.out.println("题目的数量：");
		Scanner n=new Scanner(System.in);
		int x=n.nextInt();
		int f[]=new int[x];
		int v[]=new int[x];
		int s[]=new int[x];
		int l=0;
		for(int m=0;m<x;m++) {
			int a=(int)(0+Math.random()*10);
			int b=(int)(0+Math.random()*10);
			int c=(int)(0+Math.random()*4);
			f[m]=a;
			v[m]=b;
			s[m]=c;
			l++;
			if(c==0) {
				System.out.println(" ("+l+") " + a + " + " + b + " = ");
			}
			if(c==1 && b>a){
				System.out.println(" ("+l+") " + b + " - " + a+" = ");
			}
			if(c==1 && a>b) {
				System.out.println(" ("+l+") " + a + " - " + b + " = ");
			}
			if(c==2 || b==0) {
				System.out.println(" ("+l+") " + a + " * " + b + " = ");
			}
			if(c==3 && b!=0) {
				System.out.println(" ("+l+") " + a + " / " + b + " = ");
			}
		}
		System.out.println("---------------标准答案---------------");		
	int t=0;
	for(int h=0;h<x;h++) {
		t++;
		if(s[h]==0) {
			System.out.println(" ("+t+") " + f[h] + " + " + v[h] + " = "+(f[h]+v[h]));
		}
		if(s[h]==1 && f[h]>v[h]){
			System.out.println(" ("+t+") " + f[h] + " - " + v[h]+" = "+(f[h]-v[h]));
		}
		if(s[h]==1 && f[h]<v[h]) {
			System.out.println(" ("+t+") " + v[h] + " - " + f[h]+" = "+(v[h]-f[h]));
		}
		if(s[h]==2 ||v[h]==0) {
			System.out.println(" ("+t+") " + f[h] + " * " + v[h]+" = "+(f[h]*v[h]));
		}
		if(s[h]==3 && v[h]!=0) {
			System.out.println(" ("+t+") " + f[h] + " / " + v[h]+" = "+(f[h]/v[h]));
		}
}
}
	
	
}