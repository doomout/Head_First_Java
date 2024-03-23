package ch12;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LimitWithStream {
    public static void main(String[] args) {
        streamExamples();
        limitWithCountTerminal();
        limitWithCollect();
        limitAsStream();
        chainedOperations();
        sortingCaseInsensitive();
        filtering();
        printCollectionAfterChanges();
        noReusing();
    }

/**실행 결과
limit = java.util.stream.SliceOps$1@2f92e0f4
result = 4
result = [I, am, a, list]   
result = [I, am, a, list]   
result = [I, Strings, a, am]
result = [am, list, of]     
result = [a, am, I, list]   
result = [I, am, a, of]     
strings = [I, am, a, list, of, Strings]
result = [I, am, a, list]
noReusing(); 는 예외발생
*/

    static void streamExamples() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        System.out.println("limit = " + limit);
    }

    static void limitWithCountTerminal() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        long result = limit.count();
        System.out.println("result = " + result);
    }

    static void limitWithCollect() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        List<String> result = limit.collect(Collectors.toList());
        System.out.println("result = " + result);
    }

    static void limitAsStream() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        List<String> result = strings.stream()
                                    .limit(4)
                                    .collect(Collectors.toList());
        System.out.println("result = " + result);
    }

    static void chainedOperations() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        List<String> result = strings.stream()
                                    .sorted()
                                    .limit(4)
                                    .collect(Collectors.toList());
        System.out.println("result = " + result);

        List<String> result2 = strings.stream()
                                    .sorted()
                                    .skip(3)
                                    .limit(4)
                                    .collect(Collectors.toList());
        System.out.println("result = " + result2);
    }

    static void sortingCaseInsensitive() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        List<String> result = strings.stream()
                                    .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                                    .limit(4)
                                    .collect(Collectors.toList());
        System.out.println("result = " + result);
    }

    static void filtering() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        List<String> result = strings.stream()
                                    .filter(s -> s.length() < 4)
                                    .collect(Collectors.toList());
        System.out.println("result = " + result);
    }

    static void printCollectionAfterChanges() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        List<String> result = strings.stream()
                                    .limit(4)
                                    .collect(Collectors.toList());
        System.out.println("strings = " + strings);
        System.out.println("result = " + result);
    }


    static void noReusing() {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        Stream<String> limit = strings.stream()
                                    .limit(4);
        List<String> result = limit.collect(Collectors.toList());
        List<String> result2 = limit.collect(Collectors.toList());
    }
}
