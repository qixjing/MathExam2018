
	 import java.io.File;
	 import java.io.FileOutputStream;
	 import java.io.IOException;
	 import java.io.OutputStream;
	 import java.util.regex.Pattern;

	 public class MathExam6373 {
	 	private static int leng;

	 	public static void main(String[] args) {
	 		
	 		
	 		if(0 == args.length) {
	 			System.out.println("请输入要生成的题数的数字。");
	 			return ;
	 		}else if(args.length > 1){
	 			System.out.println("只输入一个数字参数");
	 			return ;
	 		}else {
	 			Pattern pattern = Pattern.compile("[0-9]*");
	 		    boolean matches = pattern.matcher(args[0]).matches(); 
	 		    if(matches && args[0].length() > 4) {
	 				System.out.println("参数数字过大，请重新运行");
	 				return ;
	 		    }else if(matches) {
	 		    	leng = Integer.parseInt(args[0]);
	 		    }else {
	 				System.out.println("输入的参数不是正整数，请重新运行");
	 				return ;
	 		    }
	 		}
	 		
	 		
	 		StringBuffer top = new StringBuffer();
	 		StringBuffer answer = new StringBuffer();
	 		for(int i = 1; i <= leng; i++) {
	 			int n1 = (int) (Math.random()*101);
	 			int n2 = (int) (Math.random()*101);
	 			if(n1 < n2) {
	 				int t = n1;
	 				n1 = n2;
	 				n2 = t;
	 			}
	 			String sym = (0 == ((int) (Math.random()*10))%2)? " + " : " - ";	
	 			int res = (sym.equals(" + ")) ? n1 + n2 :n1 - n2;
	 			top.append("(" + i + ") " + n1 + sym + n2 + System.lineSeparator());
	 			answer.append("(" + i + ") " + n1 + sym + n2 + " = " + res + System.lineSeparator());
	 		}
	 		
	 		try {
	 			write("out.txt",top,answer);
	 			System.out.println("数学题题目已生成，请查看文件");
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
	 	}
	 	
	 	private static void write(String filengame,StringBuffer top,StringBuffer answer) throws IOException {
	 	    
	 		
	 		  File file = new File(filengame);
	 		  File parentFile = file.getParentFile();
	 		  if(parentFile!=null&&!parentFile.exists()) {
	 			  parentFile.mkdirs();
	 			  System.out.println("创建目录：" + parentFile);
	 		  }
	 		  file.createNewFile();
	 		  OutputStream out = new FileOutputStream(file);
	 		  out.write(top.toString().getBytes());
	 		  out.write(System.lineSeparator().getBytes());
	 		  out.write(answer.toString().getBytes());
	 		  out.close();
	 	  }
	 
	 		
	 }


