package ch11;

public class SongV2 {
    //파일에 있는 세 개의  곡 정보를 위한 세 개의 인스턴스 변수
    private String title;
    private String artist;
    private int bpm;

    SongV2(String title, String artist, int bpm) {
        //새 song가 생성될 때마다 생성자에서 변수들을 설정한다.
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    //세 개의 속성을 위한 세 개의 게터  메서드
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    //toString 를  오버라이드 한다.
    public String toString() {
        return title;
    }
}

/**  v2 버전은 다음과 같이 코딩 되어 있다.
 class MockSongs {
  public static List<SongV2> getSongsV2() {
    List<SongV2> songs = new ArrayList<>();
    songs.add(new SongV2("somersault", "zero 7", 147));
    songs.add(new SongV2("cassidy", "grateful dead", 158));
    songs.add(new SongV2("$10", "hitchhiker", 140));

    songs.add(new SongV2("havana", "cabello", 105));
    songs.add(new SongV2("Cassidy", "grateful dead", 158));
    songs.add(new SongV2("50 ways", "simon", 102));
    return songs;
  }
}
 */