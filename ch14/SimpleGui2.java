package ch14;

import javax.swing.*;
import java.awt.event.*; //리스너와 이벤트가 들어있는 패키지

//버튼의 ActionEvent 를 받는 방법
public class SimpleGui2 implements ActionListener {
    private JButton button;

    public static void main(String[] args) {
        SimpleGui2 gui = new SimpleGui2();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("날 클릭해~");

        //버튼에 리스너를 등록한다.(리스너 목록에 날 끼워줘~!)
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    //이 메서드가 실제 이벤트를 처리하는 메서드
    public void actionPerformed(ActionEvent event) {
        button.setText("자네가 클릭 했는가?");
    }
}
