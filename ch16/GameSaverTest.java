package ch16;

import java.io.*;

//게임 캐릭터를 저장하는 예제 
public class GameSaverTest {
    public static void main(String[] args) {
        // 캐릭터를 3개고 현재 능력치나 스킬
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician",new String[]{"spells", "invisibility"});

        // 여기에는 캐릭터 상태 값을 바꿔주는 코드가 있다고 가정....

        try {
            //캐릭터를 직렬화(저장)하고 Game.ser 라는 파일에 저장
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            //직열화 한 Game.ser 를 읽어서 역직렬화(불러오기)
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            //GameCharacter 로 캐스팅
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("One's type: " + oneRestore.getType());
            System.out.println("Two's type: " + twoRestore.getType());
            System.out.println("Three's type: " + threeRestore.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/** 실행 결과
One's type: Elf
Two's type: Troll     
Three's type: Magician
 */
