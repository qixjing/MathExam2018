package com.java362;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class math {
	public static void main(String[] args) throws IOException {
		int answer;
		File file = new File("out.txt");
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Сѧһ�꼶��ѧ�Ӽ�������");
		System.out.println("��������Ŀ������");
		int n = input.nextInt();
		for (int i = 1; i <= n; i++) {
			//�������������
			int a = (int)(Math.random()*20+1);
			int b = (int)(Math.random()*20+1);
			//�����������Ŀ
			if(a>b) {
				System.out.println("("+ i +") " + a +" - "+ b + " =");
				String str = ("("+ i +") " + a +" - "+ b + " = " + (a-b));
				out.writeUTF(str);
			}//���ɼ���	
			else {
				System.out.println("("+ i +") " + a +" + "+ b+ " =");
				String str = ("("+ i +") " + a +" + "+ b + " = " + (a+b));
				out.writeUTF(str);
			}
		}//���ɼӷ�
		out.close();
		
		System.out.println("------------------��׼��------------------");
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		for (int i = 0; i < n; i++) {
			System.out.println(in.readUTF());
		}
		in.close();
		
	}//main
}
