package innerClass;



import timer.TimerTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class innerClassTest {
    public static void main(String[] args){
        var clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    static class TalkingClock{
        private int interval;
        private boolean beep;

        public TalkingClock(int interval, boolean beep){
            this.interval = interval;
            this.beep = beep;
        }

        public void start(){
            var listener = new TimePrinter();
            var time = new Timer(interval,listener);
            time.start();
        }

        /**
         * 匿名内部类
         */

        public void start1(){
            //没有声明类名
            var listener = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
                    if(beep) Toolkit.getDefaultToolkit().beep();
                }
            };
            var time = new Timer(interval,listener);
            time.start();
        }

        public class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event){
                System.out.println("At the tone, the time is" + Instant.ofEpochMilli(event.getWhen()));
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
