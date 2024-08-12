import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        JFrame frame = new JFrame("Expense Calculator");
        

        JLabel expenseLabel = new JLabel("Expenses:");
        expenseLabel.setForeground(Color.RED);
        expenseLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
        expenseLabel.setBounds(140, 20, 120, 50);
        frame.add(expenseLabel);
        


        JLabel expenseTypeLabel = new JLabel("Expense Type:");
        expenseTypeLabel.setBounds(20, 70, 120, 50);
        frame.add(expenseTypeLabel);

        JTextField expenseTypeField = new JTextField("");
        expenseTypeField.setBounds(140, 80, 120, 30);
        frame.add(expenseTypeField);

        JLabel expenseAmountLabel = new JLabel("Expense Amount:");
        expenseAmountLabel.setBounds(20, 100, 120, 50);
        frame.add(expenseAmountLabel);

        JTextField expenseAmountField = new JTextField();
        expenseAmountField.setBounds(140, 110, 120, 30);
        frame.add(expenseAmountField);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setBounds(140, 140, 120, 50);
        incomeLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
        frame.add(incomeLabel);
        incomeLabel.setForeground(Color.GREEN);

        JLabel incomeAmountLabel = new JLabel("Income Amount:");
        incomeAmountLabel.setBounds(20, 180, 120, 50);
        frame.add(incomeAmountLabel);



        JTextField incomeField = new JTextField("");
        incomeField.setBounds(140, 190, 120, 30);
        frame.add(incomeField);

        JButton addbutton = new JButton("ADD");
        addbutton.setBounds(50, 250, 110, 40);
        addbutton.setBackground(Color.GREEN);
        frame.add(addbutton);

        JButton viewbutton = new JButton("VIEW");
        viewbutton.setBounds(160, 250, 110, 40);
        frame.add(viewbutton);

        String url = "jdbc:mysql://localhost:3306/ExpenseCalculator";
                    String username = "root";
                    String password = "";
                    try{
                        connection = DriverManager.getConnection(url, username, password);
                        System.out.println("DB Connected");
                    }
                    catch(SQLException e1){
                        throw new RuntimeException(e1+"not connected");
                    }
                    

        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               // Add the validation of empty form
                String expensetype = expenseTypeField.getText();
                int expenseAmount = expenseAmountField.getText().isEmpty()?0:Integer.valueOf(expenseAmountField.getText());
                if(expenseAmount!=0 && !expensetype.isEmpty()){
               //Insert record to mySQL
                    
                String insertdata= "INSERT INTO expenseTB  (expense_type, expense_amount, income) VALUES (?,?,?)";
                    try{
                    PreparedStatement statement = connection.prepareStatement(insertdata);
                    statement.setString(1, expensetype);
                    statement.setInt(2, expenseAmount);
                    statement.setInt(3, Integer.parseInt(incomeField.getText()));
                statement.execute();
                } catch(SQLException ex){
                     throw new RuntimeException(ex);

                 }
                 }

                 else{
                     JOptionPane.showMessageDialog(null, "The values can't be 0 or  empty");
                 }
            }
        });
        
        


        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);



    }

}
