package ch18.ryan_monica;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RyanAndMonicaTest {
    public static void main(String[] args) throws InterruptedException {
        //BankAccount 인스턴스는 단 하나다.
        BankAccount account = new BankAccount();

        //라이언은 50을, 모니카는 100을 인출할 것이다.
        RyanAndMonicaJob ryan = new RyanAndMonicaJob("Ryan", account, 50);
        RyanAndMonicaJob monica = new RyanAndMonicaJob("Monica", account, 100);
        //두 작업을 위해 두개의 스레드가 있는 스레트 풀을 만들었다.
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //두 작업을 실행 시켰다.
        executor.execute(ryan); 
        executor.execute(monica);
        //스레드 풀을 닫았다.
        executor.shutdown();
        System.out.println("---");
    
    }
}

class RyanAndMonicaJob implements Runnable {
    private final String name;
    private final BankAccount account;
    private final int amountToSpend;

    RyanAndMonicaJob(String name, BankAccount account, int amountToSpend) {
        this.name = name;
        this.account = account;
        this.amountToSpend = amountToSpend;
    }

    public void run() {
        goShopping(amountToSpend);
    }

    private void goShopping(int amount) {
         //계좌 잔고를 확인하고 충분하면 돈을 쓴다.
        if (account.getBalance() >= amount) {
            System.out.println(name + "는 돈을 쓸 예정이다.");
            account.spend(amount);
            System.out.println(name + "는 지출 완료");
        } else {
            System.out.println("미안 자네는 돈이 없어. " + name);
        }
    }
}

class BankAccount {
    private int balance = 100; //통장 잔고는 100이 있다.

    //잔고 표시
    public int getBalance() {
        return balance;
    }

    public void spend(int amount) {
        balance = balance - amount;
        //잔고가 - 되었을 때
        if (balance < 0) {
            System.out.println("초과 인출!");
        }
    }
}


/**2회 실행 출력 결과
---
Ryan는 돈을 쓸 예정이다.
Monica는 돈을 쓸 예정이다.
초과 인출!
Monica는 지출 완료
Ryan는 지출 완료
---
Monica는 돈을 쓸 예정이다.
Ryan는 돈을 쓸 예정이다.
Monica는 지출 완료
초과 인출!
Ryan는 지출 완료
 */