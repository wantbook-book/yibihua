import java.io.*;
import java.util.Scanner;

public class In {
    private Scanner scanner;

    public In(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream(fileName));
    }
    //读取一行
    public String readLine(){
        return scanner.nextLine();
    }
    //读取一个整数
    public int readInt(){return scanner.nextInt();}
    //读书一个字符串
    public String readString(){return scanner.next();}
    //判断是否还有未读取的输入
    public boolean isEmpty(){
        return !scanner.hasNext();
    }
    //关闭输入流
    public void close(){
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        In in = new In("D:/testFile/IDEAjava/yibihua/src/test.txt");
        String aLine = in.readLine();
        System.out.println(aLine);
        int aNumber1 = in.readInt();
        int aNumber2 = in.readInt();
        System.out.println(aNumber1+" and "+aNumber2);
        String aString = in.readString();
        System.out.println(aString);
    }
}
