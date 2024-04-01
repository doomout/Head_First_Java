package ch16;

import java.io.*;
import java.util.List;

import QuizCard.QuizCard;


//Try-With-Resources(TWR) 명령문 예제
public class SaveWithTWR {
    private List<QuizCard> cardList;

    private void saveFile(File file) {
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //;을 이용해서 자원을 구분한다.
            BufferedReader reader = new BufferedReader(new FileReader(file))
            )
        {
            for (QuizCard card : cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Couldn't write the cardList out: " + e.getMessage());
        }
    }
}
