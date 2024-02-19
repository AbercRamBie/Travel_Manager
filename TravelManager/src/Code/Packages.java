package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Packages extends JFrame implements ActionListener {

    JButton back,subscription,BuyPackage,Browse;
    JLabel labelusername , labelpackage , labelpersons , labelidno , labelphone  , labelprice,labelgender ;
    String username;
    ImageIcon e1;
    Image e2;
    ImageIcon e3;
    JLabel europe;
    public boolean europeSelected;

    Packages(){
        this.username = username;
        setLayout(null);
        getContentPane().setBackground(new Color(196, 207, 207));
        setBounds(300 , 200 , 850 , 600);
        
        e1 = new ImageIcon(ClassLoader.getSystemResource("icons/Europe.jpg"));
        e2 = e1.getImage().getScaledInstance(280,170,Image.SCALE_DEFAULT);
        e3 = new ImageIcon(e2);
        europe = new JLabel(e3);
        europe.setBounds(0,-300,400,900);
        add(europe);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/India.jpg"));
        Image i2 = i1.getImage().getScaledInstance(280,170,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel india = new JLabel(i3);
        india.setBounds(400,-300,400,900);
        add(india);

        ImageIcon s1 = new ImageIcon(ClassLoader.getSystemResource("icons/SouthEastAsia.jpg"));
        Image s2 = s1.getImage().getScaledInstance(280,170,Image.SCALE_DEFAULT);
        ImageIcon s3 = new ImageIcon(s2);
        JLabel southeastasia = new JLabel(s3);
        southeastasia.setBounds(0,-100,400,900);
        add(southeastasia);

        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icons/MiddleEast.jpg"));
        Image m2 = m1.getImage().getScaledInstance(280,170,Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m2);
        JLabel middleeast = new JLabel(m3);
        middleeast.setBounds(400,-100,400,900);
        add(middleeast);
      
        subscription = new JButton("Buy Membership");
        subscription.setBackground(Color.black);
        subscription.setForeground(Color.white);
        subscription.setBounds(80,480,150,25);
        subscription.addActionListener(this);
        add(subscription);

        BuyPackage = new JButton("Buy Package");
        BuyPackage.setBackground(Color.black);
        BuyPackage.setForeground(Color.white);
        BuyPackage.setBounds(250,480,150,25);
        BuyPackage.addActionListener(this);
        add(BuyPackage);

        Browse = new JButton("Browse Package");
        Browse.setBackground(Color.black);
        Browse.setForeground(Color.white);
        Browse.setBounds(420,480,150,25);
        Browse.addActionListener(this);
        add(Browse);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(590,480,150,25);
        back.addActionListener(this);
        add(back);

        try {

            Connect conn = new Connect();
            String  query = "select * from bookpackage where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                // labelusername.setText(rs.getString("username"));
                // labelpackage.setText(rs.getString("package"));
                // labelpersons.setText(rs.getString("person"));
                // labelid.setText(rs.getString("id"));
                // labelidno.setText(rs.getString("idnumber"));
                // labelphone.setText(rs.getString("phoneNo"));
                // labelprice.setText(rs.getString("price"));

            }
        }

        catch (Exception e){
            e.printStackTrace();;
        }

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back ){
            setVisible(false);
//            new Dashboard(username);
        }
        else if(ae.getSource() == subscription){
            setVisible(false);
            BookPackage bok = new BookPackage();
            bok.setVisible(true);
        }
        else if(ae.getSource() == BuyPackage){
            setVisible(false);
            Payment buy = new Payment();
            buy.setVisible(true);
        }
        else if(ae.getSource() == Browse){
            setVisible(false);
            Subscriptions sub = new Subscriptions();
            sub.setVisible(true);
        }
      
    }

    public static void main(String[] args) {
        new Packages();
    }


}

