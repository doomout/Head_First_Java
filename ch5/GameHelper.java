package ch5;

import java.util.Scanner;

public class GameHelper {
    public int getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
