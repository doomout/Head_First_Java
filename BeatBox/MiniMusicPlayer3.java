package BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.sound.midi.ShortMessage.*;

//세 번째 버전 - 두 번째 버전에 그래픽을 추가한다.
public class MiniMusicPlayer3 {
    private MyDrawPanel panel;
    private Random random = new Random();

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        JFrame frame = new JFrame("My First Music Video");
        panel = new MyDrawPanel();
        frame.setContentPane(panel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
    setUpGui();

    try {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.addControllerEventListener(panel, new int[]{127});
        Sequence seq = new Sequence(Sequence.PPQ, 4);
        Track track = seq.createTrack();

        int note;
        //음을 랜덤으로 넣도록 수정
        for (int i = 0; i < 60; i += 4) {
            note = random.nextInt(50) + 1;
             // 메시지와 이벤트를 만들고 그 결과를 Track에 추가한다.
            track.add(makeEvent(NOTE_ON, 1, note, 100, i));
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
            track.add(makeEvent(NOTE_OFF, 1, note, 100, i + 2));
        }

        sequencer.setSequence(seq);
        sequencer.start();
        sequencer.setTempoInBPM(120);
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

    //그림 패널이 리스너
    class MyDrawPanel extends JPanel implements ControllerEventListener {
        //이벤트를 받았는지 구분하는 변수
        private boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true; //이벤트를 받으면 true로 설정하고
            repaint(); //다시 그리기
        }

        public void paintComponent(Graphics g) {
            //repaint()가 다른 이유로 호출될 수 있으니 조건문 사용
            if (msg) {
                //무작위 색 생성
                int r = random.nextInt(250);
                int gr = random.nextInt(250);
                int b = random.nextInt(250);

                g.setColor(new Color(r, gr, b));

                //무작위로 결정되는 직사각형에 색을 칠하기
                int height = random.nextInt(120) + 10;
                int width = random.nextInt(120) + 10;

                int xPos = random.nextInt(40) + 10;
                int yPos = random.nextInt(40) + 10;

                g.fillRect(xPos, yPos, width, height);
                msg = false;
            }
        }
    }
}
