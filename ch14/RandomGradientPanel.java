package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

//랜덤 그라데이션 원
public class RandomGradientPanel extends JPanel{
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        Color startColor = new Color(red, green, blue); //그라데이션 시작 컬러

        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);
        Color endColor = new Color(red, green, blue); //그라데이션 끝 컬러

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new RandomGradientPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
