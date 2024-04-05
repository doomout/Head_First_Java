package ch17;

import java.util.concurrent.*;

public class PredictableRunOrder {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            PredictableSleep.main(args);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}

class PredictableSleep {
    public static void main (String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> sleepThenPrint());
        System.out.println("back in main");
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static void sleepThenPrint() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("top o’ the stack");
    }
}

class SleepWithTimeUnit {
    public static void main (String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> sleepThenPrint());
        System.out.println("back in main");
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static void sleepThenPrint() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("top o’ the stack");
    }
}

//쓰데드가 준비 될때까지 카운트다운 하기
class PredictableLatch {
    public static void main (String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //이 래치는 신호를 기다릴수 있도록 해준다.
        //여기에서는 기다릴 이벤트가 딱 한번이기 때문에 1이라는 값을 지정하였다.
        CountDownLatch latch = new CountDownLatch(1);

        //새 스레드에서 실행할 작업에 CountDownLatch 를 전달한다.
        executor.execute(() -> waitForLatchThenPrint(latch));
        System.out.println("back in main");
        
        //main 메서드에서 메시지를 출력하고 나면 래치에 카운트다운 하라고 알린다.
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static void waitForLatchThenPrint(CountDownLatch latch) {
        try {
            //메인 스레드에서 메시지를 인쇄할 때까지 기다린다
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
