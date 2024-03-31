package ch16;

import java.io.*;

//직렬화 할 때 모두가 저장되지 않으면 어떻게 되는지 보여주는 예시.
public class Pond implements Serializable {
    //Duck는 직렬화가 안된다.
    private Duck duck = new Duck();

    public static void main(String[] args) {
        Pond myPond = new Pond();
        try {
            FileOutputStream fs = new FileOutputStream("Pond.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myPond);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/** 실행결과
 에러 발생 : java.io.NotSerializableException: ch16.Duck 
 */