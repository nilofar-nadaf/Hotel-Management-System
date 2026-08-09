package hotel.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox<String> cbAvailability;
    JComboBox<String> cbCleaning;
    JComboBox<String> cbPrice;
    JComboBox<String> cbBed;

    JTable table;
    DefaultTableModel model;
    JButton search, back;

    SearchRoom() {

        setTitle("Search Room");
        setBounds(250, 120, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("SEARCH ROOM");
        heading.setBounds(310, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        // Availability
        JLabel lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(20, 70, 80, 25);
        add(lblAvailability);

        cbAvailability = new JComboBox<>();
        cbAvailability.addItem("All");
        cbAvailability.addItem("Available");
        cbAvailability.addItem("Occupied");
        cbAvailability.setBounds(100, 70, 100, 25);
        add(cbAvailability);

        // Cleaning Status
        JLabel lblCleaning = new JLabel("Cleaning");
        lblCleaning.setBounds(230, 70, 70, 25);
        add(lblCleaning);

        cbCleaning = new JComboBox<>();
        cbCleaning.addItem("All");
        cbCleaning.addItem("Clean");
        cbCleaning.addItem("Dirty");
        cbCleaning.setBounds(300, 70, 100, 25);
        add(cbCleaning);

        // Price
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(430, 70, 50, 25);
        add(lblPrice);

        cbPrice = new JComboBox<>();
        cbPrice.addItem("All");
        cbPrice.addItem("2500");
        cbPrice.addItem("3000");
        cbPrice.addItem("3500");
        cbPrice.addItem("4500");
        cbPrice.addItem("6000");
        cbPrice.setBounds(480, 70, 100, 25);
        add(cbPrice);

        // Bed Type
        JLabel lblBed = new JLabel("Bed Type");
        lblBed.setBounds(610, 70, 70, 25);
        add(lblBed);

        cbBed = new JComboBox<>();
        cbBed.addItem("All");
        cbBed.addItem("Single");
        cbBed.addItem("Double");
        cbBed.addItem("Deluxe");
        cbBed.addItem("Suite");
        cbBed.setBounds(680, 70, 120, 25);
        add(cbBed);

        // Table
        model = new DefaultTableModel();

        model.addColumn("Room No");
        model.addColumn("Availability");
        model.addColumn("Cleaning Status");
        model.addColumn("Price");
        model.addColumn("Bed Type");

        table = new JTable(model);
        table.setRowHeight(25);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 120, 840, 340);
        add(sp);

        // Buttons at Bottom
        search = new JButton("Search");
        search.setBounds(280, 500, 120, 35);
        search.addActionListener(this);
        add(search);

        back = new JButton("Back");
        back.setBounds(450, 500, 120, 35);
        back.addActionListener(this);
        add(back);

        loadRooms();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void loadRooms() {

        model.setRowCount(0);

        try {

            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("SELECT * FROM room");

            while (rs.next()) {

                model.addRow(new Object[]{

                        rs.getString("room_no"),
                        rs.getString("availability"),
                        rs.getString("cleaning_status"),
                        rs.getString("price"),
                        rs.getString("bed_type")

                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {

            model.setRowCount(0);

            try {

                Conn conn = new Conn();

                String query = "SELECT * FROM room WHERE 1=1";

                if (!cbAvailability.getSelectedItem().equals("All")) {
                    query += " AND availability LIKE '%" + cbAvailability.getSelectedItem() + "%'";
                }

                if (!cbCleaning.getSelectedItem().equals("All")) {
                    query += " AND cleaning_status LIKE '%" + cbCleaning.getSelectedItem() + "%'";
                }

                if (!cbPrice.getSelectedItem().equals("All")) {
                    query += " AND price LIKE '%" + cbPrice.getSelectedItem() + "%'";
                }

                if (!cbBed.getSelectedItem().equals("All")) {
                    query += " AND bed_type LIKE '%" + cbBed.getSelectedItem() + "%'";
                }
                ResultSet rs = conn.s.executeQuery(query);

                while (rs.next()) {

                    model.addRow(new Object[]{

                            rs.getString("room_no"),
                            rs.getString("availability"),
                            rs.getString("cleaning_status"),
                            rs.getString("price"),
                            rs.getString("bed_type")

                    });

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {

            setVisible(false);

        }

    }

    public static void main(String[] args) {

        new SearchRoom();

    }
}