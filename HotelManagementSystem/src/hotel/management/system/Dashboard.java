package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    Dashboard() {

        setTitle("Hotel Management System");
        setSize(891, 506);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(
                getClass().getResource("/icons/dashboard.jpg")
        );

        Image img = i1.getImage().getScaledInstance(
                891, 506, Image.SCALE_SMOOTH
        );

        ImageIcon i2 = new ImageIcon(img);

        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 891, 506);
        image.setLayout(null);

        JLabel heading = new JLabel("THE TAJ GROUP WELCOMES YOU!!!");
        heading.setBounds(180, 20, 600, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        image.add(heading);

        add(image);

        // ================= MENU BAR =================

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // ================= HOTEL MANAGEMENT =================

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        menuBar.add(hotel);

        // Reception
        JMenuItem reception = new JMenuItem("Reception");

        reception.addActionListener(e -> {
            new Reception();
        });

        hotel.add(reception);

        // Logout
        JMenuItem logout = new JMenuItem("Logout");

        logout.addActionListener(e -> {

            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                setVisible(false);
                new Login();
            }
        });

        hotel.add(logout);

        // ================= ADMIN =================

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        menuBar.add(admin);

        // Add Employee
        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");

        addEmployee.addActionListener(e -> {
            new AddEmployee();
        });

        admin.add(addEmployee);

        // Add Rooms
        JMenuItem addRooms = new JMenuItem("ADD ROOMS");

        addRooms.addActionListener(e -> {
            new AddRooms();
        });

        admin.add(addRooms);

        // Add Drivers
        JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");

        addDrivers.addActionListener(e -> {
            new AddDriver();
        });

        admin.add(addDrivers);

        // ================= FRAME =================

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}