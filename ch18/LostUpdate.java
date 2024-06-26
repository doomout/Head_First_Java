package ch18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LostUpdate {
    public static void main(String[] args) throws InterruptedException {
        //모든 작업을 처리할 스레드 풀을 생성하고 30개  스레드를 더해서 갱신이 잘 안되도록 유도
        ExecutorService pool = Executors.newFixedThreadPool(30);
        //synchronized 로 지정한 increment() 메서드 사용
        //속도 저하나 교착 상태가 발생할 수 있다.
        //Balance balance = new Balance();

        //원자 변수(AtomicInteger)를 사용하여 스레드를 안전하게 사용한다.
        AtomicBalance balance = new AtomicBalance();
        
        //서로 다른 스레드에서 잔고를 1000번 갱신한다.
        for (int i = 0; i < 1000; i++) {
            pool.execute(() -> balance.increment());
        }
        pool.shutdown();
        // 잔고의  최종 값을 출력하기 전에 스레드  풀에서 모든 갱신을 처리하도록  한다.
        // 최종값이  1000이어야 한다 그보다 작으면 갱신 손실이 발생한 것이다.
        if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("balance = " + balance.balance);
        }
    } 
}

class Balance {
    int balance = 0;

    //balance의 현재 값이 아닌 balance 값을 읽는 순간의 값에 1을 더하여 잔고 값을 1 증가 시킨다.
    //synchronized 으로 지정하여 모든 단계가 끝나야 다음 스레드가 접근할 수 있다.
    public synchronized void increment() {
        balance++;
    }
}

class AtomicBalance {
    //원자 변수(AtomicInteger)를 사용하여 스레드를 안전하게 사용한다.
    AtomicInteger balance = new AtomicInteger(0); //int 값 대신 0 으로 초기화한 AtomicInteger를 사용한다.
  
    //원자적 연산을 사용할 때는 AtomicInteger를 붙이지 않아도 된다.
    public void increment() {
        balance.incrementAndGet();
    }
}

/** 5번 실행 결과
 balance = 991
 balance = 998
 balance = 997
 balance = 991
 balance = 994

synchronized  설정 후 5번 실행 결과
balance = 1000
balance = 1000
balance = 1000
balance = 1000
balance = 1000

AtomicInteger 를 사용한 메서드 사용 후 5번 실행 결과
balance = 1000
balance = 1000
balance = 1000
balance = 1000
balance = 1000
 */
