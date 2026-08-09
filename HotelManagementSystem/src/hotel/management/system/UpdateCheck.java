package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame {

    Choice ccustomer;

    JTextField tfroom;
    JTextField tfname;
    JTextField tfcheckin;
    JTextField tfamountpaid;
    JTextField tfpending;

    JButton check, update, back;

    UpdateCheck() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Check Status");
        heading.setBounds(90, 20, 250, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 120, 25);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(180, 80, 150, 25);
        add(ccustomer);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 120, 25);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(180, 120, 150, 25);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 120, 25);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(180, 160, 150, 25);
        add(tfname);

        JLabel lblcheckin = new JLabel("Check-In Time");
        lblcheckin.setBounds(30, 200, 120, 25);
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(180, 200, 150, 25);
        add(tfcheckin);

        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(30, 240, 120, 25);
        add(lblpaid);

        tfamountpaid = new JTextField();
        tfamountpaid.setBounds(180, 240, 150, 25);
        add(tfamountpaid);

        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(30, 280, 120, 25);
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(180, 280, 150, 25);
        add(tfpending);

        check = new JButton("Check");
        check.setBounds(30, 340, 90, 30);
        add(check);

        update = new JButton("Update");
        update.setBounds(140, 340, 90, 30);
        add(update);

        back = new JButton("Back");
        back.setBounds(250, 340, 90, 30);
        add(back);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/reception.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 50, 500, 300);
        add(image);

        setBounds(300, 200, 950, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}