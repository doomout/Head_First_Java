package ch11;

class SongV4 implements Comparable<SongV4> {
    private String title;
    private String artist;
    private int bpm;

    //Song 객체가 인자로 전달된다.
    public boolean equals(Object aSong) {
        SongV4 other = (SongV4) aSong;
        return title.equals(other.getTitle());
    }

    //String 클래스에서 hashCode()메서드를 오버라이드 해놓았기 때문에 title.hashCode()메서드에서 리턴한 결과만 리턴하면 된다.
    public int hashCode() {
        return title.hashCode();
    }

    public int compareTo(SongV4 s) {
        return title.compareTo(s.getTitle());
    }

    SongV4(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
    } 
}
