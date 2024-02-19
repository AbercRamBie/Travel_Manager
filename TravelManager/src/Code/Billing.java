package Code;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import java.util.Random;

public class Billing extends JFrame implements ActionListener {
    
    JTextField tfName , tfNumber ,tfpackage, tfmembers,tfdiscountapplied,tfphone,tftotalamount;
    JLabel lblName , lblNumber ,lblpackage, lblmembers,lbldiscountapplied,lblphone,lbltotalamount;
    JButton exitapplication, backtomainpage;
 
    Billing(){

        setSize(560,750);
        setLocation(220,120);

        //Details 
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(450,0,450,600);
        p2.setBackground(Color.LIGHT_GRAY);
        add(p2);

        lblName = new JLabel("Name :");
        lblName.setBounds(60 ,70,200,25);
        lblName.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(220,70, 300 , 30);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        //tfName.setBackground(getForeground());
        p2.add(tfName);

        lblNumber = new JLabel("Number :");
        lblNumber.setBounds(60 ,140,200,25);
        lblNumber.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(220,140, 300 , 30);
        tfNumber.setBorder(BorderFactory.createEmptyBorder());
        //tfNumber.setBackground(getForeground());
        p2.add(tfNumber);

        lblpackage = new JLabel("Package :");
        lblpackage.setBounds(60 ,200,200,25);
        lblpackage.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
         p2.add(lblpackage);

        tfpackage = new JTextField();
        tfpackage.setBounds(220,200, 300 , 30);
        tfpackage.setBorder(BorderFactory.createEmptyBorder());
        //tfpackage.setBackground(getForeground());
        p2.add(tfpackage);

        lblphone = new JLabel("Phone No :");
        lblphone.setBounds(60 ,270,200,25);
        lblphone.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220,340, 300 , 30);
        tfphone.setBorder(BorderFactory.createEmptyBorder());
        //tfphone.setBackground(getForeground());
        p2.add(tfphone);

        lblmembers = new JLabel("Members :");
        lblmembers.setBounds(60 ,340,200,25);
        lblmembers.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblmembers);

        tfmembers = new JTextField();
        tfmembers.setBounds(220,270, 300 , 30);
        tfmembers.setBorder(BorderFactory.createEmptyBorder());
        //tfmembers.setBackground(getForeground());
        p2.add(tfmembers);

        lbldiscountapplied = new JLabel("Discount :");
        lbldiscountapplied.setBounds(60 ,410,200,25);
        lbldiscountapplied.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lbldiscountapplied);

        tfdiscountapplied = new JTextField();
        tfdiscountapplied.setBounds(220,410, 300 , 30);
        tfdiscountapplied.setBorder(BorderFactory.createEmptyBorder());
        //tfdiscountapplied.setBackground(getForeground());
        p2.add(tfdiscountapplied);

        lbltotalamount = new JLabel("Total Amount :");
        lbltotalamount.setBounds(60 ,480,200,25);
        lbltotalamount.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lbltotalamount);

        tftotalamount = new JTextField();
        tftotalamount.setBounds(220,480, 300 , 30);
        tftotalamount.setBorder(BorderFactory.createEmptyBorder());
        //tftotalamount.setBackground(getForeground());
        p2.add(tftotalamount);

        //Buttons

        backtomainpage = new JButton("Explore");
        backtomainpage.setBounds(100,590 , 120,35);
        backtomainpage.setBackground(new Color( 133, 193,233)); // background colour change
        backtomainpage.setForeground(Color.BLACK);  // font background
        backtomainpage.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        backtomainpage.addActionListener(this);
        p2.add(backtomainpage);

        exitapplication = new JButton("Exit");
        exitapplication.setBounds(300,590 , 120,35);
        exitapplication.setBackground(new Color( 133, 193,233)); // background colour change
        exitapplication.setForeground(Color.BLACK);  // font background
        exitapplication.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        exitapplication.addActionListener(this);
        p2.add(exitapplication);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String  username = tfName.getText();
        if(e.getSource() == backtomainpage){
            setVisible(false);
            Packages pkg = new Packages();
            pkg.setVisible(true);            
        }
        else if(e.getSource() == exitapplication){

            System.exit(2);
            
        }

    }

    public static void main(String[] args) {
        
        new Billing().setVisible(true);

    }


}
