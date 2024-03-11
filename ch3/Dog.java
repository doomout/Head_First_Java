package ch3;

class Dog {
  String name;

  public static void main(String[] args) {
    // Dog 객체를 만들고 접근
    Dog dog1 = new Dog();
    dog1.bark();
    dog1.name = "Bart";

    // Dog 배열 생성
    Dog[] myDogs = new Dog[3];
    // 각 배열에 개 몇마리를 넣음
    myDogs[0] = new Dog();
    myDogs[1] = new Dog();
    myDogs[2] = dog1;

    // 배열 레퍼런스를 써서 Dog 객체에 접근
    myDogs[0].name = "Fred";
    myDogs[1].name = "Marge";

    // myDogs[2]의 이름
    System.out.print("마지막 개의 이름: ");
    System.out.println(myDogs[2].name);

    //반복문을 써서 배열에 있는 모든 개가 짓도록 한다.
    int x = 0;
    while (x < myDogs.length) {
      myDogs[x].bark();
      x = x + 1;
    }
  }

  public void bark() {
    System.out.println(name + "이 왈! 하고 짖습니다.");
  }

  public void eat() {
  }

  public void chaseCat() {
  }
}