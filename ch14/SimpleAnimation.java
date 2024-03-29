package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

//간단한 애니메이션 코드
public class SimpleAnimation {
    //메인 GUI 클래스에 원의 x, y좌표를 저장하기 위한 변수
    private int xPos = 70;
    private int yPos = 70;
  
    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }
  
    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        MyDrawPanel drawPanel = new MyDrawPanel();
    
        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    
        //원 이동을 위해 반복
        for (int i = 0; i < 130; i++) {
            xPos++; 
            yPos++;
    
            drawPanel.repaint(); //다시 그리기
    
            try {
                //너무 빠르면 안보이니 의도적으로 속도 늦춤
                TimeUnit.MILLISECONDS.sleep(50); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //내부 클래스 - 지속적으로 갱신되는 외부 클래스의 x,y 좌표를 사용한다.
    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            //원이 지나간 자리를 바탕 화면의 흰색으로 칠한다.
            g.setColor(Color.white);
            //getWidth(), getHeight()는 JPanel로 부터 상속 받은 메서드다.
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            g.fillOval(xPos, yPos, 40, 40);
        }
    } 
}
