package ch9;

public class StackRef {
    public void foof() {
        barf();
      }
    
      public void barf() {
        Duck d = new Duck(24);
      }
}


/** 
 * barf()에서 하는 d 이름의 새로운 Duck 레퍼런스 변수를 설명하고 생성한다.
 * 메서든 안에서 선언되었으니 로컬 변수고, 스택 안에 저장된다.
 * 스택에는 다음과 같이 쌓인다.
 * foof() d
 * barf()
 * 
 * 객체는 무조건 힙에 들어간다.
 */