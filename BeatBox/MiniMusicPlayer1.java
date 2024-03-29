package BeatBox;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.*;

//첫 번째 버전 - 미디 이벤트를 만들고 추가하는 작업을 간단하게 처리해주는 코드
public class MiniMusicPlayer1 {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //피아노 음을 5~61번 음까지 만든다.
            for (int i = 5; i < 61; i += 4) {
                 // 메시지와 이벤트를 만들고 그 결과를 Track에 추가한다.
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
                track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 메시지와 이벤트를 만든다.
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
