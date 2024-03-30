#헤드퍼스트 자바 3판  
다시 공부 하는 자바 
- IDE : vscode
- 자바 : openjdk version "17.0.7"  
-----------이슈 기록-------------
1. 한글이 포함되어 있는 경우 컴파일시 에러나면 다음과 같이 컴파일
```java
javac 파일명.java -encoding utf-8 
```
2. 2장 요약 : 클래스와 객체
- 오버라이드(override) : 상속 받은 메서드를 재정의 하는 것
- 인스턴스 변수 : 객체가 자신에 대해 아는 것(상태)
- 메서드 : 객체가 자신이 하는 것(행동)
- 클래스 : 객체를 만들기 위한 설계도
- 객체 : 고유의  변수, 고유의 기능을 지정할 수 있다.
3. 3장 요약 : 원시 변수와 레퍼런스
- 자바는 타입(type)를 철저하게 따진다.
- 변수는 원시 변수, 객체 레퍼런스로 나뉜다.
- 원시 타입  
    - 불리언과 문자  
    boolean : true 또는 false  
    char 16비트 : 0~65535  
    - 정수  
    byte 8비트 : -128~127  
    short 16비트 : -32768~32767  
    int 32비트  
    long 64비트  
    - 부동 소수점 수  
    float 32비트   
    double 64비트  
- 객체 레퍼런스
    - 객체 레퍼런세에 객체 자체가 들어가는 것이 아니다.
    - 객체는 변수에 집어 넣을 수 없다.
    - 객체 레퍼런스 변수에는 객체에 접근하는 방법을 나타내는 비트가 들어있다.
    - 점 연산사(.)를 사용하면 객체를 이용해서 메서드를 호출하라는 의미다.
    - 레퍼런스 변수가 아무 객체도 참조하지 않으면 그 값은 null이 된다.
    - 배열은 항상 객체다. 배열에 원시 변수를 저장하도록 선언해도 마찬가지다.
4. 4장 요약 : 메서드는 인터턴스 변수를 사용한다.
- 메서드에서 인스턴스 변수를 이용해서 같은 타입의 객체가 다른 식으로 행동하게 할 수 있다.
- 메서드에서 매개변수를 사용할 수 있다. 메서드에 값 한 개 이상을 전달할 수 있다.
- 전달하는 값의 개수와 타입은 반드시 메서드를 선언할 때 지정한 것과 같아야 하며 그 순서도 같아야 한다.
- 메서드 안밖으로 전달되고 리턴되는 값은 상황에 짜라 자동으로 더 큰 타입으로 올라갈 수 있다.
- 더 작은 타입으로 바꿔야 한다면 강제로 캐스팅 해야 한다.
- 메서드를 선언할 때 반드시 리턴 타입을 지정해야 한다. void로 지정하면 리턴하지 않아도 된다.
- 메서드를 선언할 때 void가 아니라 리턴 타입을 지정했을 때는 반드시 선언된 리턴 타입과 호환 가능한 값을 리턴해야 한다.
- 인스턴스 변수는 private 로, getter, setter는 public 로 캡슐화
- 캡슐화를 하면 값을 직접 변경할 수 없어서 데이터 안전
- 다른 코드에서 객체의 데이터를 건드리는 것을 통제하려면 세터처럼 값을 바꾸는 공개 메서드를 만들면 된다.
- 인스턴스 변수에는 명시적으로 값을 설정하지 않아도 기본값이 대입된다.
- 로컬 변수(메서드 안에 있는 변수)는 기본값이 대입되지 않아서 초기화를 해야 한다.
- 두 원시 값이 같은지 확인할 때는 == 연산자를 사용한다.
- 두 레퍼런스가 같은지 확인할 때는 == 연산자를 사용한다.
- 두 객체가 동치인지 확인하고 싶으면 .equals()를 사용한다.
5. 5장 요약 : 프로그램 만들기
- 새로운 클래스를 만들 때는 준비 코드, 테스트 코드, 실제(자바) 코드를 만들어야 한다.
- 준비 코드는 무엇을 해야 할지 기술하는 것
- 테스트 코드를 설계할 때는 준비 코드를 활용한다.
- 메서드를 구현하기 전에 테스트 코드를 만든다.
- 반복문 코드 반복 횟수를 미리 알 경우에는 for문을 사용한다.
- 배열이나 컬렉션에 대해서 반복문을 돌릴 때는 향상된 for문을 사용한다.
6. 6장 요약 : 자바 API
- ArrayList는 자바 API에 포함되어 있는 클래스다.
- ArrayList에 무언가를 넣을 때는 add()를 쓰면 된다.
- ArrayList에 무언가를 제거할 때는 remove() 쓰면 된다.
- ArrayList에 들어 있는 어떤 것의 위치나 그것이 들어 있는지 알고 싶으면 indexOf()를 쓰면 된다.
- ArrayList에 비어 있는지 확인 할 때는 isEmpty()를 쓰면 된다.
- ArrayList의 크기(원소의 개수)를 알고 싶을 때는 size()를 쓰면 된다.
- 일반 배열의 길이(원소의 개수)를 알고 싶을 때는 length라는 변수를 쓰면 된다.
- ArrayList는 필요에 따라 그 크기가 자동으로 바뀝니다. 객체를 추가하면 커지고 제거하면 작아진다.
- ArrayList에 저장할 객체 타입은 타입 이름을 <>안에 집어넣는 형태의 타입 매개변수로 선언한다.
- ArrayList에는 원시타입의 값은 저장할 수 없고 일반  객체만 저장할 수 있다.
- 클래스는 패키지 단위로 묶는다.
- 클래스에는 패키지명과 클래스명을 합쳐서 만든 전체 이름이 있다.
- java.lang를 제외한 다른 패키지에 들어 있는 클래스를 사용하려면 자바 클래스의 전체 이름을 알려줘야 한다.
- 소스 코드 파일 맨 위에서 import 명령문을 사용한다
7. 7강 요약 : 상속과 다형성
- 하위 클래스는 상위 클래스를 확장한다.
- 하위 클래스는 상위 클래스에 있는 모든 public으로 지정한 인스턴스 변수와 메서드를 상속한다.
- private로 지정한 인스턴스 변수와 메서드는 상속하지 않는다.
- 상속된 메서드는 오버라이드할 수 있지만, 인스턴스 변수는 오버라이드 할 수 없다.
- 'A는 B다' 테스트를 활용해서 상속 계층이 올바른지 확인한다. x가 y를 확장한 것이라면 'x는 y다'라고 할 수 있어야 한다.
- 'A는 B다' 관계는 한 방향으로만 작동한다. 하마는 동물이지만, 모든 동물이 하나는 아니다.
- 하위 클래스에서 메서드를 오버라이드 했을 때, 하위 클래스의 인스턴스에 대해 그 메서드를 호출하면 오버라이드된 버전의 메서드가 호출된다.
- 오버라이드 : 상속한 메서드를 재정의 하는 것.
    - 인자는 같아야 하고, 리턴 타입은 호환이 가능해야한다.
    - 메서드를 접근 단계를 어렵게 만들면 안된다.
