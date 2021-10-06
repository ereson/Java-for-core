package timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;


/**
 * I just want to learn java and this part is for callback to make an example.
 * This class is for show the use of the timer and the monitor.
 */
 public class TimerTest {
    public static void main(String[] args){
        //'timer.TimerTest.this' cannot be referenced from a static context 无法从静态上下文中引用非静态 变量 this
        var listener = new TimePrinter();
        //construct a timer , the interval is '1000' ,
        var timer = new Timer(1000,listener);
        timer.start();

        //show a dialog which include a message and a bottom named 'Ok',if 'parentComponent' is null ,the dialog will show in the center of screen.
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

     static class  TimePrinter implements ActionListener {
         /**
          * this method is to show some information every second
          * @param ActionEvent include  some information about event , e.g. the time when this event happen
          */
        @Override
        public void actionPerformed(ActionEvent event){
            //Instant.ofEpochMilli make the millisecond to a readable time
            System.out.println("At the tone, the time is" + Instant.ofEpochMilli(event.getWhen()));
            //getDefaultToolkit is a static method of Toolkit , it will return a default toolkit ;
            //beep can make a bell ring
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
