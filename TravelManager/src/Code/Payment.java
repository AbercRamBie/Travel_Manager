package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
    JButton bank, scan , back ;
    Payment(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(300 , 100 , 650 , 450);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650 , 450 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-100 ,-100,850,650);
        add(image);

        bank = new JButton("Bank");
        bank.setForeground(Color.white);
        bank.setBackground(Color.black);
        bank.setBounds(500 , 190 , 100 , 30);
        bank.addActionListener(this);
        image.add(bank);

        scan = new JButton("Scan");
        scan.setForeground(Color.white);
        scan.setBackground(Color.black);
        scan.setBounds(500 , 260 , 100 , 30);
        scan.addActionListener(this);
        image.add(scan);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(500 , 330 , 100 , 30);
        back.addActionListener(this);
        image.add(back);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Payment();
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back ){
            setVisible(false);
        }
        else if(ae.getSource() == bank ){
            setVisible(false);
            Banking bk = new Banking();
            bk.setVisible(true);
        }
        else if(ae.getSource() == scan ){
            setVisible(false);
            Paytm qr = new Paytm();
            qr.setVisible(true);
        }
    }
}