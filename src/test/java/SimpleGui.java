import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;

public class SimpleGui extends JFrame{
    JFrame frame;
    JButton colorButton;
    JButton labelButton;
    JLabel label;

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }

    public void go() {
        frame = new JFrame();

        colorButton = new JButton("Change colors");
        colorButton.addActionListener(new ColorButtonListener());
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);

        labelButton = new JButton("Change label");
        labelButton.addActionListener(new LabelButtonListener());
        frame.getContentPane().add(BorderLayout.EAST, labelButton);

        Component component = new Component();
        frame.getContentPane().add(BorderLayout.CENTER, component);

        label =new JLabel("I am label");
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public class Component extends JPanel {

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            Color startColor = new Color(red, green, blue);

            red = (int) (Math.random() * 256);
            green = (int) (Math.random() * 256);
            blue = (int) (Math.random() * 256);
            Color endColor = new Color(red, green, blue);

            GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
            g2d.setPaint(gradient);
            g2d.fillOval(70, 70, 100, 100);
        }
    }

    public class ColorButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent) {
            frame.repaint();
        }
    }

    public class LabelButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent) {
            label.setText("Wild fish");
        }
    }
}


