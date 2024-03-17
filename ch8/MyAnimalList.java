package ch8;

import ch7.Animal;

public class MyAnimalList {
    //새로운 Animal 객체를 만드는 것이 아니고 Animal 타입의 배열의 객체를 새로 만드는 것.
    //추상 타입의 객체를 저장하기 위한 배열 객체를 만드는 것은 가능
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;

    public void add(Animal a) {
        if (nextIndex < animals.length) {
            animals[nextIndex] = a;
            System.out.println("Animal added at " + nextIndex);
            nextIndex++;
        }
    }
}
