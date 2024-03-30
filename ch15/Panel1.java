package ch15;

import javax.swing.*;
import java.awt.*;

public class Panel1 {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);  //패널 구분 되게 색 넣음

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  //BoxLayout 은 버튼을 세로 방향(Y_AXIS)으로 배치한다.

        JButton button = new JButton("shock me");
        JButton buttonTwo = new JButton("bliss");
        
        //패널에  버튼 2개 넣기
        panel.add(button);
        panel.add(buttonTwo);

        //동쪽(우측)에 패널  배치
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250,200);
        frame.setVisible(true);
    }
}
