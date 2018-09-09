package com.java1233.MathExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MathExam233 {
	static String s = "";
	static String s1 = "";
	static String s2 = "";

	public static void Math(int num) {
		int r = 0;
		String p;
		int c;
		int d;
		String[] m = new String[num];
		String[] n = new String[num];
		int j = 0, l = 0;
		for (int i = 0; i < num; i++) {
			String a = "(" + (i + 1) + ")" + " ";

			do {
				int b = (int) (Math.random() * 10);
				c = (int) (Math.random() * 100);
				d = (int) (Math.random() * 100);
				if (b % 2 == 0) {
					p = "+";
					r = c + d;
				} else {
					p = "-";
					r = c - d;
				}
			} while (r < 0 || r > 100);
			System.out.println(a + c + p + d + "=");
			m[j++] = a + c + p + d + "=" + r;
			n[l++] = a + c + p + d + "=";
		}
		System.out.println("----------------标准答案----------------");
		for (int o = 0; o < j; o++) {
			System.out.println(m[o]);
		}
		for (int i = 0; i < m.length; i++) {
			s = s + "\n" + m[i];
		}
		for (int i = 0; i < n.length; i++) {
			s1 = s1 + "\n" + n[i];
		}
	}

	private static void createtxt() {
		try {
			FileOutputStream fos = new FileOutputStream("out.txt");
			PrintStream ps = new PrintStream(fos);
			ps.println(s1);
			ps.println(s);
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		boolean isNum = args[0].matches("\\d*");
		if ((isNum == true && args.length == 1) || (isNum == true && args.length == 2 && args[1].matches("[1]"))) {
			int num = Integer.valueOf(args[0]);
			Math(num);
			createtxt();
	} else {
			System.out.println("输入错误，请重新输入");
		}
	}
}