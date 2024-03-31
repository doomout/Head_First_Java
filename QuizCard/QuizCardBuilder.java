package QuizCard;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder {
    private ArrayList<QuizCard> cardList = new ArrayList<>();
    private JTextArea question;
    private JTextArea answer;
    private JFrame frame;

    public static void main(String[] args) {
        new QuizCardBuilder().go();
    }

    //GUI 를 만들고 표시
    public void go() {
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        //TextArea, 스크롤 적용
        question = createTextArea(bigFont);
        JScrollPane qScroller = createScroller(question);

        answer = createTextArea(bigFont);
        JScrollPane aScroller = createScroller(answer);

        mainPanel.add(new JLabel("Question:"));
        mainPanel.add(qScroller);

        mainPanel.add(new JLabel("Answer:"));
        mainPanel.add(aScroller);

        //버튼
        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(e -> nextCard());
        mainPanel.add(nextButton);

        //메뉴바에 File 넣기
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        //File 하단에 New 넣기
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> clearAll()); //New 클릭하면 clearAll() 호출

        //File 하단에 Save 넣기
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> saveCard()); //Save 클릭하면 saveCard() 호출

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    //스크롤 함수
    private JScrollPane createScroller(JTextArea textArea) {
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }

    private JTextArea createTextArea(Font font) {
        JTextArea textArea = new JTextArea(6, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(font);
        return textArea;
    }

    //현재 카드를 리스트에 추가하고, 텍스트 영역 비움
    private void nextCard() {
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);
        clearCard();
    }

    //파일 대화상자를 열어서 사용자가 파일명을 정하고 내용을 저장할 수 있도록 함
    private void saveCard() {
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);

        JFileChooser fileSave = new JFileChooser();
        fileSave.showSaveDialog(frame);
        saveFile(fileSave.getSelectedFile());
    }

    //리스트 영역 지우고 텍스트 영역지움
    private void clearAll() {
        cardList.clear();
        clearCard();
    }

    //텍스트 영역 비움
    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    //파일 저장
    private void saveFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            //카드의 리스트를 순환하면서 각각의 내용을 파싱할 수 있는 방식으로  텍스트 파일에 저장
            //각 부분을 분명하게 구분할 수 있도록 저장
            for (QuizCard card : cardList) {
                writer.write(card.getQuestion() + "/"); //정답 구분자
                writer.write(card.getAnswer() + "\n");  //맨 뒷에 줄 바꿈
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldn't write the cardList out: " + e.getMessage());
        }
    }
}
