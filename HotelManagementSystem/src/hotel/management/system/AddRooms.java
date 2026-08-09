package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField tfroom, tfprice;
    JComboBox<String> available, cleaning, bedtype;
    JButton add, cancel;

    AddRooms() {

        setTitle("Add Room");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // ================= HEADING =================

        JLabel heading = new JLabel("ADD ROOM");
        heading.setBounds(120, 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);

        // ================= ROOM NUMBER =================

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(40, 70, 120, 25);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(170, 70, 150, 25);
        add(tfroom);

        // ================= AVAILABILITY =================

        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(40, 110, 120, 25);
        add(lblavailable);

        String avail[] = {
                "Available",
                "Occupied"
        };

        available = new JComboBox<>(avail);
        available.setBounds(170, 110, 150, 25);
        add(available);

        // ================= CLEANING STATUS =================

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(40, 150, 120, 25);
        add(lblclean);

        // IMPORTANT:
        // Database uses "Clean", not "Cleaned"

        String clean[] = {
                "Clean",
                "Dirty"
        };

        cleaning = new JComboBox<>(clean);
        cleaning.setBounds(170, 150, 150, 25);
        add(cleaning);

        // ================= PRICE =================

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(40, 190, 120, 25);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(170, 190, 150, 25);
        add(tfprice);

        // ================= BED TYPE =================

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(40, 230, 120, 25);
        add(lblbed);

        // Match database values
        String beds[] = {
                "Single",
                "Double",
                "Deluxe",
                "Suite"
        };

        bedtype = new JComboBox<>(beds);
        bedtype.setBounds(170, 230, 150, 25);
        add(bedtype);

        // ================= ADD BUTTON =================

        add = new JButton("ADD ROOM");
        add.setBounds(60, 300, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // ================= CANCEL BUTTON =================

        cancel = new JButton("CANCEL");
        cancel.setBounds(200, 300, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        // ================= ROOM IMAGE =================

        ImageIcon i1 =
                new ImageIcon(getClass().getResource("/icons/rooms.jpg"));

        Image i2 =
                i1.getImage().getScaledInstance(
                        400,
                        280,
                        Image.SCALE_SMOOTH
                );

        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(350, 40, 400, 280);
        add(image);

        // ================= FRAME =================

        setBounds(300, 150, 800, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // =====================================================
    // ACTION PERFORMED
    // =====================================================

    @Override
    public void actionPerformed(ActionEvent ae) {

        // ================= ADD ROOM =================

        if (ae.getSource() == add) {

            String room = tfroom.getText().trim();

            String avail =
                    (String) available.getSelectedItem();

            String clean =
                    (String) cleaning.getSelectedItem();

            String price = tfprice.getText().trim();

            String bed =
                    (String) bedtype.getSelectedItem();

            // ================= VALIDATION =================

            if (room.isEmpty() || price.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Room Number and Price"
                );

                return;
            }

            try {

                Conn conn = new Conn();

                // Check whether room already exists

                String checkQuery =
                        "SELECT * FROM room WHERE room_no = '"
                        + room + "'";

                var rs = conn.s.executeQuery(checkQuery);

                if (rs.next()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Room " + room + " already exists!"
                    );

                    return;
                }

                // ================= INSERT ROOM =================

                String query =
                        "INSERT INTO room " +
                        "(room_no, availability, cleaning_status, price, bed_type) " +
                        "VALUES ('"
                        + room + "','"
                        + avail + "','"
                        + clean + "','"
                        + price + "','"
                        + bed + "')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        this,
                        "Room Added Successfully!"
                );

                setVisible(false);

            } catch (Exception e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Error adding room"
                );
            }

        }

        // ================= CANCEL =================

        else if (ae.getSource() == cancel) {

            setVisible(false);
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        new AddRooms();

    }
}