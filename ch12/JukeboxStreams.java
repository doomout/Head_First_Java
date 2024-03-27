package ch12;

import java.util.List;
import java.util.stream.Collectors;

import ch12.JukeboxData.Songs;

public class JukeboxStreams {
    public static void main(String[] args) {
        List<Song> songs = new Songs().getSongs();

        //록 음악 전부 찾아내기
        List<Song> rockSongs = songs.stream() //songs의 List
                                    .filter(song -> song.getGenre().contains("Rock"))  //곡 정보로부터 장르를 받아와 그게 'Rock'인지 확인한다. 결과에 따라 참 또는 거짓 리턴
                                    .collect(Collectors.toList()); //결과를 List에 넣는다.
        System.out.println(rockSongs);

        //재생된 모든 장르의 목록 구하기
        List<String> genres = songs.stream()
                            .map(song -> song.getGenre()) //이 map()은 Song의 스트림에 대해 작용하기 때문에 매개변수는 Song 객체 하나 뿐이다.
                            .collect(Collectors.toList()); 
        System.out.println(genres);
        //중복 제거하기
        List<String> genres_distinct = songs.stream()
                            .map(song -> song.getGenre())
                            .distinct() //중복제거
                            .collect(Collectors.toList()); 
        System.out.println(genres_distinct);
        //람다 표현식을 메서드 레퍼런스로 쓰기
        
    }
}

/**실행 결과(록 음악 전부 찾아내기)
 [Cassidy, Grateful Dead, Rock, 1972, 123
, 50 ways, Paul Simon, Soft Rock, 1975, 199
, Hurt, Nine Inch Nails, Industrial Rock, 1995, 257
, Hurt, Johnny Cash, Soft Rock, 2002, 392
, The Outsider, A Perfect Circle, Alternative Rock, 2004, 312     
, With a Little Help from My Friends, The Beatles, Rock, 1967, 168
, Come Together, Ike & Tina Turner, Rock, 1970, 165
, With a Little Help from My Friends, Joe Cocker, Rock, 1968, 46  
, Immigrant Song, Karen O, Industrial Rock, 2011, 12
, I am not a woman, I'm a god, Halsey, Alternative Rock, 2021, 384
, Immigrant song, Led Zeppelin, Rock, 1970, 484
]
실행결과(재생된 모든 장르의 목록 구하기)
[Electronic, R&B, Rock, Soft Rock, Industrial Rock, Electronic, Soft Rock, Electronic, Alternative Rock, Rock, Blues rock, Rock, Rock, Industrial Rock, Electronic, R&B, Pop, Pop, Alternative Rock, Latin, Latin, Rock]
실행 결과(중복 제거)
[Electronic, R&B, Rock, Soft Rock, Industrial Rock, Alternative Rock, Blues rock, Pop, Latin]
 */