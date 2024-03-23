package ch12;

import java.util.List;
import java.util.stream.Collectors;

//스트림 api 예제
public class CoffeeOrder {
  public static void main(String[] args) {
    List<String> coffees = List.of("Cappuccino","Americano", "Espresso", "Cortado", "Mocha","Cappuccino", "Flat White", "Latte");

    List<String> coffeesEndingInO = coffees.stream() //스트림 시작
                                           .filter(s -> s.endsWith("o")) //끝에 o가 있는 문자열만.
                                           .sorted() //오름차순으로 정렬
                                           .distinct() //중복제거
                                           .collect(Collectors.toList()); //모아서 저장
    System.out.println(coffeesEndingInO); //출력
  }  
}

/**실행결과
 [Americano, Cappuccino, Cortado, Espresso]
 */