package ch9;

public class StackExample {
    public void doStuff() {
        boolean b = true;
        go(4);
    }

    public void go(int x) {
        int z = x + 24;
        crazy();
    }

    public void crazy() {
        char c = 'a';
    }
}

/** 메서드는 스택에 쌓인다.
 * 1. doStuff() b 로 처음 생김
 * 
 * 2. go() x,z
 *    doStuff() b  와 같이 위로 쌓임
 * 
 * 3. crazy(), c
 *    go() x,z
 *    doStuff() b 와 같이 위로 쌓임
 * 
 * 4. crazy()가 끝나면....
 *    
 *    go() x,z
 *    doStuff() b  와 같이 crazy()가 제거 된다.
 */