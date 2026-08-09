package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhar;
    JRadioButton male, female;
    JComboBox<String> cbjob;
    JButton submit;

    AddEmployee() {

        setLayout(null);

        JLabel heading = new JLabel("ADD EMPLOYEE");
        heading.setBounds(240, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(40, 80, 100, 25);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(150, 80, 150, 25);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(40, 120, 100, 25);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(150, 120, 150, 25);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(40, 160, 100, 25);
        add(lblgender);

        male = new JRadioButton("Male");
        male.setBounds(150, 160, 70, 25);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(230, 160, 80, 25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(40, 200, 100, 25);
        add(lbljob);

        String jobs[] = {
                "Front Desk Clerk",
                "Porter",
                "Housekeeping",
                "Chef",
                "Manager",
                "Accountant"
        };

        cbjob = new JComboBox<>(jobs);
        cbjob.setBounds(150, 200, 150, 25);
        add(cbjob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(40, 240, 100, 25);
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(150, 240, 150, 25);
        add(tfsalary);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(40, 280, 100, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(150, 280, 150, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(40, 320, 100, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(150, 320, 150, 25);
        add(tfemail);

        JLabel lblaadhar = new JLabel("AADHAAR");
        lblaadhar.setBounds(40, 360, 100, 25);
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(150, 360, 150, 25);
        add(tfaadhar);

        submit = new JButton("SUBMIT");
        submit.setBounds(120, 420, 120, 30);
        submit.addActionListener(this);
        add(submit);

        // Employee Image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/employees.jpg"));
        Image i2 = i1.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 100, 280, 280);
        add(image);

        getContentPane().setBackground(Color.WHITE);

        setBounds(350, 150, 700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String name = tfname.getText();
        String age = tfage.getText();

        String gender = "";
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        try {

            Conn conn = new Conn();

            String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee Added Successfully");

            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}