package ch11;

import java.util.*;

public class Jukebox2 {
    public static void main(String[] args) {
        new Jukebox2().go();
    }

    public void go() {
        //v1에선 String 타입이었으나 SongV2인 객체 타입으로 변경하였다.
        List<SongV2> songList = MockSongs.getSongsV2();
        System.out.println(songList);
        // 객체를 정렬해볼까?
        //컬렉션 유형의 sort(List<T>) 메서드는 인수(List<SongV2>)에 적용할 수 없습니다.  라고 에러 작열
        //Collections.sort(songList);
        System.out.println(songList);
    } 
}
