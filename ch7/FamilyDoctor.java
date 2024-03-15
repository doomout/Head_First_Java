package ch7;

/** 의사의 상위 클래스
public class Doctor {
    boolean worksAtHospital;
    
    //진료를 한다.
    void treatPatient() {
    
    }
}
 */

public class FamilyDoctor extends Doctor {
    //boolean worksAtHospital;는 상속 받아서 그대로 사용
    //고유 변수 추가
    boolean makesHouseCalls;

    //treatPatient()는 상속을 받아서 그대로 사용
    //집에서 필요한 조언을 한다는 새 메서드를 추가
    void giveAdvice() {
      
    }
}
