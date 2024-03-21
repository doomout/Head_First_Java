package ch11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jukebox9 {
    public static void main(String[] args) {
        new Jukebox9().go();
    }

    public void go() {
        List<SongV4> songList = MockMoreSongs.getSongsV4();
        System.out.println(songList);

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        //HashSet을 출력하면 중복 되는  것은 제외된 상태로 출력된다.
        //ArrayList를 HashSet에 넣으면 HashSet에서 정렬된 순서를 그대로 유지해주진 않는다.
        Set<SongV4> songSet = new HashSet<>(songList);
        System.out.println(songSet);
    }
}

/**실행 결과
[somersault, cassidy, $10, havana, $10, cassidy, 50 ways] <-- 원본
[$10, $10, 50 ways, cassidy, cassidy, havana, somersault] <-- 정렬은 되었지만  $10, cassidy가 중복이다.
[havana, $10, 50 ways, cassidy, somersault] <--중복은 제거 되었으나 정렬은 안되었다.
 */