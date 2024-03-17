package ch8;

public interface Pet {
    //사실 인터페이스 메서드는 자동으로 public abstract가 되기에 쓰지 않아도 된다.
    //여기서는 이렇다는 것을 강조하기 위해 적었다.
    public abstract void beFriendly(); //인터페이스에 들어 있는 모든  메서드는 추상 메서드이므로 반드시 ;으로 끝나야 한다.
    public abstract void play(); //본체는 인터페이스를 사용하는 클래스에서 구현해야 한다.
}
