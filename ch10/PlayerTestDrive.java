package ch10;

//정적 변수 초기화
class Player {
    //클래스가 로딩되면 playerCount가 초기화 된다. 
    //여기서는 0으로 초기화 했지만 기본으로 int는 0으로 초기화 된다.
    static int playerCount = 0;
    private String name;

    public Player(String n) {
        name = n;
        playerCount++;
    }
}

public class PlayerTestDrive {
  public static void main(String[] args) {
    //정적 변수를 접근 할 때도 정적  메서드를 접근 할 때와 마친가지로 클래스 명을 사용한다.
        System.out.println(Player.playerCount);
        Player one = new Player("Tiger Woods");
        System.out.println(Player.playerCount); 
    }
}

/**실행 결과
 * 0   <--인스턴스 만들기 전 
 * 1   <--객체 한 개를 생성한 후
 */