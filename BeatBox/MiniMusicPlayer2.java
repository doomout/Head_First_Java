package BeatBox;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.*;

//2버전 - 리스너틀 등록하고 이벤트를 감시하는 버전,매 박자마다 명령행으로 메시지를 출력한다.
public class MiniMusicPlayer2 {
    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }
    
    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
        
            //이벤트를 sequencer 에 등록하고 이 이벤트 등록 메서드에서는 리스너와 필요한 ControllerEvent 의 목록을 나타내는 int배열을 인자로 받아들인다.
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(event -> System.out.println("la"), eventsIWant); //이벤트를 받을 때 마다 la를 출력한다.
        
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
        
            for (int i = 5; i < 60; i += 4) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));//박자를 골라내기 위한 코드. 음이 연주될 때 마다 이벤트를 받아오기 위해 넣는다.
                track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));
            }
        
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chnl, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
