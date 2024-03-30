package ch15;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListExample implements ListSelectionListener {
    private JList<String> list;

    public static void main(String[] args) {
        ListExample gui = new ListExample();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        String[] listEntries = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta "};

        list = new JList<>(listEntries);
        list.setVisibleRowCount(4); //스크롤하기 전에 보여줄 행의 갯수 설정
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //한 번에 하나만 선택할 수 있도록 설정
        list.addListSelectionListener(this); //목록 선택 이벤트에 등록

        JScrollPane scroller = new JScrollPane(list);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setSize(200, 150);
        frame.setVisible(true);
    }

    //이벤트 처리
    public void valueChanged(ListSelectionEvent e) {
        //if을 넣지 않으면 이벤트를 두 번 받게 된다
        if (!e.getValueIsAdjusting()) {
            String selection = list.getSelectedValue();
            System.out.println(selection);
        }
    }    
}
