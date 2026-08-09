package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HotelMagementSystem extends JFrame implements ActionListener{

    HotelMagementSystem() {

        setSize(891, 506);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/home.jpg"));

        JLabel image = new JLabel(icon);
        image.setLayout(null);   // Allows absolute positioning

        JLabel heading = new JLabel("HOTEL MANAGEMENT SYSTEM");
        heading.setBounds(20, 20, 500, 40); // x, y, width, height
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);

        image.add(heading);
        
        JButton next = new JButton("Next");
        next.setBounds(720, 420, 120, 40); // x, y, width, height
        next.setFont(new Font("Tahoma", Font.BOLD, 18));
        next.setBackground(Color.white);
        next.addActionListener(this);
        image.add(next);

        add(image);
        setVisible(true);
        
        while (true) {
            heading.setVisible(false);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

            heading.setVisible(true);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();
		
	}
    public static void main(String[] args) {
        new HotelMagementSystem();
    }
}