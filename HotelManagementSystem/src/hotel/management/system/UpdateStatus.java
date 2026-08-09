package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStatus extends JFrame implements ActionListener {

    JComboBox<String> cbid;
    JComboBox<String> cbstatus;

    JButton update, cancel;

    UpdateStatus() {

        setTitle("Update Customer Status");
        setBounds(350, 180, 550, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ================= HEADING =================

        JLabel heading = new JLabel("UPDATE CUSTOMER STATUS");
        heading.setBounds(100, 25, 350, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        add(heading);

        // ================= CUSTOMER ID =================

        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(60, 90, 120, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblid);

        cbid = new JComboBox<>();

        // Load customer IDs from database
        try {

            Conn conn = new Conn();

            String query = "SELECT id FROM customer";

            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {

                cbid.addItem(rs.getString("id"));

            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    null,
                    "Unable to load customer IDs"
            );
        }

        cbid.setBounds(210, 90, 200, 25);
        add(cbid);

        // ================= STATUS =================

        JLabel lblstatus = new JLabel("Status");
        lblstatus.setBounds(60, 145, 120, 25);
        lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblstatus);

        String status[] = {
                "Checked In",
                "Checked Out"
        };

        cbstatus = new JComboBox<>(status);
        cbstatus.setBounds(210, 145, 200, 25);
        add(cbstatus);

        // ================= UPDATE BUTTON =================

        update = new JButton("UPDATE");
        update.setBounds(120, 220, 110, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.BOLD, 12));
        update.addActionListener(this);
        add(update);

        // ================= CANCEL BUTTON =================

        cancel = new JButton("CANCEL");
        cancel.setBounds(270, 220, 110, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    // =====================================================
    // ACTION PERFORMED
    // =====================================================

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == update) {

            // Check whether customer exists
            if (cbid.getSelectedItem() == null) {

                JOptionPane.showMessageDialog(
                        null,
                        "No customer found!"
                );

                return;
            }

            String id =
                    (String) cbid.getSelectedItem();

            String status =
                    (String) cbstatus.getSelectedItem();

            try {

                Conn conn = new Conn();

                String query =
                        "UPDATE customer SET " +
                        "status = '" + status + "' " +
                        "WHERE id = '" + id + "'";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Customer Status Updated Successfully!"
                );

                setVisible(false);

            } catch (Exception e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                        null,
                        "Error updating customer status"
                );
            }

        } else if (ae.getSource() == cancel) {

            setVisible(false);
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        new UpdateStatus();

    }
}