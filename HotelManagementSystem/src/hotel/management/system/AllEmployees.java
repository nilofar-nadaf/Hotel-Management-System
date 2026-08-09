package hotel.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class AllEmployees extends JFrame {

    JTable table;
    DefaultTableModel model;

    AllEmployees() {

        setTitle("Employee Information");
        setBounds(250,150,900,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("ALL EMPLOYEES");
        heading.setBounds(330,20,250,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);

        model = new DefaultTableModel();

        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("Job");
        model.addColumn("Salary");
        model.addColumn("Phone");
        model.addColumn("Email");
        model.addColumn("Aadhar");

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20,80,850,380);
        add(sp);

        JButton load = new JButton("Load Data");
        load.setBounds(220,500,120,30);
        add(load);

        JButton back = new JButton("Back");
        back.setBounds(520,500,120,30);
        add(back);

        load.addActionListener(e -> loadEmployees());

        back.addActionListener(e -> setVisible(false));

        loadEmployees();

        setVisible(true);
    }

    public void loadEmployees() {

        model.setRowCount(0);

        try {

            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("SELECT * FROM employee");

            while(rs.next()) {

                model.addRow(new Object[]{

                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("gender"),
                        rs.getString("job"),
                        rs.getString("salary"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("aadhar")

                });

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new AllEmployees();

    }
}