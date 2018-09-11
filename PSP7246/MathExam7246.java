import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MathExam7246 {
    
    final static int GRADE1_MAX = 20;
    final static int GRADE2_MAX = 90;
    final static String FILENAME = "out.txt";
    /**
     * 两个运算数
     */
    static int number1, number2;
    /**
     * 0,1分别对应加、减或者乘、除
     */
    static int fuhao;
    static int num;
    static int grade;
    /**
     * 存放待写入txt文件的题目和答案
     */
    static String[] strArrayQ, strArrayA;
    
    public static void main(String[] args) throws IOException {
        // 处理参数输入问题
        if (args.length == 1 || args.length == 2) {
            timuNum(args);
            classChose(args);
        } else {
            System.out.println("参数个数有误！请重新运行！");
            System.exit(0);
        }
        if (grade == 1) {
            grade1();
        } else if (grade == 2) {
            grade2();
        }
        writeToTxt();
    }

    /**
     * 年级选择参数处理
     * @param args
     */
    private static void classChose(String[] args) {
        try {
            // 解决只输入一个参数的问题，默认为一年级
            if (args.length == 1) {
                grade = 1;
            } else if (args.length == 2) {
                grade = Integer.parseInt(args[1]);
            }
            if (grade == 1 || grade == 2) {
            } else {
                System.out.println("年级选择超出范围，请选择一年级或者二年级。");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("年级选择选项非整数！请重新运行！");
            System.exit(0);
        }
    }

    /**
     * 题目个数参数处理
     * @param args
     */
    private static void timuNum(String[] args) {
        try {
            num = Integer.parseInt(args[0]);
            if (num < 0) {
                System.out.println("题目数量为负！请重新运行！");
                System.exit(0);
            } else if (num == 0 || num > 100) {
                System.out.println("请输入合适的题目数量！比如1-100");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("题目数量选项非整数！请重新运行！");
            System.exit(0);
        }
        strArrayQ = new String[num];
        strArrayA = new String[num];
    }
    
    /**
     * 一年级的加减题目生成
     * fuhao = 0 为加法：20以内的加法
     * fuhao = 1 为减法：不能产生负数
     */
    private static void grade1() {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            number1 = (int)(Math.random()*(GRADE1_MAX+1));
            fuhao = (int)(Math.random()*2);
            if (fuhao == 0) {
                number2 = (int)(Math.random()*(GRADE1_MAX+1));
                result = number1 + number2;
                // 记录题目和答案
                strArrayQ[i-1] = "(" + i + ") " + number1 + " + " + number2 + " =";
                strArrayA[i-1] = "(" + i + ") " + number1 + " + " + number2 + " = " + result;
            } else if (fuhao ==1) {
                do {
                    number2 = (int)(Math.random()*(GRADE1_MAX+1));
                } while (number2 > number1);
                result = number1 - number2;
                // 记录题目和答案
                strArrayQ[i-1] = "(" + i + ") " + number1 + " - " + number2 + " =";
                strArrayA[i-1] = "(" + i + ") " + number1 + " - " + number2 + " = " + result;
            }
        }
    }
    
    /**
     * 二年级的乘除题目生成
     * fuhao = 0 为乘法：乘法表内乘法
     * fuhao = 1 为除法：商和余数需为一位数且除数不为0
     */
    private static void grade2() {
        // 运算结果result，余数yu
        int result = 0;
        int yu = 0;
        for (int i = 1; i <= num; i++) {
            fuhao = (int)(Math.random()*2);
            if (fuhao == 0) {
                number1 = (int)(Math.random()*10);
                number2 = (int)(Math.random()*10);
                result = number1 * number2;
                // 记录题目和答案
                strArrayQ[i-1] = "(" + i + ") " + number1 + " * " + number2 + " =";
                strArrayA[i-1] = "(" + i + ") " + number1 + " * " + number2 + " = " + result;
            } else if (fuhao == 1) {
                number1 = (int)(Math.random()*GRADE2_MAX);
                do {
                    number2 = (int)(Math.random()*10);
                } while (number2 <= (number1 / 10) || number2 == 0);
                result = number1 / number2;
                yu = number1 % number2;
                // 记录题目和答案
                strArrayQ[i-1] = "(" + i + ") " + number1 + " / " + number2 + " =";
                if (yu == 0) {
                    strArrayA[i-1] = "(" + i + ") " + number1 + " / " + number2 + " = " + result;
                } else {
                    strArrayA[i-1] = "(" + i + ") " + number1 + " / " + number2 + " = " + result + "..." + yu;
                }
            }
        }
    }
    
    /**
     * 创建out.txt文件并写入内容
     * @throws IOException
     */
    private static void writeToTxt() throws IOException {
        File file = new File(FILENAME);
        file.createNewFile();
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            // 具体写入内容
            for (int i = 0; i < num; i++) {
                System.out.println(strArrayQ[i]);
                fw.write(strArrayQ[i]);
                fw.write("\r\n");
            }
            fw.write("--------------标准答案--------------");
            System.out.println("--------------标准答案--------------");
            fw.write("\r\n");
            for (int i = 0; i < num; i++) {
                System.out.println(strArrayA[i]);
                fw.write(strArrayA[i]);
                fw.write("\r\n");
            }
            fw.write("     " + txtFoot());
            System.out.println("     " + txtFoot());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // 脚部信息生成
    private static String txtFoot() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String timeStr = df.format(new Date());
        return "211617246 张竣淇 " + timeStr;
    }
}
