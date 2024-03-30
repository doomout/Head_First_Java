package ch15;

import javax.swing.*;
import java.awt.*;

public class TextArea1 {
    public static void main(String[] args) {
        TextArea1 gui = new TextArea1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton button = new JButton("Just Click It");

        JTextArea text = new JTextArea(10, 20);
        text.setLineWrap(true);
        button.addActionListener(e -> text.append("button clicked \n")); //버튼의 ActionListener을 구현하기 위한 람다 표현식

        JScrollPane scroller = new JScrollPane(text);
        //스크롤을 수직 방향만 넣도록 설정
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller); //스크롤 기능을 패널에 추가(중요)

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(350, 300);
        frame.setVisible(true);
    }
}
