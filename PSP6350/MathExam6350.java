
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class MathExam6350 {
 public static void main(String[] args) throws IOException  {
  // TODO Auto-generated method stub
  int a;
  int p=1;
  while(true) {
  Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(" ");
        if(stringArray.length>1) {
        try {
           a = Integer.parseInt(stringArray[0]);
           p = Integer.parseInt(stringArray[1]);
           } catch (NumberFormatException e) {
            System.out.println("输入错误，请重新输入");
            continue;
           }
        if(stringArray.length>2) {System.out.println("数据过长请重新输入");continue;}
        if(Integer.parseInt(stringArray[0])<0) {System.out.println("输入题目数量有误请重新输入");continue;}
        if(Integer.parseInt(stringArray[1])!=1 && Integer.parseInt(stringArray[1])!=2) {System.out.println("输入年级有误请重新输入");continue;}
        a = Integer.parseInt(stringArray[0]);
        p = Integer.parseInt(stringArray[1]);
        break;
  }
        else {
         try {
                a = Integer.parseInt(stringArray[0]);
                } catch (NumberFormatException e) {
                 System.out.println("输入错误，请重新输入");
                 continue;
                }
         if(Integer.parseInt(stringArray[0])<0) {System.out.println("输入题目数量有误请重新输入");continue;}
             a = Integer.parseInt(stringArray[0]);
             p=1;
             break;
       }
        }
        
  MathExam6350(a,p);
 
 }
 static void MathExam6350(int a,int e) throws IOException {
  List<String>  list  = new ArrayList<String>();
  PrintStream out = System.out;
  PrintStream ps = new PrintStream("e:/output.txt");
  if(e==1) {
  for(int i=1;i<=a;i++) {
   int b =(int)(Math.random()*100);
   int c =(int)(Math.random()*100);
   int d;
   int rd=Math.random()>0.5?1:0; 
   if(rd==1) {
    System.setOut(ps);
    System.out.println("("+i+")"+" "+b+" "+"+"+" "+c+" "+"=");
   d=b+c;list.add("("+i+")"+" "+b+" "+"+"+" "+c+" "+"="+" "+d);}
   if(rd==0) {
    while(b-c<0) {b=(int)(Math.random()*100);}
    System.setOut(ps);
    System.out.println("("+i+")"+" "+b+" "+"-"+" "+c+" "+"=");
    d=b-c;list.add("("+i+")"+" "+b+" "+"-"+" "+c+" "+"="+" "+d);}  
  }
  System.setOut(ps);
  System.out.println("-----------标准答案-----------");
  for (int i = 0; i < list.size(); i++) {
   System.setOut(ps);
   System.out.println( list.get(i));
 }  
}
  if(e==2) {
   for(int i=1;i<=a;i++) {
    int b =(int)(Math.random()*10);
    int c =(int)(Math.random()*10);
    int d;
    int f;
    int rd=Math.random()>0.5?1:0; 
    if(rd==1) {
     System.setOut(ps);
     System.out.println("("+i+")"+" "+b+" "+"×"+" "+c+" "+"=");
    d=b*c;list.add("("+i+")"+" "+b+" "+"×"+" "+c+" "+"="+" "+d);}
    if(rd==0) {
     while(c==0) {c=(int)(Math.random()*10);}
     System.setOut(ps);
     System.out.println("("+i+")"+" "+b+" "+"÷"+" "+c+" "+"=");
     if(b%c==0) {d=b/c;list.add("("+i+")"+" "+b+" "+"÷"+" "+c+" "+"="+" "+d);}
     if(b%c!=0) {d=b/c;f=b%c;list.add("("+i+")"+" "+b+" "+"÷"+" "+c+" "+"="+" "+d+"."+"."+"."+f);}}
   }
   System.setOut(ps);
   System.out.println("-----------标准答案-----------");
   for (int i = 0; i < list.size(); i++) {
    System.setOut(ps);
    System.out.println( list.get(i));
  }
 }
   SimpleDateFormat formater=new SimpleDateFormat("            211606350 曾磊鑫 yyyy年MM月dd日 HH:mm");
   String strCurrentTime=formater.format(new Date());
   System.setOut(ps);
   System.out.println(strCurrentTime);
   File file = new File("e:/output.txt");
   FileReader reader = new FileReader(file);
   int fileLen = (int)file.length();
   char[] chars = new char[fileLen];
   reader.read(chars);
   String txt = String.valueOf(chars);
   System.setOut(out);
   System.out.println(txt);
System.out.println("e:/output.txt已生成");
 }
}

