package ch11;

class SongV3 implements Comparable<SongV3>{
    private String title;
    private String artist;
    private int bpm;
  
    //sort()메서드에서는 compareTo()에 어떤 SongV3 객체를 인자로 전달하여 
    //그 SongV3 객체를 compareTo() 메서드가 호출된 SongV3 객체와 비교해준다.
    public int compareTo(SongV3 s) {
      return title.compareTo(s.getTitle());
    }
  
    SongV3(String title, String artist, int bpm) {
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
