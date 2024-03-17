package ch9;

public class TestHippo {
    public static void main(String[] args) {
        System.out.println("Starting...");
        Hippo h = new Hippo();
    }
}

/** 결과
Starting...
Making an Animal
Making a Hippo 

상속 받은 클래스는 하위 -> 상위 순으로 스택이 저장되고 
실행 후에는 상위 -> 하위 순으로 해제된다.
 */