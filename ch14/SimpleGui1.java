package ch14;

import javax.swing.JButton;
import javax.swing.JFrame;

//첫 번째 GUI : 버튼
public class SimpleGui1 {
    public static void main(String[] args) {
        //프레임(창) 생성
        JFrame frame = new JFrame();
        //버튼 생성
        JButton button = new JButton("click me");

        //창에 닫기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //창에 버튼 추가
        frame.getContentPane().add(button);

        //창 크기
        frame.setSize(300, 300);

        //창이 보이도록 설정
        frame.setVisible(true);
  }
}
