import Utility.CustomVariables;
import Utility.UtilityMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Main {
    static String bookingId;
    static JTextField username_field, date_of_journey_field, age_field, source_field,  gender_field,destination_field, email_field, ticket_price_field, mobile_field, seat_field, deleteBookingIdField;
    static boolean isUpdate = true;
    public static void main(String[] args) {
        
        //store the url,username,password in string object of database

        //createRailwayBookingFrame in java
        createRailwayBooking();
    }

    private static void createRailwayBooking() {
        CustomVariables.databaseUrl ="jdbc:mysql://localhost:3306/Railwaybookingdb";
        CustomVariables.username="root";
        CustomVariables.password="";

        try {
            UtilityMethods.createConnection(CustomVariables.databaseUrl,
                    CustomVariables.username, CustomVariables.password);

            JFrame frame=new JFrame("Railway Booking System");

            JLabel personal_label=new JLabel("Personal Details");
            personal_label.setBounds(10,10,120,30);
            frame.add(personal_label);

            JLabel ticket_details_label=new JLabel("Ticket Details");
            ticket_details_label.setBounds(310,10,120,30);
            frame.add(ticket_details_label);

            JLabel username_label=new JLabel("Add Username");
            username_label.setBounds(10,50,120,30);
            frame.add(username_label);

            username_field=new JTextField();
            username_field.setBounds(130,50,100,30);
            frame.add(username_field);

            JLabel date_of_journey_label=new JLabel("Date Of Journey");
            date_of_journey_label.setBounds(310,50,120,30);
            frame.add(date_of_journey_label);

            date_of_journey_field=new JTextField();
            date_of_journey_field.setBounds(430,50,100,30);
            frame.add(date_of_journey_field);


            JLabel age_label=new JLabel("Add Age");
            age_label.setBounds(10,80,120,30);
            frame.add(age_label);

            age_field=new JTextField();
            age_field.setBounds(130,80,100,30);
            frame.add(age_field);

            JLabel source_label=new JLabel("Source");
            source_label.setBounds(310,80,120,30);
            frame.add(source_label);

            source_field=new JTextField();
            source_field.setBounds(430,80,100,30);
            frame.add(source_field);


            JLabel gender_label=new JLabel("Add Gender");
            gender_label.setBounds(10,110,120,30);
            frame.add(gender_label);

            gender_field=new JTextField();
            gender_field.setBounds(130,110,100,30);
            frame.add(gender_field);

            JLabel destination_label=new JLabel("Enter Destination");
            destination_label.setBounds(310,110,120,30);
            frame.add(destination_label);

            destination_field=new JTextField();
            destination_field.setBounds(430,110,100,30);
            frame.add(destination_field);

            JLabel email_label=new JLabel("Add Email:");
            email_label.setBounds(10,140,120,30);
            frame.add(email_label);

            email_field=new JTextField();
            email_field.setBounds(130,140,100,30);
            frame.add(email_field);

            JLabel ticket_price_label=new JLabel("Enter Ticket Price:");
            ticket_price_label.setBounds(310,140,120,30);
            frame.add(ticket_price_label);

            ticket_price_field=new JTextField();
            ticket_price_field.setBounds(430,140,100,30);
            frame.add(ticket_price_field);

            JLabel mobile_label=new JLabel("Add Mobile:");
            mobile_label.setBounds(10,170,120,30);
            frame.add(mobile_label);

            mobile_field=new JTextField();
            mobile_field.setBounds(130,170,100,30);
            frame.add(mobile_field);

            JLabel seat_label=new JLabel("Seat Preference:");
            seat_label.setBounds(310,170,120,30);
            frame.add(seat_label);

            seat_field=new JTextField();
            seat_field.setBounds(430,170,100,30);
            frame.add(seat_field);


            JButton bookButton = new JButton("Book Ticket");
            bookButton.setBounds(30,220,120,30);
            frame.add(bookButton);

            //delete button to delete the data
            JButton deleteButton = new JButton("Delete Ticket");
            deleteButton.setBounds(140,220,120,30);
            frame.add(deleteButton);

            //update the booking
            JButton updateButton = new JButton("Update Ticket");
            updateButton.setBounds(260,220,120,30);
            frame.add(updateButton);


            frame.setSize(600,500);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.ORANGE);
           
            //update the booking
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isUpdate)
                    {
                        bookingId= JOptionPane.showInputDialog("Enter Booking id to Update");
                        fetchBooking(bookingId);  
                        isUpdate = false;
                    }
                    else{
                        updateBooking(bookingId);
                    }
                    
                    
                }
            });


            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    if (bookButton.isVisible())
