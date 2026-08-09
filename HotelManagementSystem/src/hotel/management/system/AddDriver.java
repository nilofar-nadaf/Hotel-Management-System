package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfcarcompany, tfcarmodel, tflocation;
    JComboBox<String> cbgender, cbavailable;
    JButton add, cancel;

    AddDriver() {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("ADD DRIVER");
        heading.setBounds(150, 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);

        // Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 70, 100, 25);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(170, 70, 150, 25);
        add(tfname);

        // Age
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(40, 110, 100, 25);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(170, 110, 150, 25);
        add(tfage);

        // Gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(40, 150, 100, 25);
        add(lblgender);

        String gender[] = {"Male", "Female"};

        cbgender = new JComboBox<>(gender);
        cbgender.setBounds(170, 150, 150, 25);
        add(cbgender);

        // Car Company
        JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setBounds(40, 190, 100, 25);
        add(lblcompany);

        tfcarcompany = new JTextField();
        tfcarcompany.setBounds(170, 190, 150, 25);
        add(tfcarcompany);

        // Car Model
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setBounds(40, 230, 100, 25);
        add(lblmodel);

        tfcarmodel = new JTextField();
        tfcarmodel.setBounds(170, 230, 150, 25);
        add(tfcarmodel);

        // Available
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(40, 270, 100, 25);
        add(lblavailable);

        String available[] = {"Available", "Unavailable"};

        cbavailable = new JComboBox<>(available);
        cbavailable.setBounds(170, 270, 150, 25);
        add(cbavailable);

        // Location
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(40, 310, 100, 25);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(170, 310, 150, 25);
        add(tflocation);

        // ADD Button
        add = new JButton("ADD");
        add.setBounds(70, 380, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // CANCEL Button
        cancel = new JButton("CANCEL");
        cancel.setBounds(200, 380, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        // Driver Image
        ImageIcon i1 = new ImageIcon(
                getClass().getResource("/icons/driver.jpg")
        );

        Image i2 = i1.getImage().getScaledInstance(
                300,
                350,
                Image.SCALE_SMOOTH
        );

        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(380, 50, 300, 350);
        add(image);

        // Frame settings
        setBounds(300, 150, 750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            String name = tfname.getText();
            String age = tfage.getText();

            String gender =
                    (String) cbgender.getSelectedItem();

            String company = tfcarcompany.getText();
            String model = tfcarmodel.getText();

            // Get selected Available value
            String available =
                    (String) cbavailable.getSelectedItem();

            String location = tflocation.getText();

            try {

                Conn conn = new Conn();

                String query =
                        "insert into driver values('" +
                        name + "','" +
                        age + "','" +
                        gender + "','" +
                        company + "','" +
                        model + "','" +
                        available + "','" +
                        location + "')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Driver Added Successfully"
                );

                setVisible(false);

            } catch (Exception e) {

                e.printStackTrace();

            }

        } else if (ae.getSource() == cancel) {

            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new AddDriver();

    }
}