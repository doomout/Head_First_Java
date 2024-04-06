package ch18;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;
import static java.time.format.FormatStyle.MEDIUM;

//쓰기 작업하는 스레드는 1개, 읽기 작업하는 스레드는 2개
public class ConcurrentReaders {
    public static void main(String[] args) {
        //Chat 객체를  ArrayList에 저장한다. 스레드 안정성이 보장되지 않는다.
        //List<Chat> chatHistory = new ArrayList<>();
        
        //CopyOnWriteArrayList 는 읽기는 많이 하지만, 
        //쓰기는 자주 안하는 리스트일 때 스레드 안정성을 갖춘 자료구조다.
        List<Chat> chatHistory = new CopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);   //스레드 3개 생성
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> chatHistory.add(new Chat("Hi there!")));  //컬렉션에 추가했다.
            executor.execute(() -> System.out.println(chatHistory)); //컬렉션을 읽는다.
            executor.execute(() -> System.out.println(chatHistory)); //컬렉션을 읽는다.
        }
        executor.shutdown();
    }
}

final class Chat {
    //message, timestamp 필드는 불변으로 설정
    private final String message;
    private final LocalDateTime timestamp; 

    public Chat(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }

    public String toString() {
        String time = timestamp.format(ofLocalizedTime(MEDIUM));
        return time + " " + message;
    }
}

/**실행결과 ArrayList<> 버전
[]
[]
[]
[]
Exception in thread "pool-1-thread-2" [오전 3:12:11 Hi there!, 오전 3:12:11 Hi there!, 오전 3:12:11 Hi there!]
java.util.ConcurrentModificationException
[오전 3:12:11 Hi there!, 오전 3:12:11 Hi there!, 오전 3:12:11 Hi there!, 오전 3:12:11 Hi there!]
[오전 3:12:11 Hi there!, 오전 3:12:11 Hi there!, 오전 3:12:11 Hi there!, 오전 3:12:11 Hi there!]
Exception in thread "pool-1-thread-4" java.util.ConcurrentModificationException
Exception in thread "pool-1-thread-1" java.util.ConcurrentModificationException     
 */

/** 실행결과 CopyOnWriteArrayList<> 버전 
[]
[]
[]
[]
[오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!]
[오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!]
[오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!]
[오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!]
[오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!]
[오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!, 오전 3:19:40 Hi there!] 
ConcurrentModificationException 가 일어나지 않고 있다.
 */