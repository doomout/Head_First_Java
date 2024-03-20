package ch11;

import java.util.Collections;
import java.util.List;

public class Jukebox1 {
    public static void main(String[] args) {
        new Jukebox1().go();
    }

    public void go() {
        //곡명을 string의 list에 저장한다.
        List<String> songList = MockSongs.getSongStrings();
        //리스트의 내용을 출력한다.
        System.out.println(songList);
        
        // 알파벳 순서대로 곡 제목을 정렬한다.
        Collections.sort(songList);
        //정렬된 곡 제목을 출력한다.
        System.out.println(songList);
    }
}
/** 모의 코드다. 임시 테스트용 데이터다. 
 class MockSongs {
  public static List<String> getSongStrings() {
    List<String> songs = new ArrayList<>();
    songs.add("somersault");
    songs.add("cassidy");
    songs.add("$10");
    songs.add("havana");
    songs.add("Cassidy");
    songs.add("50 Ways");
    return songs;
  }
}
 */
/**출력결과 
[somersault, cassidy, $10, havana, Cassidy, 50 Ways]
[$10, 50 Ways, Cassidy, cassidy, havana, somersault]
 */