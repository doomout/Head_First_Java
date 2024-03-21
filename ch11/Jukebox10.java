package ch11;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Jukebox10 {
    public static void main(String[] args) {
        new Jukebox10().go();
    }

    public void go() {
        List<SongV4> songList = MockMoreSongs.getSongsV4();
        System.out.println(songList);

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        Set<SongV4> songSet = new TreeSet<>(songList);
        System.out.println(songSet);
    }
/*
    public void go2() {
        List<SongV4> songList = MockMoreSongs.getSongsV4();

        Set<SongV4> songSet = new TreeSet<>((o1, o2) -> o1.getBpm() - o2.getBpm());
        songSet.addAll(songList);
        System.out.println(songSet);
    }  
    */
}

/**go() 실행결과
[somersault, cassidy, $10, havana, $10, cassidy, 50 ways] <--원본
[$10, $10, 50 ways, cassidy, cassidy, havana, somersault] <--리스트 정렬 (중복 있음)
[$10, 50 ways, cassidy, havana, somersault] <--TreeSet<>의 정렬 (중복)
 */