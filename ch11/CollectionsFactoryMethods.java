package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

//컬렉션을 위한 간편 팩토리 메서드(자바9 버전 이후부터 사용가능)
public class CollectionsFactoryMethods {
    public static void main(String[] args) {
        createAListOfSongs();
    }
    //예전에는 add()를 사용하여 하나하나 추가 하였음.
    public static List<String> createAListOldSchool() {
        List<String> songs = new ArrayList<>();
        songs.add("somersault");
        songs.add("cassidy");
        songs.add("$10");
        return Collections.unmodifiableList(songs);
    }

    //List에 String 타입으로 만들기 .of(값, 값, 값);
    public static void createAList() {
        List<String> strings = List.of("somersault", "cassidy", "$10");
    }

    //List에 객체 타입으로 만들기 .of(new 객체명(값, 값, 값), ~);
    public static void createAListOfSongs() {
        List<SongV4> songs = List.of(new SongV4("somersault", "zero 7", 147),
                                    new SongV4("cassidy", "grateful dead", 158),
                                    new SongV4("$10", "hitchhiker", 140));
    }

    //Set 만들기 .of(new 객채명(값), ~)
    public static void createASet() {
        Set<Book> books = Set.of(new Book("How Cats Work"),
                                new Book("Remix your Body"),
                                new Book("Finding Emo"));
    }
    //Map 만들기 .of(키, 값)
    public static void createAMap() {
        Map<String, Integer> scores = Map.of("Kathy", 42,
                                            "Bert", 343,
                                            "Skyler", 420);
    }

    //Map에 넣을 항목이 10개 미만일 때..
    public static void createAMapOfSameTypes() {
        Map<String, String> favouriteStores = Map.of("Riley", "Supersports",
                                                    "Brooklyn", "Camera World",
                                                    "Jay", "Homecase");
    }

    //Map에 넣을 항목이 10개 이상이면 키와 값이 어떻게 쌍을 이루는지 더 분명하게 하려면 
    //ofEntries(Map.entry(키, 값), ~ ) 을 사용한다.
    public static void createAMapOfEntries() {
        Map<String, String> favouriteStores = Map.ofEntries(Map.entry("Riley", "Supersports"),
                                                            Map.entry("Brooklyn", "Camera World"),
                                                            Map.entry("Jay", "Homecase"));
    }
}