- 메서드 오버로딩 : 이름은 같지만 인자 목록이 다른 메서드 2개를 만드는 것
    - 리턴 타입이 달라도 된다.
    - 리턴 타입만 바꿀 수는 없다.
    - 접근 단계를 마음대로 바꿀 수 있다.
    - 오버로딩된 메서드는 메서드 이름만 같을 뿐 서로 다른 메서드다.
    - 상속이나 다형성하고는 전혀 관계가 없다.
    - 오버로딩과 오버라이딩은 서로 다른 개념이다.
8. 8강 요약 : 인터페이스와 추상 클래스
- 클래스를 만들 때 인스턴스를 만들 수 없게 하려면 abstract 키워드를 사용한다.
- 추상 클래스에는 추상 메서드와 추상 메서드가 아닌 메서드를 모두 넣을 수 있다.
- 클래스에는 추상 메서드가 하나라도 있으면 그 클래스는 추상 클래스로 지정해야 한다.
- 추상 메서드에는 본체가 없으며, 선언 부분은 세미콜론으로 끝난다.
- 상속 트리에서 처음으로 나오는 구상 클래스에서는 반드시 모든 추상 메서드를 구현해야 한다.
- 자바에 들어 있는 모든 클래스는 직접 또는 간접적으로 Object의 하위 클래스다.
- 메서드를 선언할 때 인자, 리턴 타입을 Object로 지정해도 된다.
- 어떤 객체에 대하여 메서드를 호출하려면 그 객체를 참조하는 레퍼런스 변수 타입의 클래스에 그 메서드가 있어야 한다.
- 메서드가 호출되면 그 메서드의 객체 타입의 구현을 사용한다.
- 죽음의 다이아몬드 문제 때문에 자바는 다중 상속을 허용하지 않는다. 클래스는 단 하나만 상속(확장) 할 수 있다.
- 인터페이스를 만들 때는 interface 키워드를 사용한다.
- 인터페이스를 구현할 때는 implements 키워드를 사용한다.
- 클래스를 만들 때 인터페이스를 여러개 구현할 수 있다.
- 기본 메서드, 정적 메서드를 제외하면 인터페이스를 구현하는 클래스는 그 인터페이스에 있는 모든 메서드를 구현해야 한다.
- 하위 클래스에서 오버라이드 했는데, 상위 클래스 버전을 호출하고 싶다면 super 키워드를 사용하면 된다.
9. 9강 요약 : 생성자와 가비지 컬렉션
- 인스턴스 변수는 그 변수가 들어 있는 객체 안에(힙 안에) 저장된다.
- 인스턴스 변수가 객체에 대한 레퍼런스인 경우에는 레퍼런스와 객체가 모두 힙에 저장된다.
- new 키워드를 사용할 때 실행되는 코드를 생성자라고 한다.
- 생성자명은 반드시 클래스명과 같아야 하며, 리턴 타입은 없어야 한다.
- 생성자를 이용해서 생성되는 객체의 상태(인스턴스 변수)를 초기화 할 수 있다.
- 클래스에 생성자가 없으면 컴파일러에서 기본 생성자를 만든다.
- 기본 생성자는 언제나 인자가 없는 생성자다.
- 클래스를 만들 때 생성자를 만들면 기본 생성자를 만들어주지 않는다.
- 인자가 없는 생성자를 만들고 싶은데, 인자가 있는 생성자가 따로 있다면 인자가 없는 생성자도 손수 만들어야 한다.
- 생성자 오버로딩을 활용하면 클래스에 두 개 이상의 생성자를 만들 수 있다.
- 오버로드된 생성자들의 인자 목록은 반드시 서로 달라야 한다.
- 인자 목록이 똑같은 생성자가 두 개 이상 있을 수 없다. 인자 목록을 따질 때는 순서와 인자의 타입을 모두 따진다.
- 직접 기본값을 지정하지 않아도 인스턴스 변수에는 자동으로 기본값이 지정된다. 
- 원시 타입의 기본값은 0/0.0/false 고, 객체에 대한 레퍼런스의 기본값은 null 이다. 
10. 10강 요약 : 숫자와 정적 변수, 정적 메서드
- 정적 메서드는 객체 레퍼런스 변수 대신 클래스명을 써서  호출한다.
- 정적 메서드는 힙에 그 메서드가 들어 있는 클래스의 인슽턴스가 없어도 호출할 수 있다.
- 특정 인스턴스 변숫값에 의존하지 않는 유틸리티 메서드는 정적 메서드로 만드는 것이 좋다.
- 정적  메서드에서는  특정 인스턴스와는 연관되지 않았으니 어떤 인스턴스 변수값도 사용할 수 없다.
- 정적 메서드가 아닌 메서드는 보통 인스턴스 변수와 연관되어 있으므로 정적 메서드에서는 정적 메서드가 아닌 메서드를 사용할 수 없다.
- 정적 메서드만 들어 있는 클래스가 있다면 그 클래스의 인스턴스를 만들 필요가 없으므로 그 생성자를 private로 지정하는 것이 좋다.
- 정적 변수는 해당 클래스에 속하는 몯든 객체에서 공유하는 변수
- 정적 메서드에서도 정적 변수를 사용할 수 있다.
- 자바에서 상수를 만들 때는 변수에 staticdhk final로 지정하면 된다.
- final로 지정한 정적 변수는 변수를 선언할 때 또는 정적 초기화 부분에서 반드시 값을 대입해야 한다.
- 상수의 이름은 전부 대문자를 사용하고 각 단어 사이에는 밑줄(_)을 넣어준다.
- final로 지정한 변수값은 한번 대입하면 바꿀 수 없다.
- final 인스턴스 변수값은 선언할 때 또는 생성자에서 대입해야 한다.
- final 메서드는 오버라이드 할 수 없다.
- final 클래스는 확장할 수 없다.(하위 클래스를 만들 수 없다.)
11. 11강 요약 : 자료구조
- java.util.List  
sort(Comparator): 주어진 Comparator에 의해 정해지는 순서에 따라 리스트를 정렬한다.
- java.util.Collections  
sort(List) : 주어린 리스트를 그 리스트에  있는 원소들의 자연스러운 순서(오름차순)를 기준으로 정렬한다.    
sort(List,  Comparator) : 주어진 리스트를 Comparator에 의해 정의되는 순서를 기준으로 정렬한다.
- 제네릭에 대하여
```java
//제네릭을 쓰는 클래스(ArrayList등)의 인스턴스를 만드는 방법    
new ArrayList<Song>()
//제네릭 타입 변수를 선언하고 변수에 값을 대입하는 방법  
List<Song> songList = new ArrayList<Song>()
//제네릭 타입을 인자로 받아들이는 메서드 선언(호출) 방법  
void foo(List<Song> list)
  x.foo(songList)
```
- 인터페이스 중 구현할 메서드가 1개인 경우 단일 추상 메서드라고 하고 SAM이라고 약어로 부른다.
- SAM 은 람다 표현식으로 구현할 수 있다.
```java
songList.sort((one, two)->one.getTitle().compareTo(two.getTitle()));
```
- 컬렉션 API 세 가지 인터페이스 사용 조건
  - List : 순서가 중요할 때
  - Set : 유일성이 중요할 때
  - Map : 키를 가지고 뭔가를 찾는 것이 중요할 때
