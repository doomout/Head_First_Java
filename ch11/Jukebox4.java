package ch11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jukebox4 {
    public static void main(String[] args) {
        new Jukebox4().go();
    }

    public void go() {
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList); //현재 상태 출력

        Collections.sort(songList); //제목순으로 정렬
        System.out.println(songList); //제목순 정렬 출력

        //Comparator 클래스의 인스턴스를 만든다.
        ArtistCompare artistCompare = new ArtistCompare();
        //리스트에 대하여 sort()를 호출하면서 새로 만든 Comparator 객체에 대한 레퍼런스를 넘겨준다.
        songList.sort(artistCompare);
        System.out.println(songList);
    }
}

class ArtistCompare implements Comparator<SongV3> {
    public int compare(SongV3 one, SongV3 two) {
        return one.getArtist().compareTo(two.getArtist()); //아티스트 정보가 담긴 String변수한테 비교 작업을 시킨다.
    }    
}

/**실행결과
[somersault, cassidy, $10, havana, Cassidy, 50 ways]  <--정렬하지 않은 songList
[$10, 50 ways, Cassidy, cassidy, havana, somersault]  <--제목 순으로 정렬 (Song의 compareTo 메서드 사용)
[havana, Cassidy, cassidy, $10, 50 ways, somersault]  <--아티스트 이름 순으로 정렬(ArtistCompare 사용)
 */