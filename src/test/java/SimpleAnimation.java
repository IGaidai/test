import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    JFrame frame;
    int x = 250;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    private void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);

        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int i = 0; i < 230; i++) {
            x--;
//            y++;

            frame.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.GREEN);
            g.fillOval(x, y, 40, 40);
        }
    }
}
