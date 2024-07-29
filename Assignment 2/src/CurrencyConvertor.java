import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConvertor{
    public static void main(String[] args){
        JFrame jFrame = new JFrame("Currency Convertor");

        JLabel inrLabel  = new JLabel("Enter the amount in INR");
        inrLabel.setBounds(40, 40, 200, 40);

        JTextField inrJTextField = new JTextField("0");
        inrJTextField.setBounds(240, 40, 60, 40);

        JLabel usdLabel  = new JLabel("Enter the amount in USD");
        usdLabel.setBounds(40, 80, 200, 40);

        JTextField usdJTextField = new JTextField("0");
        usdJTextField.setBounds(240, 80, 60, 40);

        JButton convert = new JButton("Convert the currency");
        convert.setBounds(200, 140, 180, 40 );


        JLabel resultLabel  = new JLabel();
        resultLabel.setBounds(200, 180, 150, 40);

        jFrame.add(inrLabel);
        jFrame.add(inrJTextField);

        jFrame.add(usdLabel);
        jFrame.add(usdJTextField);
        jFrame.add(resultLabel);

        jFrame.add(convert);

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(!inrJTextField.getText().isEmpty() && usdJTextField.getText().isEmpty()){
                    float inrvalue = Float.parseFloat(inrJTextField.getText().toString());
                    
                }

                else if(inrJTextField.getText().isEmpty() && !usdJTextField.getText().isEmpty()){
                    float usdvalue = Float.parseFloat(usdJTextField.getText().toString());
                }

                else if(inrJTextField.getText().isEmpty() || usdJTextField.getText().isEmpty()){

                }

                else{
                    float inrvalue = Float.parseFloat(inrJTextField.getText());
                    float usdvalue = Float.parseFloat(usdJTextField.getText());
                    float inrtousd = (float) (inrvalue/83.73);
                    float usdtoinr = (float) (usdvalue*83.73);
                    resultLabel.setText(String.valueOf(inrtousd)+"USD     "+String.valueOf(usdtoinr)+"INR");
                }
                    
                }});

                





        jFrame.setLayout( null);
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
        
    }
}