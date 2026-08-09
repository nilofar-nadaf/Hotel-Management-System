package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;

public class Checkout extends JFrame implements ActionListener {

    Choice customerChoice;
    JTextField tfRoom, tfCheckIn, tfCheckOut;
    JButton checkout, back;

    Checkout() {

        setTitle("Checkout");
        setBounds(350, 150, 700, 450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("CHECKOUT");
        heading.setBounds(270, 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        JLabel lblCustomer = new JLabel("Customer ID");
        lblCustomer.setBounds(50, 80, 120, 25);
        add(lblCustomer);

        customerChoice = new Choice();
        customerChoice.setBounds(180, 80, 180, 25);
        add(customerChoice);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT id_number FROM customer");

            while (rs.next()) {
                customerChoice.add(rs.getString("id_number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(50, 130, 120, 25);
        add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(180, 130, 180, 25);
        tfRoom.setEditable(false);
        add(tfRoom);

        JLabel lblCheckIn = new JLabel("Check-In");
        lblCheckIn.setBounds(50, 180, 120, 25);
        add(lblCheckIn);

        tfCheckIn = new JTextField();
        tfCheckIn.setBounds(180, 180, 180, 25);
        tfCheckIn.setEditable(false);
        add(tfCheckIn);

        JLabel lblCheckOut = new JLabel("Check-Out");
        lblCheckOut.setBounds(50, 230, 120, 25);
        add(lblCheckOut);

        tfCheckOut = new JTextField(LocalDateTime.now().toString());
        tfCheckOut.setBounds(180, 230, 180, 25);
        tfCheckOut.setEditable(false);
        add(tfCheckOut);

        checkout = new JButton("Checkout");
        checkout.setBounds(80, 310, 120, 30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBounds(240, 310, 120, 30);
        back.addActionListener(this);
        add(back);

        loadCustomerDetails();

        customerChoice.addItemListener(e -> loadCustomerDetails());

        setVisible(true);
    }

    public void loadCustomerDetails() {

        try {

            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery(
                    "SELECT * FROM customer WHERE id_number='"
                            + customerChoice.getSelectedItem() + "'");

            if (rs.next()) {

                tfRoom.setText(rs.getString("room_no"));
                tfCheckIn.setText(rs.getString("checkin_time"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == checkout) {

            String room = tfRoom.getText();
            String id = customerChoice.getSelectedItem();

            try {

                Conn conn = new Conn();

                conn.s.executeUpdate(
                        "UPDATE room SET availability='Available' WHERE room_no='" + room + "'");

                conn.s.executeUpdate(
                        "DELETE FROM customer WHERE id_number='" + id + "'");

                JOptionPane.showMessageDialog(null,
                        "Customer Checked Out Successfully");

                setVisible(false);

            } catch (Exception e) {

                e.printStackTrace();

            }

        } else {

            setVisible(false);

        }

    }

    public static void main(String[] args) {

        new Checkout();

    }
}