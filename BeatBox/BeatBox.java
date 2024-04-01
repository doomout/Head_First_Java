package BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static javax.sound.midi.ShortMessage.*;

public class BeatBox {
    //체크 상자를 ArrayList 에 저장
    private ArrayList<JCheckBox> checkboxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    //GUI 레이블을 만들 때 사용할 악기명을 String 배열로 저장한다.
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};
    //실제 드럼 '건반'을 나타낸다. 
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    public void buildGUI() {
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        //빈 경계선을 사용하여 패널의 모서리와 구성요소가 배치되는 자리 사이에 빈 공간을 만든다.
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> buildTrackAndStart()); //이벤트 핸들러를 람다로 표현
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> sequencer.stop()); //이벤트 핸들러를 람다로 표현
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(e -> changeTempo(1.03f)); //기본 템포가 1.0이기 때문에 클릭할 때 마다 +,- 3%씩 바꿔준다.
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(e -> changeTempo(0.97f));//기본 템포가 1.0이기 때문에 클릭할 때 마다 +,- 3%씩 바꿔준다.
        buttonBox.add(downTempo);

        JButton save = new JButton("serializeIt"); //현재 패턴이 저장된다.
        save.addActionListener(e -> writeFile());
        buttonBox.add(save);
    
        JButton restore = new JButton("restore"); //저장된 패턴을 불러오고 체크 상자를 리셋한다.
        restore.addActionListener(e -> readFile());
        buttonBox.add(restore);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
            //각 악기의 이름마다 경계선을 더해주면 체크 상자랑 줄 맞추는데 도움이 된다.
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            nameBox.add(instrumentLabel);
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);

        JPanel mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        checkboxList = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();  //체크 상자를 만들고, 
            c.setSelected(false); //모든 값을 비체크 상태로 설정하고,
            checkboxList.add(c); //ArrayList에 추가하고,
            mainPanel.add(c); //GUI 패널에 넣는다.
        }

        setUpMidi();

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //체크 상자의 상태를 미디 이벤트로 바꾼 다음 그 이벤트를 Track 에 추가한다.
    private void buildTrackAndStart() {
        int[] trackList;

        sequence.deleteTrack(track); //기존 Track를 제거하고 
        track = sequence.createTrack(); //새로운 트랙을 만든다.

        //악기에 대한 반복
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            int key = instruments[i]; //악기가 무엇인지 나타내는 건반을 설정한다.

            //박자에 대한 반복
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkboxList.get(j + 16 * i);
                //각 박자가 체크가 되어 있나?
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            //현재 악기의 16박자에 대한 전체 이벤트를 만들고 
            makeTracks(trackList);
            //trackList 에  추가
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16));
        }

        track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start(); //재생
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeTempo(float tempoMultiplier) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    }

    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(NOTE_OFF, 9, key, 100, i + 1));
            }
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

     private void writeFile() {
        //각 체크 상자의 상태를 담아두기 위한 boolean 배열
        boolean[] checkboxState = new boolean[256];

        //체크박스 리스트에 대해 반복문을 돌리며 각각의 상태를 배열에 저장
        for (int i = 0; i < 256; i++) {
            JCheckBox check = checkboxList.get(i);
            if (check.isSelected()) {
                checkboxState[i] = true;
            }
        }
        //배열을 직렬화해서 저장
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Checkbox.ser"))) {  //TWR
            os.writeObject(checkboxState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        boolean[] checkboxState = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Checkbox.ser"))) { //TWR
            //역직렬화 후에는 원래 상태였던 boolean[] 타입으로 캐스팅 해야 한다.
            checkboxState = (boolean[]) is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //반복하며 저장되어 있던 체크 상태로 복구한다.
        for (int i = 0; i < 256; i++) {
            JCheckBox check = checkboxList.get(i);
            check.setSelected(checkboxState[i]);
        }

        sequencer.stop(); //현재 재생중인 것이 있다면 중지시킨다.
        buildTrackAndStart();
    }
}
