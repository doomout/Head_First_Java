public class Overloads {
    String uniqueID;

    //addNums()는 이름이 같지만 인자의 타입이 다르고, 리턴 타입도 다르다.(메서드 오버로딩)
    //단 리턴 타입만 다르게 바꿀 수는 없다.
    public int addNums(int a, int b) {
        return a + b;
    }

    public double addNums(double a, double b) {
        return a + b;
    }

    //setUniqueID() 는 이름이 같지만 인자의 타입이 다르다.
    public void setUniqueID(String theID) {
        uniqueID = theID;
    }

    public void setUniqueID(int ssNumber) {
        String numString = "" + ssNumber;
        setUniqueID(numString);
    }
}
