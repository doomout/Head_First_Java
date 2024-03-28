package BeatBox;

import javax.sound.midi.*;

//소리 만들기 프로그램
public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            //1단계 - Sequencer 를 구해서 열기
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            //2단계 - 새로운 Sequencer를 만든다.
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            //3단계 - Sequencer에서 새로운 Track를 가져온다.
            Track track = seq.createTrack();

            //4단계 - Track 에 MidiEvent 를 집어넣는다.
            //Message 를 만든다.(무엇을 할 것인가?)
            ShortMessage msg1 = new ShortMessage();
            //Message 에 지시 사항을 넣는다.(메시지 유형, 채널, 연주할 음, 속도)
            //144 : noteOn 을 의미, 채널 : 연주자, 연주할 음 : 0~127 이하의 숫자 숫자가 클수록 높은 음, 속도 : 빠르고 세게 연주 기본값 100 
            msg1.setMessage(144, 1, 20, 100);
            //Message 를 이용해서 새로운 MidiEvent 를 만든다.
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            //MidiEvent를 Track에 추가한다.
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            //128 : noteOff 를 의미
            msg2.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 16);
            track.add(noteOff);

            //Sequencer 에 Sequence 를 보낸다. (CD 플레이어에 CD를 넣는 것과 같다.)
            player.setSequence(seq);

            //5단계 - 재생 버튼을 누르는 것과 같다.
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**실행 결과
 * 피아노의 한 음이 들린다.
 */
