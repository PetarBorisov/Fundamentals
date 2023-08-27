import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyGame implements ActionListener {

    private JFrame frame;
    private JLabel scoreLabel;
    private int score;

    public MyGame() {
        frame = new JFrame("My Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create score label
        scoreLabel = new JLabel("Score: 0");
        frame.getContentPane().add(scoreLabel, BorderLayout.NORTH);

        // create button
        JButton button = new JButton("Click me!");
        button.addActionListener(this);
        frame.getContentPane().add(button, BorderLayout.CENTER);

        // set window size and make visible
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // increment score and update label
        score++;
        scoreLabel.setText("Score: " + score);
    }

    public static void main(String[] args) {
        MyGame game = new MyGame();
    }
}