- hashCode() 와 equals()와 관련된 규칙
  - 두 객체가 같으면 반드시 같은 해시 코드를 가져야 한다.
  - 두 객체가 같으면 equals()메서드를 호출 했을 때 true를 리턴한다.
  - 두 객체의 해시코드 값이 같다고 반드시 같은 것은 아니다. 하지만 두 객체가 같으면 두 해시코드는 반드시 같아야 한다.
  - equals()를 오버라이드하면 반드시 hashCode()도 오버라이드 해야 한다.
  - hashCode()에서는 기본적으로 힙에 있는 각 객체마다 유일한 값을 가지는 정수를 리턴한다.
  - equals()메서드에서는 기본적으로 == 연산자를 써서 객체를 비교한다.
```java
a.equals(b) 가 true 라면 a.hashCode() == b.hashCode() 도 성립한다.

하지만 a.hashCode() == b.hashCode() 가 성립해도 
a.equals(b) 가 반드시 true인 것은 아니다.
```
- TreeSet 원소는 반드시 Comparable 이어야 합니다.
```java
//집합에 들어가는 원소가 Comparable를 구현하는 타입이어야 한다. 
class Book implements Comparable<Book> {
  String title;
  public Book(String t) {
    title = t;
  }

  public int compareTo(Book other) {
    return title.compareTo(other.title);
  }
}
//또는~
// Comparator 를 인자로 받아들이는 TreeSet의 오버로드된 생성자를 사용해야 한다.
class BookCompare implements Comparator<Book> {
  public int compare(Book one, Book two) {
    return one.title.compareTo(two.title);
  }
}
```
- Map 사용예제
```java
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
```
12. 12강 요약 : 스트림, 람다
- 컬렉션에 대해서는 for반복문을 만드는 대신 forEach를 사용한다.
- stream 메서드를 호출하여 컬렉션(소스)로부터 스트림을 생성한다.
- 스트림에 대해서 한 개 이상의 중간 연산을 호출함으로써 컬렉션에 대해 돌릴 질의를 구성할 수 있다.
- 최종 연산을 호출하기 전까지는 아무 결과도 얻을 수 없다.
- 결과를 새로운 List로 출력하고 싶다면 최종 연산으로 collect(Collectors.toList)를 이용하면 된다.
- 소스 컬렉션, 중간 연산, 최종 연산의 조합으로 스트림 파이프라인이 만들어진다.
- 스트림 연산은 원본 컬렉션을 바꾸지 않는다. 
- 컬렉선에 질의를 하면 질의의 결과가 들어 있는 다른 객체를 리턴해주는 방법일 뿐이다.
- 람다 표현식은 객체이고 그 객체의 단일 추상 메서드를 호출하여 실행한다.
- 람다 표현식은 함수형 인터페이스를 구현한다.
- 함수형 인터페이스에는 단일 추상 메서드가 있다는 것,즉 추상 메서드가 딱 1개라는 것
```java
//람다 예제
//Comparator 인터페이스
public interface Comparator<T> {
  int compare(T o1, T o2);
}
//람다 표현식 (Comparator 구현) 
 (s1, s2) -> s1.compareToIgnoreCase(s2)
//람다 표현식이 두 줄 이상일 때
(str1, str2) -> {
  int l1 = str1.length();
  int l2 = str2.length();
  return l2 - l1;
}
```
13. 13강 요약 : 예외처리
- 실행 중에 문제가 생기면 메서드에서 예외를 던질 수 있다.
- 예외는 언제나 Exception 타입의 객체다.
- RuntimeException 타입에 속하는 예외에 대해서는 컴파일러에서 신경을 쓰지 않는다. 
- 컴파일러에서 항상 확인하는 Exception 타입을 확인 예외라고 부른다.
- 메서드에서 예외를 던질 때는 throw 키워드를 사용하며, 그 뒤에는 새로운 예외 객체를 만드는 구문을 적어주면 된다.
```java
throw new NoCaffeineException();
```
- 확인 예외를 던질 수 있는 메서드를 선언할 때는 반드시 throws SomeException 명령문을 써서 예외를 던질수 있다는 사실을 공표해야 한다.
- 확인 예외를 던지는 메서드를 호출할 때는 반드시 정해진 규칙을 준수해야 한다.
- 예외를 처리할 준비가 되어 있다면 예외를 던지는 메서더를 호출하는 코드를  try/catch 로 감싸야 하며, 예외처리/복구 코드는 catch 블록 안에 넣어야 한다.
14. 14강 요약 : 이벤트, 그래픽
- 이벤트
  - GUI를 만들 때는 우선 창을 만들어야 한다. 보통 JFrame를 사용한다.
  - JFrame에 위젯을 추가할 때는 다음과 같이 한다.
  ```java
  JFrame frame = new JFrame();
  ```
  - JFrame에는 다른 위젯을 직접 추가 할 수 없기 때문에 content pane에 추가 해야 한다.
  - 창을 화면에 표시 하려면 크기를 지정한 다음 화면에 나타나게 설정해야 한다.
  ```java
  frame.setSize(300, 300);
  frame.setVisible(true);
  ```
  - 이벤트가 일어나는지 지켜보려면 이벤트 소스에 등록해야 한다.
  - 리스너 인터페이스는 이벤트 소스에서 이벤트를 받아서 처리하는 메서드를 호출할 수 있는 방법을 제공한다.
  - 이벤트 소스에 등록할 때는 소스의 등록 메서드를 호출하면 된다.
  - 리스너 인터페이스를 구현할 때는 그 인터페이스에서 선언한 모든 이벤트 처리 메서드를 구현해야 한다.
  - 이벤트 처리 코드는 리스너의 콜백 메서드에 집어넣으면 된다.
  - 이벤트 처리 메서드로 전달된 이벤트 객체에는 이벤트의 소스에 대한 정보를 포함한 이벤트에 대한 정보가 들어 있다.
