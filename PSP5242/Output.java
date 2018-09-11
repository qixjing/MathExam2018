import java.io.PrintWriter;

public class Output {
	public  Output(int n) {
		try(PrintWriter p = new PrintWriter("out.text")) {
			for (int i = 0; i <=(2*n-2); i=i+2) 
				p.println(MathExam5242.answer.get(i));
				p.println("--------------- ±ê×¼´ð°¸---------------");
			
			for (int i = 0; i <=(2*n-2); i=i+2) {
				p.print(MathExam5242.answer.get(i));
				p.println(MathExam5242.answer.get(i+1));
			}
			p.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		}

