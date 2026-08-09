package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tfUsername;
    JPasswordField pfPassword;

    JButton btnLogin;
    JButton btnCancel;
    JButton btnSignup;

    Login() {

        setTitle("Hotel Management System - Login");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // ================= HEADING =================

        JLabel heading = new JLabel("LOGIN");
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        heading.setBounds(190, 20, 150, 30);
        add(heading);

        // ================= USERNAME =================

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(50, 80, 100, 30);
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(170, 80, 220, 30);
        add(tfUsername);

        // ================= PASSWORD =================

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(50, 130, 100, 30);
        add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(170, 130, 220, 30);
        add(pfPassword);

        // ================= LOGIN =================

        btnLogin = new JButton("Login");
        btnLogin.setBounds(40, 200, 120, 35);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogin.addActionListener(this);
        add(btnLogin);

        // ================= CANCEL =================

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(180, 200, 120, 35);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.addActionListener(this);
        add(btnCancel);

        // ================= SIGN UP =================

        btnSignup = new JButton("Sign Up");
        btnSignup.setBounds(320, 200, 120, 35);
        btnSignup.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignup.addActionListener(this);
        add(btnSignup);

        setVisible(true);
    }

    // =====================================================
    // ACTION PERFORMED
    // =====================================================

    @Override
    public void actionPerformed(ActionEvent ae) {

        // ================= LOGIN =================

        if (ae.getSource() == btnLogin) {

            String user = tfUsername.getText().trim();
            String password =
                    new String(pfPassword.getPassword());

            if (user.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter username and password"
                );

                return;
            }

            try {

                Conn c = new Conn();

                String query =
                        "SELECT * FROM login " +
                        "WHERE username='" + user +
                        "' AND password='" + password + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Login Successful!"
                    );

                    setVisible(false);

                    new Dashboard();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Username or Password"
                    );
                }

            } catch (Exception e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Database Error"
                );
            }
        }

        // ================= CANCEL =================

        else if (ae.getSource() == btnCancel) {

            System.exit(0);
        }

        // ================= SIGN UP =================

        else if (ae.getSource() == btnSignup) {

            new Signup();

        }
    }

    public static void main(String[] args) {

        new Login();

    }
}