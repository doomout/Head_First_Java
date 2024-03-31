package ch16;

import java.io.*;

public class Square implements Serializable { //이 클래스는 객체 직렬화를 사용하겠다.
    private int width;
    private int height;

    public Square(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        Square mySquare = new Square(50, 20);

        try {
            //foo.ser 라는 파일이 있으면 연결하고, 없으면 새로 생성한다.
            FileOutputStream fs = new FileOutputStream("foo.ser"); 

            //객체를 저장하는 ObjectOutputStream를 FileOutputStream와 연결한다.
            ObjectOutputStream os = new ObjectOutputStream(fs);
          
            os.writeObject(mySquare);  //생성한 foo.ser 파일에 객체를 저장하라.
            os.close(); //파일 닫기
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
