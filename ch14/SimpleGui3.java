package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//버튼 클릭시 원의 색이 바뀜
public class SimpleGui3 implements ActionListener{
    private JFrame frame;

    public static void main(String[] args) {
        SimpleGui3 gui = new SimpleGui3();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change colors"); //버튼 생성 + 버튼 글씨
        button.addActionListener(this); //리스너에 버튼 추가

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button); //버튼을 남쪽(하단)에 추가
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel); //drawPanel 을 중앙에 추가
        frame.setSize(300, 300); //창 크기
        frame.setVisible(true); //창 보이도록 설정
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint(); //사용자가 클릭하면 다시 그리기
    }
}
