package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;

public class Paytm extends JFrame implements  ActionListener {
    JButton back;
    Paytm(){

        setBounds(300 , 100 , 530 , 650);


        JEditorPane j = new JEditorPane();
        j.setEnabled(false);

        try{

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Offline Merchant.png"));
            Image i2 = i1.getImage().getScaledInstance(450 , 500 , Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(30 ,-10,450,600);
            j.add(image);

        }
        catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }

        // add Scroll bar
        JScrollPane scrollPane = new JScrollPane(j);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(200 , 550 , 100 , 30);
        back.addActionListener(this);
        j.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Payment su = new Payment();
        su.setVisible(true);
    }
}
