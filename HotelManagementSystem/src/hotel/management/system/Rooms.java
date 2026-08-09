package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Rooms extends JFrame {

    JTable table;
    DefaultTableModel model;

    Rooms() {

        setTitle("Room Details");
        setBounds(250, 120, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("ROOM DETAILS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(330, 20, 250, 30);
        add(heading);

        model = new DefaultTableModel();

        model.addColumn("Room No");
        model.addColumn("Availability");
        model.addColumn("Cleaning Status");
        model.addColumn("Price");
        model.addColumn("Bed Type");

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30, 80, 820, 380);
        add(sp);

        JButton load = new JButton("Load Data");
        load.setBounds(250, 490, 120, 30);
        add(load);

        JButton back = new JButton("Back");
        back.setBounds(480, 490, 120, 30);
        add(back);

        load.addActionListener(e -> loadRooms());

        back.addActionListener(e -> setVisible(false));

        setVisible(true);
    }

    private void loadRooms() {

        model.setRowCount(0);

        try {

            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("SELECT * FROM room");

            while(rs.next()) {

                model.addRow(new Object[]{

                        rs.getString("room_no"),
                        rs.getString("availability"),
                        rs.getString("cleaning_status"),
                        rs.getString("price"),
                        rs.getString("bed_type")

                });

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new Rooms();

    }
}