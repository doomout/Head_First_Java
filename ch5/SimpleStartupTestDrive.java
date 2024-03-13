package ch5;

public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        SimpleStartup dot = new SimpleStartup();

        //스타트업의 위치를 테스트용으로 지정한다.
        int[] locations = {2,3,4};

        //스타트업에 대한 세터 메서드를 호출한다.
        dot.setLocationCells(locations);

        //사용자가 추측한 위치 역할을 할 가짜 값
        int userGuess = 2;

        //스타트업 객체에 대해 checkYourself()메서드 호출
        String result = dot.checkYourself(userGuess);

        //기본은 실패로 설정
        String testResult = "failed";

        //가짜 값이 맞으면(hit가 리턴되면) 테스트 패스
        if(result.equals("hit")) {
            testResult = "passed";
        }

        //테스트 결과 출력.
        System.out.println(testResult);
    }
}

class SimpleStartup {
    //
    private int[] locationCells;
    //몇번 맞췄나 정하는 변수
    private int numOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    //사용자가 추측한 위치를 받아오고 확인하는 메서드
    public String checkYourself(int guess) {
        //기본 값은 miss로 설정 
        String  result = "miss";

        //locationCells 배열에 있는 각 셀에 대해 반복
        for(int cell : locationCells) {
            //만약  사용자가 추측한 위치가 맞으면.
            if (guess == cell) {
                result = "hit"; //hit 저장
                numOfHits++; //맞힌 갯수 증가
                break;
            }
        }
        //맞힌 횟수가 3이면 결과를  kill로 저장
        if(numOfHits == locationCells.length) {
            result = "kill";
        }
        //결과 출력
        System.out.println(result);

        //결과 리턴
        return result;
    }
}