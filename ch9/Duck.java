package ch9;

public class Duck {
    int size;

    //생성자
    public Duck() {
    }
  
    //생성자를 이용해 초기화 할 수 있다.
    //생성자에 int 매개변수를 추가하고
    public Duck(int duckSize) {
        System.out.println("Quack");
    
        size = duckSize; //인자값을 이용해서 size 인스턴스 변수값을 설정한다.
    
        System.out.println("size is " + size);
    }    
}

/** 다음과 같이 활용할 수 있다.
 * public class UseADick {
 *    public static void main (String[] args) {
 *       Duck d = new Duck(42);
 *    }
 * }
 * 
 * 출력 결과
 * Quack
 * size is 42
 */