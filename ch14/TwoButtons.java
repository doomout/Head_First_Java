package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//버튼 두 개를 처리하는 예제(내부 클래스 이용)
public class TwoButtons {
    private JFrame frame;
    private JLabel label;
  
    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }
  
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JButton labelButton = new JButton("Change Label");
        //내부 클래스 사용 버전
        //labelButton.addActionListener(new LabelListener());
        //람다 사용 버전
        labelButton.addActionListener(event->label.setText("어우야~!"));
    
        JButton colorButton = new JButton("Change Circle");
        //내부 클래스 사용 버전
        //colorButton.addActionListener(new ColorListener());
        //람다 사용 버전
        colorButton.addActionListener(event->frame.repaint());
    
        label = new JLabel("I’m a label");
        MyDrawPanel drawPanel = new MyDrawPanel();
    
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
    
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
    /** 내부 클래스를 람다 형식으로 변경
    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("어우야~!");
        }
    }
    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }
    */
}
