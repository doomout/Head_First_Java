package ch6;

import java.util.ArrayList;

public class Startup {
    //셀 위치가 들어 있는 ArrayList
    private ArrayList<String> locationCells;
    //startup의 이름
    private String name;

    //startup의 위치를 갱신하는 세터 메서드
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    //기본 세터 메서드
    public void setName(String n) {
        name = n;
    }

    //기존 코드에서 인자가 String로 변경
    public String checkYourself(String userInput) {
        String result = "miss";

        //사용자가 추측한 위치가 있는지 확인 있으면 인덱스 번호 리턴, 아니면 -1리턴
        int index = locationCells.indexOf(userInput);

        //인덱스가 0이상이면 사용자가 추측한 위치에 있다
        if (index >= 0) {
            locationCells.remove(index);  //삭제 함으로써 중복 정답을 막음

            //isEmpty() 메서드로 모든 위치를 맞혔는지 확인
            if (locationCells.isEmpty()) {
                result = "kill";
                //startup이 침몰 했음을 알려준다.
                System.out.println("Ouch! You sunk " + name + "   : ( ");
            } else {
                result = "hit";
            } 
        } 
        //"miss", "hit", "kill" 중 하나를 리턴
        return result;
    } 
}
