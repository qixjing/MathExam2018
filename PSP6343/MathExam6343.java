import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//import java.io.OutputStream;
public class MathExam6343 {
	public static void main(String[] args) {
		//for(;;) {
		File file = new File("out6343.txt");		//������ļ�
		int []n =new int [args.length] ;	//���������������
		Scanner sc = new Scanner(System.in);			

		boolean flag = true;
		boolean flag1 = true;
		boolean flag2 = true;
		n[0] = Integer.parseInt(args[0]); 
	    n[1] = Integer.parseInt(args[1]);		
		for(;;) {
	//�Ե�һ�������������
		while (flag) {
			if(n[0]>0 && n[0]<9999)
				flag = false;
			else {
				System.out.println("��������Ҫ�������");				
				n[0] = sc.nextInt();
				if(n[0]>0 && n[0]<9999)
					break;
				
			}
		}
		
	//�Եڶ��������������
	    while(flag1) {
	    	if(n[1]==1 || n[1]==2)
	    		flag1 = false;
	    	else {
	    		System.out.println("����������ȷ�꼶��");
	    		n[1] = sc.nextInt();
	    		if(n[1]==1 || n[1] == 2)
	    			break;
	    	}
	    }
	   
		if(!file.exists())						//�ж�TXT�Ƿ����
		{
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("out6343.txt�������");
		}
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	        int b=(int)(Math.random()*100+1);	//bֵ
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
			try {
				bw.write(String.valueOf("("+i+")"));
				bw.write(String.valueOf(as[i]));	
			//System.out.print(cs[i]);
			bw.write(String.valueOf(cs[i]));	
			//System.out.println(bs[i]);
			bw.write(String.valueOf(bs[i]));
			bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.print(as[i]);
			
		}
		//System.out.println("-------------��׼��--------------");
		
		try {
			bw.write(String.valueOf("-------------��׼��--------------"));
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		for(int i=1;i<=n[0];i++) {
			//System.out.print("("+i+")");
			try {
				bw.write(String.valueOf("("+i+")"));
				//System.out.print(as[i]);
			bw.write(String.valueOf(as[i]));
			//System.out.print(cs[i]);
			bw.write(String.valueOf(cs[i]));
			//System.out.print(bs[i]);
			bw.write(String.valueOf(bs[i]));
			//System.out.print("="+ds[i]);
			bw.write(String.valueOf("="+ds[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(es[i] != 0) {
				//System.out.println("...."+es[i]);
				try {
					bw.write(String.valueOf("...."+es[i]));
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				continue;
			}
			else {
				//System.out.print("\n");
			}
		
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			bw.close();	fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("��ѡ���˳�(0)���߼���(1)��");
		int g = sc.nextInt();
		if(g==1) {
			System.out.println("������Ŀ�����꼶��");
			n[0]=sc.nextInt();
			n[1]=sc.nextInt();
				continue;
			}
		else if(g==0){
				System.out.println("ллʹ�ã�");		
				break;		
			}
		else {
			System.out.println("��������0��1");
			g=sc.nextInt();
			while(flag2) {
				if(g==1 || g==0) {
					flag2= false;
				}
				else {
					System.out.println("��������0��1");
					g=sc.nextInt();
					if(g==1 || g==0)
						break;
				}
			}
			System.out.println("������Ŀ�����꼶��");
			n[0] = sc.nextInt();
			n[1] = sc.nextInt();
		}

		}
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
	    String time = sdf.format(new Date());
	    System.out.println("211606343 ������" + time);
		}
	}