//                    {
//
//                        //to hide the insert form
//                        email_field.setVisible(false);
//                        email_label.setVisible(false);
//                        mobile_label.setVisible(false);
//                        mobile_field.setVisible(false);
//                        age_label.setVisible(false);
//                        age_field.setVisible(false);
//                        gender_label.setVisible(false);
//                        gender_field.setVisible(false);
//                        ticket_price_field.setVisible(false);
//                        ticket_price_label.setVisible(false);
//                        seat_label.setVisible(false);
//                        seat_field.setVisible(false);
//                        username_label.setVisible(false);
//                        username_field.setVisible(false);
//                        source_label.setVisible(false);
//                        source_field.setVisible(false);
//                        destination_label.setVisible(false);
//                        destination_field.setVisible(false);
//                        date_of_journey_label.setVisible(false);
//                        date_of_journey_field.setVisible(false);
//                        bookButton.setVisible(false);
//
//                        JLabel deleteBookingIdLabel = new JLabel("Booking Id");
//                        deleteBookingIdLabel.setBounds(70, 70, 150, 40);
//                        frame.add(deleteBookingIdLabel);
//
//                        deleteBookingIdField = new JTextField();
//                        deleteBookingIdField.setBounds(150, 70, 150, 40);
//                        frame.add(deleteBookingIdField);
//                    }else {
//                        deleteBooking();
//                    }

                    //2 methods using Joptionpane
                    String booking = JOptionPane.showInputDialog("Enter the booking Id");
                    deleteBooking(booking);

                }
            });

            bookButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //book the user ticket
                    try {
                        insertBookingIntoDB();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });




            // update the data in database.
//            String updateQuery="update ticketbookingtb set username=?,gender=?,age=? where id=?";
//            PreparedStatement ps =CustomVariables.connection.prepareStatement(updateQuery);
//            ps.setString(1,"Anjali");
//            ps.setString(2,"female");
//            ps.setInt(3,20);
//            ps.setInt(4,2);
//            ps.execute();
//            System.out.println("Record has been updated");

            // delet the data form table
//            String deleteQuery="delete from ticketbookingtb where id=? ";
//            PreparedStatement ps =connection.prepareStatement(deleteQuery);
//            ps.setInt(1,3);
//            ps.execute();
//            System.out.println(" one record is deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);


        }
    }

    private static void fetchBooking(String bookingId) {
        //to select the data from database
        String selectQuery = "select * from ticketbookingtb where id = ?";
        try {
            PreparedStatement preparedStatement = CustomVariables.connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, Integer.parseInt(bookingId));
            ResultSet rs = preparedStatement.executeQuery();

            while ( rs.next())
            {
                username_field.setText(rs.getString("username"));
                mobile_field.setText(rs.getString("mobile"));
                age_field.setText(rs.getString("age"));
                date_of_journey_field.setText(rs.getString("doj"));
                email_field.setText(rs.getString("email"));
                gender_field.setText(rs.getString("gender"));
                source_field.setText(rs.getString("source"));
                destination_field.setText(rs.getString("destination"));
                ticket_price_field.setText(rs.getString("ticketprice"));
                seat_field.setText(rs.getString("seatpreference"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateBooking(String bookingId) {
    

        String updateQuery = "update ticketbookingtb set username = ?,age = ?,gender = ?, mobile = ?,email = ?,doj= ?,source=?,destination=?,ticketprice=?,seatpreference= ? where id = ?  ";
        try {
            PreparedStatement ps = CustomVariables.connection.prepareStatement(updateQuery);
            ps.setString(1, username_field.getText());
            ps.setInt(2, Integer.parseInt(age_field.getText()));
            ps.setString(3, gender_field.getText());
            ps.setString(4, mobile_field.getText());
            ps.setString(5, email_field.getText());
            ps.setString(6, date_of_journey_field.getText());
            ps.setString(7, source_field.getText());
            ps.setString(8, destination_field.getText());
            ps.setString(9, ticket_price_field.getText());
            ps.setString(10, seat_field.getText());
            ps.setInt(11, Integer.parseInt(bookingId));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "ticket updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteBooking(String bookingId) {
        String deleteQuery = "delete from ticketbookingtb where id = ?";
        try {
            PreparedStatement ps = CustomVariables.connection.prepareStatement(deleteQuery);
            ps.setInt(1, Integer.parseInt(bookingId));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Booking deleted");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertBookingIntoDB() throws SQLException {
        String insertQuery="insert into ticketbookingtb(username,age,gender, mobile,email,doj,source,destination,ticketprice,seatpreference ) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=CustomVariables.connection.prepareStatement(insertQuery);
        ps.setString(1,username_field.getText());
        ps.setInt(2, Integer.parseInt(age_field.getText()));
        ps.setString(3,gender_field.getText());
        ps.setString(4,mobile_field.getText());
        ps.setString(5,email_field.getText());
        ps.setString(6,date_of_journey_field.getText());
        ps.setString(7,source_field.getText());
        ps.setString(8,destination_field.getText());
        ps.setString(9,ticket_price_field.getText());
        ps.setString(10,seat_field.getText());
        ps.execute();

        JOptionPane.showMessageDialog(null,
                "Booking has been confirmed");
        //to clear the form
        clearForm();
    }

    private static void clearForm() {
        //to clear the form using Jtextfield
        username_field.setText("");
        email_field.setText("");
        age_field.setText("");
        gender_field.setText("");
        mobile_field.setText("");
        date_of_journey_field.setText("");
        source_field.setText("");
        destination_field.setText("");
        seat_field.setText("");
        ticket_price_field.setText("");
    }
}
