import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;


public class MathExam6372{

    static StringBuffer questions = new StringBuffer();
    static StringBuffer answers = new StringBuffer();

    public static void generateExam(int number , int grade){

        int[] number1 = new int[number];
        int[] number2 = new int[number];
        int[] answer= new int[number];
        String[] so = new String[number] ;
        Random random = new Random();
        String[] ch = {"+","-", "*", "/"};


        for (int i=0;i<number;i++){
            number1[i] = random.nextInt(100);
            number2[i] = random.nextInt(100);int subScript = 0;
            if(grade==1) {
            	subScript=random.nextInt(2);
            }else if (grade==2) {
            	subScript=random.nextInt(4);
			}

            String symbol = ch[subScript];
            so[i] = symbol;
            switch (symbol){
            case "/":
                while (number2[i] == 0) {
                    number2[i] = (int) (Math.random() * 100);
                }
                answer[i] = number1[i] / number2[i];
               break;
                
                case "*":
                    answer[i]=number1[i]*number2[i];
                    break;
                case "-":
                    if(number1[i]<number2[i]){
                        int temp = number1[i];
                        number1[i]=number2[i];
                        number2[i]=temp;
                    }
                    answer[i]=number1[i]-number2[i];
                    break;
                case "+":
                    answer[i]=number1[i]+number2[i];
                    break;
                default:
            }
            questions.append("("+(i+1)+")"+" "+number1[i]+" "+symbol+" "+number2[i]+ "\r\n");
            System.out.println("("+(i+1)+")"+" "+number1[i]+" "+symbol+" "+number2[i]);
        
        	
        }
        questions.append("========输出答案========");
   
       System.out.println("========输出答案========");
  
      for (int i=0;i<number;i++) {
            if (number2[i] != 0 ) {
                answers.append("(" + (i + 1) + ")" + " " + number1[i] + " " + so[i] + " " + number2[i] + " = " + answer[i] + "\r\n");
                System.out.println("(" + (i + 1) + ")" + " " + number1[i] + " " + so[i] + " " + number2[i] + " = " + answer[i]);
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
        if(grade<0 ||grade>2) {
        	System.out.println("请输入1-2在年级");
        }
        generateExam(number,grade);
        write();
     
    }
}
