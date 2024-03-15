package ch7;
/** 의사의 상위 클래스
public class Doctor {
    boolean worksAtHospital;
    
    //진료를 한다.
    void treatPatient() {
    
    }
}
 */
public class Surgeon extends Doctor{
    //boolean worksAtHospital; 는 상속받아서 그대로 사용

    //상속 받은 진료를 한다를 오버라이드해서 재정의 한다.
    //외과 수슬을 한다.
    void treatPatient() {
        
    }
    //살을 밴다.는 메서드를 추가
    void makeIncision() {

    }
}
