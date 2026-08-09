package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JTextField tfUsername;
    JPasswordField pfPassword;
    JPasswordField pfConfirmPassword;

    JButton btnSignup;
    JButton btnCancel;

    Signup() {

        setTitle("Hotel Management System - Sign Up");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ================= HEADING =================

        JLabel heading = new JLabel("CREATE ACCOUNT");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(130, 20, 300, 30);
        add(heading);

        // ================= USERNAME =================

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblUsername.setBounds(50, 80, 120, 30);
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(200, 80, 220, 30);
        add(tfUsername);

        // ================= PASSWORD =================

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPassword.setBounds(50, 125, 120, 30);
        add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(200, 125, 220, 30);
        add(pfPassword);

        // ================= CONFIRM PASSWORD =================

        JLabel lblConfirm = new JLabel("Confirm Password");
        lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblConfirm.setBounds(50, 170, 140, 30);
        add(lblConfirm);

        pfConfirmPassword = new JPasswordField();
        pfConfirmPassword.setBounds(200, 170, 220, 30);
        add(pfConfirmPassword);

        // ================= SIGN UP =================

        btnSignup = new JButton("Sign Up");
        btnSignup.setBounds(110, 230, 120, 35);
        btnSignup.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignup.addActionListener(this);
        add(btnSignup);

        // ================= CANCEL =================

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(260, 230, 120, 35);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.addActionListener(this);
        add(btnCancel);

        setVisible(true);
    }

    // =====================================================
    // ACTION PERFORMED
    // =====================================================

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == btnSignup) {

            String username = tfUsername.getText().trim();

            String password =
                    new String(pfPassword.getPassword());

            String confirmPassword =
                    new String(pfConfirmPassword.getPassword());

            // ================= VALIDATION =================

            if (username.isEmpty() ||
                password.isEmpty() ||
                confirmPassword.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields"
                );

                return;
            }

            if (!password.equals(confirmPassword)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Passwords do not match"
                );

                return;
            }

            try {

                Conn c = new Conn();

                // Check if username already exists

                String checkQuery =
                        "SELECT * FROM login " +
                        "WHERE username='" + username + "'";

                var rs = c.s.executeQuery(checkQuery);

                if (rs.next()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Username already exists!"
                    );

                    return;
                }

                // Insert new user

                String query =
                        "INSERT INTO login VALUES('" +
                        username + "','" +
                        password + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        this,
                        "Account Created Successfully!"
                );

                setVisible(false);

            } catch (Exception e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Unable to create account"
                );
            }

        }

        else if (ae.getSource() == btnCancel) {

            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new Signup();

    }
}