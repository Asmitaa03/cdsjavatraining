import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ShufflingandAdditionGame extends JFrame {
    int score = 0;
    int num1, num2, correctAnswer;
    Timer timer;
    JButton nextButton;
    JLabel timerLabel, questionLabel;
    JTextField answerField;
    Random random = new Random();
    int timeLeft = 20; // Time limit

    public ShufflingandAdditionGame() {
        // Set  JFrame
        setTitle("Arithmetic Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        setVisible(true);
        
        // Create components
        timerLabel = new JLabel("Time left: " + timeLeft);
        JLabel questionLabel = new JLabel("Question: ");
        answerField = new JTextField();
        nextButton = new JButton("Next");

        // Add components to the frame
        add(timerLabel);
        add(questionLabel);
        add(answerField);
        add(nextButton);

        // next button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                if (timer.isRunning()) {
                    generateQuestion();
                }
                
            }
        });

        // timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft);
                if (timeLeft <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Game Over! Your score: " + score);
                    System.exit(0);
                }
            }
        });

        // Start the game
        generateQuestion();
    }

    private void generateQuestion() {
        num1 = random.nextInt(400) + 1;
        num2 = random.nextInt(400) + 1;
        correctAnswer = num1 + num2;

        ((JLabel) getContentPane().getComponent(1)).setText("Solve: " + num1 + " + " + num2);
        answerField.setText("");
        timeLeft = 20;
        timerLabel.setText("Time left: " + timeLeft);
        timer.start();
    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(answerField.getText());
            if (userAnswer == correctAnswer) {
                score++;
                JOptionPane.showMessageDialog(null, "Correct! Your score: " + score);
                
            } else {
                JOptionPane.showMessageDialog(null, "Wrong! The correct answer is " + correctAnswer);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShufflingandAdditionGame();
            }
        });
    }
}

