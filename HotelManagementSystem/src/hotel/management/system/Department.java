package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Department extends JFrame {

    JTable table;
    DefaultTableModel model;

    Department() {

        setTitle("Department");
        setBounds(350, 150, 700, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("DEPARTMENT");
        heading.setBounds(250, 20, 250, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        model = new DefaultTableModel();
        model.addColumn("Department");
        model.addColumn("Budget");

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(40, 80, 600, 280);
        add(sp);

        JButton load = new JButton("Load");
        load.setBounds(180, 390, 100, 30);
        add(load);

        JButton back = new JButton("Back");
        back.setBounds(380, 390, 100, 30);
        add(back);

        load.addActionListener(e -> loadDepartment());

        back.addActionListener(e -> setVisible(false));

        loadDepartment();

        setVisible(true);
    }

    public void loadDepartment() {

        model.setRowCount(0);

        try {

            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("SELECT * FROM department");

            while (rs.next()) {

                model.addRow(new Object[] {
                        rs.getString("department"),
                        rs.getString("budget")
                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Department();
    }
}