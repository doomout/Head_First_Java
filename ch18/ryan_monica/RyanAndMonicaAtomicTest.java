package ch18.ryan_monica;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//원자 변수를 사용한 버전
public class RyanAndMonicaAtomicTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {//테스트를 위해 10번 반복
            BankAccountWithAtomic account = new BankAccountWithAtomic();
            RyanAndMonicaAtomicJob ryan = new RyanAndMonicaAtomicJob("Ryan", account, 50);
            RyanAndMonicaAtomicJob monica = new RyanAndMonicaAtomicJob("Monica", account, 100);
            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.execute(ryan);
            executor.execute(monica);
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("---");
        }
    }
}

class RyanAndMonicaAtomicJob implements Runnable {
    private final String name;
    private final BankAccountWithAtomic account;
    private final int amountToSpend;

    RyanAndMonicaAtomicJob(String name, BankAccountWithAtomic account, int amountToSpend) {
        this.name = name;
        this.account = account;
        this.amountToSpend = amountToSpend;
    }

    public void run() {
        goShopping(amountToSpend);
    }

    private void goShopping(int amount) {
        System.out.println(name + "는 돈을 쓸 예정이다.");
        account.spend(name, amount);
        System.out.println(name + "는 지출 완료");
    }
}
  
class BankAccountWithAtomic {
    //잔고를  AtomicInteger에 저장한다. 초기값은 100으로 설정한다.
    private final AtomicInteger balance = new AtomicInteger(100);

    //동기화 하지 않았다.
    public void spend(String name, int amount) {
        // 돈이 충분한지 확인한다.
        int initialBalance = balance.get();
        
        if (initialBalance >= amount) {
            //잔고를 기록한다.
            //compareAndSet(우리가 생각하는 잔고 값, 새로 바뀌었으면 하는 잔고 값)
            boolean success = balance.compareAndSet(initialBalance, initialBalance - amount);
            if (!success) {
                System.out.println("미안 " + name + ", 자네는 돈을 쓰지 않았어.");
            }
        } else {
            System.out.println("미안 자네는 돈이 없어. " + name);
        }
    }
}

/** 실행 결과
Monica는 돈을 쓸 예정이다.
Ryan는 돈을 쓸 예정이다.   
Monica는 지출 완료
미안 자네는 돈이 없어. Ryan
Ryan는 지출 완료
---
 */