package ch13;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1 {
    public void play() {
    try {
        //미디 재생을 위해선 Sequencer 객체를 만들고 MidiSystem의 객체를 요구한다.
        Sequencer sequencer = MidiSystem.getSequencer();
        System.out.println("Successfully got a sequencer");
    } catch(MidiUnavailableException e) { //항상 예외 발생시 어떻게 처리할지 명시하는게 좋다.
        System.out.println("Bummer");
        }
    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}
