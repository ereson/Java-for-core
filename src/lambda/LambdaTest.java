package lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * (1)lambda表达式形式之一：参数，箭头，表达式（若代码要完成的计算无法放到一个表达式中，则可以使用{}
 * (2)没有参数时，仍然要提供空括号
 * (3)lambda表达式只在一个分支提供返回值，而在其他分支不返回值，这样是非法的。
 */
public class LambdaTest {
    public static void main(String[] args){
        var planets = new String[]{"Mercury", "Earth", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in length:");
        Arrays.sort(planets,(first, second)->first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000,event -> System.out.println("The time is" + new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
