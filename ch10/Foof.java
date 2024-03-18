package ch10;

//final 키워드 예
class Foof {
    // 이렇게  하면 size 값을 변경할 수 없다.
    final int size = 3;
    final int whuffie;

    Foof() {
        whuffie = 42; //이제 이 값도 변경할  수 없다.
    }

    void doStuff(final int x) {
        // 인자값 x도 바꿀수 없다.
    }

    void doMore() {
        final int z = 7;
        // z도 바꿀수  없다.
    }
}
