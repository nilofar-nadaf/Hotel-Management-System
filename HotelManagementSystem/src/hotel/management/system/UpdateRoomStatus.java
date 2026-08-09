package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoomStatus extends JFrame implements ActionListener {

    JComboBox<String> cbroomnumber;
    JComboBox<String> cbavailability;
    JComboBox<String> cbcleaningstatus;

    JButton update, cancel;

    UpdateRoomStatus() {

        setTitle("Update Room Status");
        setBounds(350, 200, 500, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ================= HEADING =================

        JLabel heading = new JLabel("UPDATE ROOM STATUS");
        heading.setBounds(130, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        // ================= ROOM NUMBER =================

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(50, 80, 120, 25);
        add(lblroom);

        cbroomnumber = new JComboBox<>();

        try {

            Conn conn = new Conn();

            String query = "SELECT room_no FROM room";

            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                cbroomnumber.addItem(rs.getString("room_no"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cbroomnumber.setBounds(200, 80, 180, 25);
        add(cbroomnumber);

        // ================= AVAILABILITY =================

        JLabel lblavailability = new JLabel("Availability");
        lblavailability.setBounds(50, 130, 120, 25);
        add(lblavailability);

        String availability[] = {
            "Available",
            "Occupied"
        };

        cbavailability = new JComboBox<>(availability);
        cbavailability.setBounds(200, 130, 180, 25);
        add(cbavailability);

        // ================= CLEANING STATUS =================

        JLabel lblcleaning = new JLabel("Cleaning Status");
        lblcleaning.setBounds(50, 180, 120, 25);
        add(lblcleaning);

        String cleaning[] = {
            "Clean",
            "Dirty"
        };

        cbcleaningstatus = new JComboBox<>(cleaning);
        cbcleaningstatus.setBounds(200, 180, 180, 25);
        add(cbcleaningstatus);

        // ================= UPDATE =================

        update = new JButton("UPDATE");
        update.setBounds(100, 240, 110, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        // ================= CANCEL =================

        cancel = new JButton("CANCEL");
        cancel.setBounds(250, 240, 110, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == update) {

            String roomNo =
                    (String) cbroomnumber.getSelectedItem();

            String availability =
                    (String) cbavailability.getSelectedItem();

            String cleaningStatus =
                    (String) cbcleaningstatus.getSelectedItem();

            try {

                Conn conn = new Conn();

                String query =
                    "UPDATE room SET " +
                    "availability = '" + availability + "', " +
                    "cleaning_status = '" + cleaningStatus + "' " +
                    "WHERE room_no = '" + roomNo + "'";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                    null,
                    "Room Status Updated Successfully"
                );

                setVisible(false);

            } catch (Exception e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                    null,
                    "Error updating room status"
                );
            }

        } else if (ae.getSource() == cancel) {

            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateRoomStatus();
    }
}