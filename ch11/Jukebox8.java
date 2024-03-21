package ch11;

import java.util.*;

//곡을 HashSet에 저장하도록 수정
public class Jukebox8 {
    public static void main(String[] args) {
        new Jukebox8().go();
    }

    public void go() {
        //SongListMore.txt의 내용과 같은 값을 가지는 SongV3 객체의 List를 리턴하는 MockMoreSongs 클래스를 만들었다.
        List<SongV3> songList = MockMoreSongs.getSongsV3();
        System.out.println(songList);

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        //Set에 SongV3 객체들을 저장한다.
        //HashSet은 Set이기 때문에 hashSet도 이 Set 변수에 저장할 수 있다.
        Set<SongV3> songSet = new HashSet<>(songList);
        System.out.println(songSet);
    }    
}

/**실행 결과
[somersault, cassidy, $10, havana, $10, cassidy, 50 ways]  <--리스트 정렬 전
[$10, $10, 50 ways, cassidy, cassidy, havana, somersault]  <--제목순으로 정렬
[$10, cassidy, $10, havana, 50 ways, cassidy, somersault]  <--HastSet에 집어 넣고 그 HashSet를 출력한 결과

여전히 $10, cassidy가 중복되는 버그가 있다.
 */