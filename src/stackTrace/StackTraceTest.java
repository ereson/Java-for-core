package stackTrace;

import java.util.Scanner;

/**
 * 这个类展示了打印堆栈轨迹以及try-with-resource的用法
 */
public class StackTraceTest {
    /**
     * 展示了阶乘的堆栈轨迹
     * @param n
     * @return
     */
    public static int factorial(int n){
        System.out.println("factorial(" + n + "):");
        var walker = StackWalker.getInstance();
        walker.forEach(System.out::println);
        int r;
        if( n <= 1) r = 1;
        else r = n * factorial(n -1);
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args){
        //try-with-resources的用法
        //输入一次后就结束
        try(var in = new Scanner(System.in)){
            System.out.print("Enter n :" );
            int  n = in.nextInt();
            factorial(n);
        }
    }
}
