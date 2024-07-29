import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JFrameGUI {
    public static void main(String[] args) {
        System.out.println("Jframe is used to build GUI Java application");
        JFrame jFrame = new JFrame("BMI Calculator");

        JLabel userWeightLabel = new JLabel("Enter your weight in kgs");
        userWeightLabel.setBounds(40,40 , 200, 40);

        JTextField userWeightJTextField = new JTextField("0");
        userWeightJTextField.setBounds(240, 40, 60, 40);

        JLabel userHeightLabel = new JLabel("Enter your height in metres:");
        userHeightLabel.setBounds(40, 80, 200, 40);

        JTextField userHeightJTextField = new JTextField("0");
        userHeightJTextField.setBounds(240, 80, 60, 40);

        JButton calculateBMI = new JButton("Calculate BMI");
        calculateBMI.setBounds(200, 140, 130, 40 );

        JLabel resultLabel1 = new JLabel();
        resultLabel1.setBounds(200, 180, 150, 40);

      



        jFrame.add(userWeightLabel);
        jFrame.add(userWeightJTextField);

        jFrame.add(userHeightLabel);
        jFrame.add(userHeightJTextField);
        jFrame.add(resultLabel1);

        jFrame.add(calculateBMI);

        calculateBMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    float weight = Float.parseFloat(userWeightJTextField.getText());
                    float height = Float.parseFloat(userHeightJTextField.getText());
                    float bmivalue = weight / (height * height);
                    calculateBMI.setText(String.format("%.2f", bmivalue)); 

                if(bmivalue<18.5){
                    resultLabel1.setText("You are underweight");
                    resultLabel1.setForeground(Color.RED);
                }

                else if (bmivalue<25) {
                    resultLabel1.setText("You are normal");
                    resultLabel1.setForeground(Color.GREEN);
                    
                }

                else if (bmivalue<30) {
                    resultLabel1.setText("You are overweight");
                    resultLabel1.setForeground(Color.YELLOW);
                    
                }

                else{
                    resultLabel1.setText("You are obese");
                    resultLabel1.setForeground(Color.RED);

                }
                } catch (NumberFormatException ex) {
                    
                    calculateBMI.setText("Invalid input");
                }
            }
        });
           




        jFrame.setLayout( null);
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
        
    }


}
