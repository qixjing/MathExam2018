package com.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;


public class MathExam6340 {

    static StringBuffer questions = new StringBuffer();
    static StringBuffer answers = new StringBuffer();

    public static void generateExam(int number , int grade){
        int[] num1 = new int[number];
        int[] num2 = new int[number];
        int[] sum = new int[number];
        String[] so = new String[number] ;
        Random random = new Random();
        String[] ch = {"+", "-", "*", "/"};

        int remainder = 0;
        for (int i=0;i<number;i++){
            num1[i] = random.nextInt(100);
            num2[i] = random.nextInt(100);
            int subScript = (1 == grade) ?  (random.nextInt(2)) : (random.nextInt(4));
            String symbol = ch[subScript];
            so[i] = symbol;
            switch (symbol){
                case "+":
                    sum[i]=num1[i]+num2[i];
                    break;
                case "-":
                    if(num1[i]<num2[i]){
                        int temp = num1[i];
                        num1[i]=num2[i];
                        num2[i]=temp;
                    }
                    sum[i]=num1[i]-num2[i];
                    break;
                case "*":
                    sum[i]=num1[i]*num2[i];
                    break;
                case "/":
                    while (num2[i] == 0) {
                        num2[i] = (int) (Math.random() * 100);
                    }
                    sum[i] = num1[i] / num2[i];
                    if (num1[i] % num2[i] == 0) {
                        break;
                    } else {
                        if (num1[i] < num2[i]) {
                            remainder = num1[i];
                        } else if (num1[i] >  num2[i]) {
                            remainder = num1[i] %  num2[i];
                        }
                    }
                    break;
                default:
            }
            questions.append("("+(i+1)+")"+" "+num1[i]+" "+symbol+" "+num2[i]+ "\r\n");
            System.out.println("("+(i+1)+")"+" "+num1[i]+" "+symbol+" "+num2[i]);

        }
        questions.append("========输出所有答案========");
        System.out.println("========输出所有答案========");
        for (int i=0;i<number;i++) {
            if (num2[i] != 0 && remainder == 0) {
                answers.append("(" + (i + 1) + ")" + " " + num1[i] + " " + so[i] + " " + num2[i] + " = " + sum[i] + "\r\n");
                System.out.println("(" + (i + 1) + ")" + " " + num1[i] + " " + so[i] + " " + num2[i] + " = " + sum[i]);
            } else {
                answers.append("(" + (i + 1) + ")" + " " + num1[i] + " " + so[i] + " " + num2[i] + " = " + sum[i]
                        + "......" + remainder + "\r\n");
                System.out.println("(" + (i + 1) + ")" + " " + num1[i] + " " + so[i] + " " + num2[i] + " = " + sum[i]
                        + "......" + remainder);
            }
        }
    }

    public static void write() throws IOException {
        File file= new File("out.txt");
        if (!file.exists()) {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            file.createNewFile();
        }
        OutputStream out = new FileOutputStream(file);
        byte[] question=questions.toString().getBytes();
        byte[] answer=answers.toString().getBytes();
        out.write(question);
        out.write(System.lineSeparator().getBytes());
        out.write(answer);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("java MathExam ");
        int number = input.nextInt();
        int grade = input.nextInt();
        generateExam(number,grade);
        write();
        System.out.println("题目已经生成，详情请见out.txt");
    }
}
