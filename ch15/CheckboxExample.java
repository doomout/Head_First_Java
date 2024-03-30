package ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//체크 박스 예제
public class CheckboxExample {
    private JCheckBox check;

    public static void main(String[] args) {
        CheckboxExample gui = new CheckboxExample();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        check = new JCheckBox("Goes to 11");
        check.addItemListener(new MyItemListener()); //내부 클래스 사용
        panel.add(check);

        
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    // 외부 클래스로 이동한 ItemListener 구현
    class MyItemListener implements ItemListener {
        //이벤트 처리(선택 여부를 알아낸다)
        public void itemStateChanged(ItemEvent e) {
            String onOrOff = "off";
            //선택을 했나? 
            if (check.isSelected()) {
                onOrOff = "on";
            }
            System.out.println("Check box is " + onOrOff);
        }
    }
}
