package ch15;

import javax.swing.*;
import java.awt.*;

public class Button1 {
    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.go();
    }

    public void go() {
        //자바의 프레임은 동,서,남,북,중앙으로 구분한다.
        JFrame frame = new JFrame();

        JButton east = new JButton("east");
        JButton west = new JButton("west");
        JButton north = new JButton("north");
        JButton south = new JButton("South");
        JButton center = new JButton("Center");
        
        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.CENTER, center);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
