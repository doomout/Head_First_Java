package ch12;

import java.util.List;

public class Ch10c {
    static void forExample() {
        List<String> allColors = List.of("Red", "Blue", "Yellow");
        for (String color : allColors) {
            System.out.println(color);
        }
    }

    static void forEachExample() {
        List<String> allColors = List.of("Red", "Blue", "Yellow");
        allColors.forEach(color -> System.out.println(color));
    }

    public static void main(String[] args) {
        //forExample();
        //forEachExample();
        //badFor1();
        //badFor2(); // 이건 예외 발생함
        //badFor3(); // 이건 컴파일 안됨
        //badFor4();
        //badFor5(); // 이건 컴파일 안됨
        forEach();
    }

    // 2, 3, 4, 5 출력
    static void badFor1() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        for (int i = 1; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }

    //예외 발생함
    static void badFor2() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        for (int i = 0; i <= nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }

    // 이건 컴파일 안됨
    static void badFor3() {
        /* 
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        for (int i = 0; i <= nums.length; i++) {
            System.out.println(nums.get(i));
        }
        */
    }

    //[1, 2, 3, 4, 5]
    //[1, 2, 3, 4, 5]
    //[1, 2, 3, 4, 5]
    //[1, 2, 3, 4, 5]
    //[1, 2, 3, 4, 5]
    static void badFor4() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        for (Integer num : nums) {
        System.out.println(nums);
        }
    }

    // 컴파일 안됨
    static void badFor5() {
        /* 
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        for (Integer int : nums) {
            System.out.println(nums);
        }
        */
    }

    static void forEach() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.forEach(num -> System.out.println(num));
    }
}
