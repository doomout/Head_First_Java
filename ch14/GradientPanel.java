package ch14;

import javax.swing.*;
import java.awt.*;

//원을 그라데이션으로 그리기
public class GradientPanel extends JPanel  {
    public void paintComponent(Graphics g) {
        //Graphics2D 으로 캐스트
        Graphics2D g2d = (Graphics2D) g;

        //GradientPaint(시작점x, 시작점y, 시작하는 색상, 끝점x, 끝점y, 끝나는 색)
        GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);

        g2d.setPaint(gradient);

        //fillOval 그라데이션으로 원을 채우는 메서드
        g2d.fillOval(70, 70, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new GradientPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
