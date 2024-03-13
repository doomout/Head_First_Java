package ch5;

public class SimpleStartupGame {
    public static void main(String[] args) {
        //사용자가 추측한 횟수를 저장하는 변수
        int numOfGuesses = 0;
        //사용자로부터 입력을 받기 위한 클래스가 들어 있음
        GameHelper helper = new GameHelper();
    
        SimpleStartup theStartup = new SimpleStartup();
        //첫번째 셀 위치를 정하기 위한 난수
        int randomNum = (int) (Math.random() * 5);
    
        //생성한 난수를 사용하여 셀위치 배열을 만듬
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        //스타트업의 위치를 지정
        theStartup.setLocationCells(locations);
        //스타트업이 살아 있는지 추적하기 위한 변수
        boolean isAlive = true;
    
        //스타트업이 살아 있는 동안 반복 체크
        while (isAlive) {
            //사용자가 추측한 값을 가져온다.
            int guess = helper.getUserInput("enter a number");

            //스타트업  객체를 통해 추측한 값이 맞는지 확인하고 결과 값을 리턴한다.
            String result = theStartup.checkYourself(guess);
            numOfGuesses++; //추측 횟수 증가
            //스타트업을 죽였다면...
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            } 
        } 
      } 
}
