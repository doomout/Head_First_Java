package ch11;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
  public static void main(String[] args) {
    //Map을 쓸때는 매개변수가 2개라 필요하다. <키, 값> 
        Map<String, Integer> scores = new HashMap<>();

        //add() 대신 put()를 사용한다. 인자도 2개 (키, 값)을 전달해야 한다.
        scores.put("Kathy", 42);
        scores.put("Bert", 343);
        scores.put("Skyler", 420);

        System.out.println(scores);

        //get()메서드에서는 키를 인자로 받고 값을 리턴한다.
        System.out.println(scores.get("Bert"));
    }    
}

/**실행결과
{Kathy=42, Skyler=420, Bert=343}
343
 */