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
        userWeightLabel.setBounds(40, 40, 200, 40);

        JTextField userWeightJTextField = new JTextField();
        userWeightJTextField.setBounds(250, 40, 60, 40);

        JLabel userHeightLabel = new JLabel("Enter your height in metres:");
        userHeightLabel.setBounds(40, 80, 200, 40);

        JTextField userHeightJTextField = new JTextField();
        userHeightJTextField.setBounds(250, 80, 60, 40);

        JButton calculateBMI = new JButton("Calculate BMI");
        calculateBMI.setBounds(100, 130, 120, 50);

        JLabel resultLabel1 = new JLabel();
        resultLabel1.setBounds(250, 140, 200, 50);

        JLabel resultLabel2 = new JLabel();
        resultLabel2.setBounds(250, 120, 200, 40);
   

        jFrame.add(userWeightLabel);
        jFrame.add(userWeightJTextField);
        jFrame.add(userHeightLabel);
        jFrame.add(userHeightJTextField);
        jFrame.add(resultLabel1);
        jFrame.add(resultLabel2);
        jFrame.add(calculateBMI);

        calculateBMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
            // TODO Auto-generated method stub
            if(userWeightJTextField.getText().isEmpty() || userHeightJTextField.getText().isEmpty())
            {
                resultLabel1.setText("Weight or height is empty");
            }
            else{
            float weight=Float.parseFloat(userWeightJTextField.getText().toString());
            float height=Float.parseFloat(userHeightJTextField.getText().toString());
            float bmivalue=weight/(height*height);
            resultLabel2.setText(String.valueOf("BMI: " + bmivalue));

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
                } 
                    
            
            }
         } );
           




        jFrame.setLayout( null);
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
        
    }

}

