package hotel.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class CustomerInfo extends JFrame {

    JTable table;
    DefaultTableModel model;

    CustomerInfo() {

        setTitle("Customer Information");
        setBounds(220, 120, 1050, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("CUSTOMER INFORMATION");
        heading.setBounds(330, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        model = new DefaultTableModel();

        model.addColumn("ID Type");
        model.addColumn("ID Number");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Country");
        model.addColumn("Room No");
        model.addColumn("Check-In Time");
        model.addColumn("Deposit");

        table = new JTable(model);
        table.setRowHeight(25);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 80, 990, 380);
        add(sp);

        JButton load = new JButton("Load Data");
        load.setBounds(280, 500, 120, 30);
        add(load);

        JButton back = new JButton("Back");
        back.setBounds(600, 500, 120, 30);
        add(back);

        load.addActionListener(e -> loadCustomer());

        back.addActionListener(e -> setVisible(false));

        loadCustomer();

        setVisible(true);
    }

    public void loadCustomer() {

        model.setRowCount(0);

        try {

            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("SELECT * FROM customer");

            while (rs.next()) {

                model.addRow(new Object[] {

                        rs.getString("id_type"),
                        rs.getString("id_number"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("country"),
                        rs.getString("room_no"),
                        rs.getString("checkin_time"),
                        rs.getString("deposit")

                });

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}