package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MathExam6359 {

	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("请输出所需要的题目数量：");
		try{
			
			int count = s.nextInt();
			System.out.println("请输入年级：");
			int grade = s.nextInt();
			File file = new File("D:\\java\\out.txt");
			if(!makeTxt(file)){
				throw new RuntimeException("文件创建失败");
			}
			String[][] titleArr = buildQuestion(count, grade);
			boolean isSuccess = printQuestion(file, titleArr);
			if(isSuccess){
				System.out.println("文件及其算术创建成功！");
			}else{
				System.out.println("文件及其算术创建失败！");
			}
		}catch(InputMismatchException e){
			System.out.println("文件及其算术创建失败!");
			System.out.println("输入的题目数量和年级必须为正整数!");
		}catch(Exception e){
			System.out.println("文件及其算术创建失败!");
		}
	}
	

	

	private static String[][] buildQuestion(int count, int grade){
		
		if(count < 0){
			count = 1;
		}
		
		if(grade < 1){
			grade = 1;
		}
		
		int limited = grade * 20;
	
		Random random = new Random();
		String[][] titleArr = new String[count][4];
		for (String[] arr : titleArr) {
		
			int first = random.nextInt(limited);
			
			int second = random.nextInt(4);
		
			int third = random.nextInt(limited);
			switch(second){
			case 0:
				
				arr[1] = " + ";
				arr[3] = String.valueOf(first + third);
				break;
				
			case 1:
			
				arr[1] = " - ";
				arr[3] = String.valueOf(first - third);
				break;
				
			case 2:
			
				arr[1] = " × ";
				arr[3] = String.valueOf(first * third);
				break;
				
			case 3:
			
				arr[1] = " ÷ ";
			
				while(third == 0){
					third = random.nextInt(limited);
				}
			
				int remainder = (first%third);
				if(remainder == 0){
					arr[3] = String.valueOf(first/third);
				}else{
					arr[3] = String.valueOf(first/third) + "..." + String.valueOf(remainder);
				}
				break;
			}
		
			arr[0] = String.valueOf(first);
			arr[2] = String.valueOf(third);
		}
		return titleArr;
		
	}
	
	private static boolean printQuestion(File file, String[][] titleArr){
		StringBuilder buff = new StringBuilder();
		StringBuilder answerbuff = new StringBuilder();
		String newLine = "\r\n";
		String divideStr = "------------------标准答案------------------\r\n";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日\tHH:mm");
		String anthorInfo = "\t\t211606359 \t\t戴俊涵\t\t" + sdf.format(new Date());
		
		for(int i =1; i<=titleArr.length; i++){
			String[] arr = titleArr[i-1];
			String str = "("+ i + ") " + arr[0] + arr[1] + arr[2] + " =";
			buff.append(str + newLine);
			answerbuff.append(str + " " + arr[3] + newLine);
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(buff.toString().getBytes());
			fos.write(divideStr.getBytes());
			fos.write(answerbuff.toString().getBytes());
			fos.write(anthorInfo.getBytes());
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件未找到异常", e);
		}  catch (IOException e) {
			throw new RuntimeException("输入或输出流发生异常", e);
		}
		finally{
			try {
				fos.close();
			} catch (IOException e) {
				throw new RuntimeException("输出流关闭发生异常", e);
			}
		}
		return true;
	}
	
	private static boolean makeTxt(File file){

		if(!file.exists()){
			file.getParentFile().mkdirs();
		}
		
	
		if(! file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException("文件创建失败", e);
			}
		}

		
		FileWriter fileWrite = null;
		try {
			fileWrite = new FileWriter(file);
			fileWrite.write("");
			fileWrite.flush();
		} catch (IOException e) {
			throw new RuntimeException("文件清空发生异常", e);
		}finally{
			try {
				fileWrite.close();
			} catch (IOException e) {
				throw new RuntimeException("文件写入流关闭发生异常", e);
			}
		}
		
		return file.exists();
	}
}
