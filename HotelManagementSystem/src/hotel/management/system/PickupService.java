package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PickupService extends JFrame implements ActionListener {

    JTextField tfcustomer, tfpickup, tfdrop;
    JComboBox<String> cbdriver;
    JButton assign, cancel;

    PickupService() {

        setTitle("Pickup Service");
        setBounds(350, 150, 550, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ================= HEADING =================

        JLabel heading = new JLabel("PICKUP SERVICE");
        heading.setBounds(170, 20, 250, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);

        // ================= CUSTOMER NAME =================

        JLabel lblcustomer = new JLabel("Customer Name");
        lblcustomer.setBounds(50, 80, 120, 25);
        add(lblcustomer);

        tfcustomer = new JTextField();
        tfcustomer.setBounds(200, 80, 220, 25);
        add(tfcustomer);

        // ================= PICKUP LOCATION =================

        JLabel lblpickup = new JLabel("Pickup Location");
        lblpickup.setBounds(50, 130, 120, 25);
        add(lblpickup);

        tfpickup = new JTextField();
        tfpickup.setBounds(200, 130, 220, 25);
        add(tfpickup);

        // ================= DROP LOCATION =================

        JLabel lbldrop = new JLabel("Drop Location");
        lbldrop.setBounds(50, 180, 120, 25);
        add(lbldrop);

        tfdrop = new JTextField();
        tfdrop.setBounds(200, 180, 220, 25);
        add(tfdrop);

        // ================= DRIVER =================

        JLabel lbldriver = new JLabel("Select Driver");
        lbldriver.setBounds(50, 230, 120, 25);
        add(lbldriver);

        String drivers[] = {
                "Rahul",
                "Amit",
                "Sameer",
                "Not Assigned"
        };

        cbdriver = new JComboBox<>(drivers);
        cbdriver.setBounds(200, 230, 220, 25);
        add(cbdriver);

        // ================= ASSIGN BUTTON =================

        assign = new JButton("ASSIGN");
        assign.setBounds(120, 300, 110, 30);
        assign.setBackground(Color.BLACK);
        assign.setForeground(Color.WHITE);
        assign.addActionListener(this);
        add(assign);

        // ================= CANCEL BUTTON =================

        cancel = new JButton("CANCEL");
        cancel.setBounds(270, 300, 110, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    // ================= ACTION PERFORMED =================

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == assign) {

            String customer = tfcustomer.getText();
            String pickup = tfpickup.getText();
            String drop = tfdrop.getText();

            String driver =
                    (String) cbdriver.getSelectedItem();

            if (customer.isEmpty() ||
                pickup.isEmpty() ||
                drop.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Please enter all details"
                );

                return;
            }

            if (driver.equals("Not Assigned")) {

                JOptionPane.showMessageDialog(
                        null,
                        "Please select a driver"
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Pickup Service Assigned Successfully!\n\n" +
                    "Customer: " + customer + "\n" +
                    "Driver: " + driver + "\n" +
                    "Pickup: " + pickup + "\n" +
                    "Drop: " + drop
            );

            setVisible(false);

        } else if (ae.getSource() == cancel) {

            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new PickupService();

    }
}