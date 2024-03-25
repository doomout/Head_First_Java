package ch12;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BeTheCompiler {
    public static void main(String[] args) {
    //컴파일이 되나? 안되면 이유를 주석으로 달았음
        Runnable runnable = () -> System.out.println("Hi!");
        Consumer<String> consumer = s -> System.out.println(s);
        //String를 리턴해야한다.
        //Supplier<String> supplier3 = () -> System.out.println("Some string");
        
        //매개 변수가 1개다
        //Consumer<String> consumer2 = (s1, s2) -> System.out.println(s1 + s2);
        
        //매개 변수가 없어야 한다.
        //Runnable runnable2 = (String str) -> System.out.println(str);
        Function<String, Integer> function = s -> s.length();
        Supplier<String> supplier = () -> "Some string";
        
        //계산된 값은 리턴을 한다는 뜻이다. 리턴이 없어야 한다.
        //Consumer<String> consumer3 = s -> "String" + s;
        
        //String를 받고 int를 반환해야 하는데 반대로 했다.
        //Function<String, Integer> function3 = (Integer i) -> "i = " + i;
        
        //매개 변수가 없어야 한다.
        //Supplier<String> supplier2 = s -> "Some string: " + s;
        
        //String 매개변수를 받아야 하고, int를 리턴해야 한다.
        //Function<String, Integer> function2 = () -> System.out.println("Some string");
    }

}

/** 함수형 인터페이스의 형태 
public interface Runnable {
    void run();    
}
public interface Consumer<T> {
    void accept(T t);
}
public interface  Supplier<T> {
    T get();
}
public interface Function<T, R> {
    R apply(T t);
}
*/