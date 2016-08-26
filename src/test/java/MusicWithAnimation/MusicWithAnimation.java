package MusicWithAnimation;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;


public class MusicWithAnimation {
    static JFrame f = new JFrame("Music Video");
    static MyDrawPanel ml;

    public static void main(String[] args) {
        MusicWithAnimation mini = new MusicWithAnimation();
        mini.play();

    }

    public void setUpGui() {
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30, 30, 300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static MidiEvent MakeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
        }

        return event;
    }

    private void play() {
        setUpGui();
        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            sequencer.addControllerEventListener(ml, new int[]{127});

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i += 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(MakeEvent(144, 1, r, 100, i));
                track.add(MakeEvent(176, 1, 127, 0, i));
                track.add(MakeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    class MyDrawPanel extends JPanel implements ControllerEventListener {

        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            g.setColor(new Color(red, green, blue));

            int ht = (int) ((Math.random() * 120) + 10);
            int wt = (int) ((Math.random() * 120) + 10);

            int x = (int) ((Math.random() * 40) + 10);
            int y = (int) ((Math.random() * 40) + 10);

            g.fillRect(x, y, ht, wt);
            msg = false;
        }
    }
}