- 그래픽
  - 위젯에 2차원 그래픽을 직접 그릴 수 있다.
  - paintComponent()메서드는 GUI 시스템에서 호출한다.
  ```java
  //그래픽 객체에서 다음과 같은 메서드를 호출한다.
  g.setColor(Color.blue);
  g.fillRect(20,50,100,120);
  //jpg 파일을 화면에 출력할 때
  Image image = new ImageIcon("cat.jpg").getImage();
  //이미지 그릴 때
  g.drawImage(image, 3, 4, thie);
  //Graphics2D 메서드를 호출하려면 매개변수를 Graphics2D 객체로 캐스트 해야 한다.
  Graphics2D g2d = (Graphics2D)g;
  ```
  15. 15강 요약 : 스윙
  - 레이아웃 관리자는 다른 구성요소 안에 들어 있는 구성요소의 크기와 위치를 제어하는 역할을 한다.
  - 다른 구성요소에 어떤 구성요소를 추가하면, 추가된 구성요소는 배경 구성요소의 레이아웃 관리자에 의해 결정된다.
  - 레이아웃 관리자는 레이아웃에 대해 최종 결정을 내리기 전에 각 구성요소에 원하는 크기를 물어본다.
  - BorderLayout 관리자를 쓸 때는 지역 가운데 다섯 곳에 구성요소를 추가할 수 있다.
  - BorderLayout 에서 북쪽, 남쪽은 높이는 원하는대로 되지만 너비는 원하는대로 되지 않는다.
  - BorderLayout 에서 동쪽, 서쪽은 너비는 원하는대로 되지만 높이는 원하는대로 되지 않는다.
  - FlowLayout 에서는 구성요서를 왼쪽에서 오른쪽으로, 위에서 아래로 추가된 순서대로 배치한다.
  - FlowLayout 를 사용하면 구성요소에서 원하는 너비와 높이를 모두 맞춰줄 수 있다.
  - BoxLayout 를 사용하면 구성요소를 수직 방향으로 쌓을 수 있다. 원하는 높이와 높이를 모두 그대로 적용 할 수 있다.
  - BoxLayout 는 프레임의 기본 레이아웃 관리자고, FlowLayout 는 패널의 기본 레이아웃 관리자다.
  - 패널에서 FlowLayout 이 아닌 다른 레이아웃 관리자를 사용하고 싶으면 패널에 대해 setLayout()를 호출해야 한다.