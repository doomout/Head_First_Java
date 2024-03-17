package ch8;

import ch7.Dog;

//다형성 활용하기
public class MyDogList {
    //Dog 배열 사용
    private Dog[] dogs = new Dog[5];
    //새로운 Dog가 추가될 때마다 이 값을 증가 시킨다.
    private int nextIndex = 0;
  
    public void add(Dog d) {
        //배열이 다 차지 않았다면 Dog를 추가 하고 메시지를 출력한다.
        if (nextIndex < dogs.length) {
            dogs[nextIndex] = d;
            System.out.println("Dog added at " + nextIndex);
            //사용할 인덱스를 기억하기 위해 인덱스를 증가 시킨다.
            nextIndex++;
        }
    }
}