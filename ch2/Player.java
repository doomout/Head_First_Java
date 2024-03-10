package ch2;

public class Player {
    int  number = 0; //추측한 숫자를 저장할 변수

    public  void guess() {
        number = (int)(Math.random() * 10);
        System.out.println("추측한 숫자: "+ number);
    }
}
