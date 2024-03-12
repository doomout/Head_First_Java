package ch4;

public class GoodDog {
    private int size; //인스턴스 변수를 private로 지정

    //getter, setter는  public로 지정
    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    void bark() {
        if (size > 60) {
        System.out.println("Wooof! Wooof!");
        } else if (size > 14) {
        System.out.println("Ruff!  Ruff!");
        } else {
        System.out.println("Yip! Yip!");
        }
    }
}

class GoodDogTestDrive {
    public static void main(String[] args) {
      GoodDog one = new GoodDog();
      one.setSize(70);
      GoodDog two = new GoodDog();
      two.setSize(8);
      System.out.println("Dog one: " + one.getSize());
      System.out.println("Dog two: " + two.getSize());
      one.bark();
      two.bark();
    }
  }