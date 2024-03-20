package ch11;

import java.util.Comparator;
import java.util.List;

public class Jukebox5 {
    public static void main(String[] args) {
        new Jukebox5().go();
    }

    public void go() {
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList);

        //Comparator 클래스 인스턴스를 만들고 List에 있는 sort()메서드를 사용한다.
        TitleCompare titleCompare = new TitleCompare();
        songList.sort(titleCompare);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        songList.sort(artistCompare);
        System.out.println(songList);
    }

    //Comparator를 구현하는 새로운 클래스
    //title 기준으로 정렬
    class TitleCompare implements Comparator<SongV3> {
        public int compare(SongV3 one, SongV3 two) {
            //one.getTitle()와 two.getTitle()를 비교해서 반환 해라
            return one.getTitle().compareTo(two.getTitle());
        }
    }
    //Comparator를 구현하는 새로운 클래스
    //artist 기준으로 정렬
    class ArtistCompare implements Comparator<SongV3> {
        public int compare(SongV3 one, SongV3 two) {
            //one.getArtist()와 two.getArtist()를 비교해서 반환 해라
            return one.getArtist().compareTo(two.getArtist());
        }
    } 
}
/**실행결과
[somersault, cassidy, $10, havana, Cassidy, 50 ways]  <--원본
[$10, 50 ways, Cassidy, cassidy, havana, somersault]  <--title 기준으로 정렬
[havana, Cassidy, cassidy, $10, 50 ways, somersault]  <--artist 기준으로 정렬
 */