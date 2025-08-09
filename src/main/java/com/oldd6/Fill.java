package com.oldd6;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class Fill extends JFrame implements ActionListener {

    JLabel l, l2, l3, l4, l5;
    JTextField tf, tf2, tf3, tf4;
    JButton sub;


    Fill() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 800);
        this.getContentPane().setBackground(Color.GRAY);
        this.setIconImage(new ImageIcon("WEATHER.png").getImage());
        this.setLayout(new GridLayout(0, 1));

        l = new JLabel("Enter info:");
        l.setFont(new Font("Roboto", Font.BOLD, 48));
        l.setForeground(Color.BLACK);
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.TOP);

        this.add(l);

        l2 = new JLabel("Temperature (°C):");
        l2.setFont(new Font("Roboto", Font.BOLD, 36));
        l2.setForeground(Color.BLACK);
        this.add(l2);

        tf = new JTextField();
        tf.setFont(new Font("Roboto", Font.BOLD, 36));
        tf.setForeground(Color.BLACK);
        this.add(tf);

        l3 = new JLabel("Wind (km/h):");
        l3.setFont(new Font("Roboto", Font.BOLD, 36));
        l3.setForeground(Color.BLACK);
        this.add(l3);

        tf2 = new JTextField();
        tf2.setFont(new Font("Roboto", Font.BOLD, 36));
        tf2.setForeground(Color.BLACK);
        this.add(tf2);

        l4 = new JLabel("Air quality:");
        l4.setFont(new Font("Roboto", Font.BOLD, 36));
        l4.setForeground(Color.BLACK);
        this.add(l4);

        tf3 = new JTextField();
        tf3.setFont(new Font("Roboto", Font.BOLD, 36));
        tf3.setForeground(Color.BLACK);
        this.add(tf3);

        l5 = new JLabel("DATE:");
        l5.setFont(new Font("Roboto", Font.BOLD, 36));
        l5.setForeground(Color.BLACK);
        this.add(l5);

        tf4 = new JTextField();
        tf4.setFont(new Font("Roboto", Font.BOLD, 36));
        tf4.setForeground(Color.BLACK);
        this.add(tf4);

        sub = new JButton("SUBMIT<=");
        sub.setFont(new Font("Roboto", Font.BOLD, 36));
        sub.setForeground(Color.BLACK);
        sub.setBackground(Color.GRAY);
        sub.addActionListener(this);
        this.add(sub);

        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            Weather wth = new Weather(tf4.getText(), Integer.parseInt(tf.getText()),
                    Integer.parseInt(tf2.getText()), tf3.getText());

            Session s = Main.sf.openSession();
            Transaction tr = s.beginTransaction();
            s.persist(wth);
            tr.commit();
            s.close();
        }
    }
}