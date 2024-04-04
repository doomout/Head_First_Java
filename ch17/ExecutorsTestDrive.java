package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//요즘 스레드 사용법 
public class ExecutorsTestDrive {
    public static void main(String[] args) {
        //ExecutorService 는 작업을 실행하는 역할을 한다. 
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("top o’ the stack")); //execute()는 작업을 실행하라고 알린다.
        System.out.println("back in main");

        executor.shutdown(); //다 쓰고 나면 종료해야 한다.
    } 
}
