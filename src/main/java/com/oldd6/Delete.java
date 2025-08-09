package com.oldd6;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Delete extends JFrame implements ActionListener{
    JLabel l, l2; JButton sub; JTextField tf;

    Delete(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 600);
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(new GridLayout(0,1));
        this.setIconImage(new ImageIcon("WEATHER.png").getImage());

        l = new JLabel("Deleting record");
        l.setFont(new Font("Roboto", Font.BOLD, 48));
        l.setForeground(Color.BLACK);
        l.setBackground(Color.GRAY);
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.TOP);
        this.add(l);

        l2 = new JLabel("Enter date:");
        l2.setFont(new Font("Roboto", Font.BOLD, 48));
        l2.setForeground(Color.BLACK);
        l2.setBackground(Color.GRAY);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setVerticalAlignment(JLabel.TOP);
        this.add(l2);

        tf = new JTextField();
        tf.setFont(new Font("Roboto", Font.BOLD, 48));
        tf.setForeground(Color.BLACK);
        tf.setBackground(Color.GRAY);
        tf.setHorizontalAlignment(JLabel.CENTER);
        this.add(tf);

        sub = new JButton("SUBMIT<-");
        sub.addActionListener(this);
        sub.setFont(new Font("Roboro", Font.BOLD, 48));
        sub.setForeground(Color.LIGHT_GRAY);
        sub.setBackground(Color.BLACK);
        this.add(sub);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sub){
            Session s = Main.sf.openSession();
            Transaction tr = s.beginTransaction();
            Weather wth = s.get(Weather.class, tf.getText());
            if(wth!=null) s.delete(wth);
            tr.commit();
            s.close();
        }
    }

}