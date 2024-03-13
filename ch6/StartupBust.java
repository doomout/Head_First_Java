package ch6;

import java.util.ArrayList;

public class StartupBust {
    //사용할 변수를 선언하고 초기화 한다.
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // 스타트업 객체 몇 개를 만들고 위치를 지정한다.
        // startup 객체 3개를 만들고 각각 이름을 부여한 후에 arrayList에 저장한다.
        Startup one = new Startup();
        one.setName("poniez");
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        three.setName("cabista");
        startups.add(one);
        startups.add(two);
        startups.add(three);
    
        //사용자에게 간단한 게임 방법을 설명한다.
        System.out.println("Your goal is to sink three Startups.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");
    
        //목록에 있는 각 startup 에 대해 반복한다.
        for (Startup startup : startups) {
            //startup의 위치를 지정하기 위한 보조 메서드를 호출
            ArrayList<String> newLocation = helper.placeStartup(3);
            //세터 메서드를 호출하여 방금 보조 메서드에서 받아 온 위치를 지정
            startup.setLocationCells(newLocation);
        } 
      } 

      private void startPlaying() {
        //startups 목록이 비어 있지 않다면.
        while (!startups.isEmpty()) {
            //사용자의 입력을 받는다.
            String userGuess = helper.getUserInput("Enter a guess");
            //checkUserGuess 메서드를 호출한다.
            checkUserGuess(userGuess);
        } 
        //finishGame 메서드를 호출한다.
        finishGame();
      } 

      private void checkUserGuess(String userGuess) {
        //사용자가 추측한 횟수를 증가 시킨다.
        numOfGuesses++;
        //따로 바꾸지 않으면 miss라고 가정
        String result = "miss";
    
        //목록에 들어있는 모든 startups 객체에 대해 반복
        for (Startup startupToTest : startups) {
            //사용자가 입력한 위치가 맞는지 또는 그 객체가 침몰했는지 물어본다.
            result = startupToTest.checkYourself(userGuess);
        
            if (result.equals("hit")) {
                //반복문에서 빠져나옴. 나머지는 더이상 확인할 필요 없음
                break;
            }
            if (result.equals("kill")) {
                //이건 침몰 했으니 목록에서 삭제하고 반복문을 빠져나옴
                startups.remove(startupToTest); 
                break;
            }
        } 
        //사용자에게 결과를 출력한다.
        System.out.println(result);
      }

      //게임 결과를 알려주는 메시지 출력
      private void finishGame() {
            System.out.println("All Startups are dead! Your stock is now worthless");
            if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
            } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
            }
      }
    
      public static void main(String[] args) {
        //game 객체를  만든다.
        StartupBust game = new StartupBust();
        //게임 객체에 게임을 설정하라는 명령을 내린다.
        game.setUpGame();
        //게임 객체에 주 게임 진행 반복문을 돌리라는 명령을 내린다.(사용자에게 계속해서  위치를 물어보고 그 추측을 확인한다.)
        game.startPlaying();
      } 
}
