package ch13;

public class TestExceptions {
    public static void main(String[] args) {
        String test = "yes";
        try {
            System.out.println("try 블록 시작");
            doRisky(test);
            System.out.println("try 블록 끝");
        } catch (ScaryException se) {
            System.out.println("예외 발생");
        } finally {
            System.out.println("finally 블록");
        }
            System.out.println("main 끝");
    }

    static void doRisky(String test) throws ScaryException {
        System.out.println("위험한 메서드 시작");
        if ("yes".equals(test)) {
          throw new ScaryException();
        }
        System.out.println("위험한 메서드 끝");
    }
}

class ScaryException extends Exception {
}
/**실행 결과 
String test = "no" 일 때
try 블록 시작
위험한 메서드 시작
위험한 메서드 끝
try 블록 끝
finally 블록
main 끝

String test = "yes" 일 때
try 블록 시작
위험한 메서드 시작
예외 발생
finally 블록
main 끝
 */