package Java_Standard.ch7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerEx7 {
    public static void main(String[] args) {
        //
        Button b = new Button("Start");
        b.addActionListener(new EventHandler());

        //상위를 익명 클래스로 변환
        Button anonymousB = new Button("Start");
        anonymousB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!!!");
            }
        });
    }
}

class EventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionEvent occurred!!!");
    }
}
