package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g) {
        //패널 전체에 검음색 배경색
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
    
        Color randomColor = new Color(red, green, blue);
        //원 색은 랜덤
        g.setColor(randomColor);
        //좌표 70, 70에서 너비 100, 높이 100 픽셀의 원
        g.fillOval(70, 70, 100, 100);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyDrawPanel());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
