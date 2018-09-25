package com.java391;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class MathExam {
    public static ArrayList<String> ss = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
    	String QT[] = new String[1000];				//定义全局变量
    	String AS[] = new String[1000];
            System.out.println("输入年级");
            int []Grade=new int[args.length];
            System.out.println("输入运行次数");
            int []count=new int [args.length];
            count[0]=Integer.parseInt(args[0]);
            System.out.println();
   		    Grade[0]=Integer.parseInt(args[1]);
            File file =new File("out.txt");
            FileOutputStream fops=null ;
            
            try {
                fops = new FileOutputStream(file);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            PrintStream ps= new PrintStream(fops);
            ps.println("211606391");
            boolean f = true;
            if(Grade[0]==3 ){
            for (int i=0;i<count[0];i++) {
                String data = Data();
                String input = data;
                ss.add(input);
                if (input.equals("q"))
                    break;
                else {
                    Expression express = new Expression(input);
                    f = express.getResult();
                    if(!f) i--;
                    else ps.println(data + "=" + express.getExpresult());
                }
            }
           
    }
            else if(Grade[0]==1)
            {
            	 jiajian(count);
                     
                 }
            
            else if(Grade[0]==2)
            {
            	chengchu(count);
                }
            }
    

    private static void chengchu(int count[]) throws IOException {
                 for(int i=1;i<=count[0];) {
			
			int a=(int)(Math.random()*100);
			int b=(int)(Math.random()*100);
			int symbol=(int)(Math.random()*4);
		
			String[] QT = null;
			String[] AS = null;
			if(symbol==0) {
				QT[i-1]="("+ i +") " + a + " + " + b;
				AS[i-1]="("+ i +") " + a + " + " + b +" = " + (a+b) ;
			}
			else if(symbol==1) {
				if(a<b)
					{continue;}
				QT[i-1]="("+ i +") " + a + " - " + b;	
				AS[i-1]="("+ i +") " + a + " - " + b +" = " +(a-b) ;
			}
			else if(symbol==2) {
				QT[i-1]="("+ i +") " + a%10 + " × " + b%10;
				AS[i-1]="("+ i +") " + a%10 + " × " + b%10 +" = " +((a%10)*(b%10)) ;
			}
			else if(symbol==3) {
				if(b%10==0) 
					{continue;}
				
				QT[i-1]="("+ i +") " + a%10 + " ÷ " + b%10;
				
				if(((a%10)%(b%10))==0) {
					
					AS[i-1]="("+ i +") " + a%10 + " ÷ " + b%10 +" = " +((a%10)/(b%10)) ;
				}
			
				else if(((a%10)%(b%10))!=0) {
					AS[i-1]="("+ i +") " + a%10 + " ÷ " + b%10 +" = " +((a%10)/(b%10)) +" ··· " + ((a%10)%(b%10));}
				}
				i++;}
			
		
		
		}	


	

	private static void jiajian(int count[]) throws IOException {
		File file =new File("out.txt");
		 FileWriter fw = new FileWriter(file);
		 BufferedWriter bw = new BufferedWriter(fw);
		int [] as = new int[count[0]+5];
		int [] bs = new int[count[0]+5];
		char [] cs = new char[count[0]+5];
		int [] ds = new int[count[0]+5];
		
		for(int i =1;i<=count[0];i++) {				//n循环，有n道题
			int a=(int)(Math.random()*100+1);   //随机生成100以内的数字
			as[i] = a;							//把a存入数组
			//bw.write(String.valueOf(a));		//向文本输入a值  

						
	        int c=(int)(Math.random()*100+1);	//判断符号并且存入
	        {
	        	if(c%2==1) {
	        		//bw.write(String.valueOf("-"));
	        		cs[i] = '-';
	        	}
	        	else  {
	        		//bw.write(String.valueOf("+"));
	        		cs[i] = '+';
	        		}
	        }
	        
	        
	        int b=(int)(Math.random()*100+1);	//b值
	        //bw.write(String.valueOf(b));
	        bs[i] = b;
	        
	        if(c%2==1 && a<b) {
	        	int answer = a+b;
	        	cs[i]='+';
	        	ds[i]=answer;
	        }
	        
	        else if(c%2==1 ) {
	        	int answer = a-b;
	        	ds[i] = answer;
	        	//System.out.print("("+i+")"+a+"-"+b+"="+answer+"\n");
	        	//bw.write(String.valueOf("="+answer));
	        	//bw.newLine();
	        }
	        else {
	        	int answer =a+b;
	        	ds[i] = answer;
	        //	System.out.print("("+i+")"+a+"+"+b+"="+answer+"\n");
	        //	bw.write(String.valueOf("="+answer));
	        //	bw.newLine();
	        }
		}

		
				
		for(int i=1;i<=count[0];i++) {
			System.out.print(as[i]);
			bw.write(String.valueOf(as[i]));	
			System.out.print(cs[i]);
			bw.write(String.valueOf(cs[i]));	
			System.out.println(bs[i]);
			bw.write(String.valueOf(bs[i]));
			bw.newLine();
		
	System.out.println("-------------标准答案--------------");
		bw.write(String.valueOf("-------------标准答案--------------"));
		bw.newLine();
		
		
		for( i=1;i<=count[0];i++) {
			System.out.print(as[i]);
			bw.write(String.valueOf(as[i]));
			System.out.print(cs[i]);
			bw.write(String.valueOf(cs[i]));
			System.out.print(bs[i]);
			bw.write(String.valueOf(bs[i]));
			System.out.println("="+ds[i]);
			bw.write(String.valueOf("="+ds[i]));
			bw.newLine();
		
		bw.close();
		fw.close();
		}
		}
	}
	

	//随机产生算式
    public static String Data()
    {
        Random rand =new Random();
        ArrayList<Integer> numlist = new ArrayList<Integer>();
        ArrayList<String> express = new ArrayList<String>();
      //产生随机数
        for(int i=0;i<5;i++)
        {
            numlist.add(rand.nextInt(100)+1);
        }
        //System.out.print(numlist);
        String[] operator=new String[]{"+","-","*","/"};
        int size=numlist.size();
        String[] num=new String[size];
        for(int i=0;i<numlist.size();i++){
            num[i]=String.valueOf(numlist.get(i));
        }
        String exp="";
        for(int j=0;j<num.length;j++)
        {
            express.add(num[j]);
            express.add(operator[rand.nextInt(4)]);
        }
        //System.out.print(express);

        for(int i=0;i<express.size()-1;i++)
            exp+=express.get(i);
        return exp;
    }

}
