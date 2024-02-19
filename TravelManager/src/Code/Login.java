package Code;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException; 

public class Login extends JFrame implements ActionListener {
    public JButton password , login , signup;
    public JTextField  tfusername , tfpassword ;
//      String username;
        Login(String usernamee){
        setSize(900 , 400);
        setLocation(220 , 120);

        setLayout(null); // mot want to use swing layout
//        getContentPane().setBackground(Color.white);conn = DriverManager.getConnection(url);  

        // left pannel
        JPanel p1 = new JPanel();
        p1.setBackground(new Color( 131,193,233));
        p1.setBounds( 0 , 0 , 450 , 400);  // location on pannel
        p1.setLayout(null);
        add(p1);

// PUT image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200 , 200 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120 ,85,200,200);
        p1.add(image);

        // RIGHT PANEL
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(450,0,450,400);
        p2.setBackground(Color.LIGHT_GRAY);
        add(p2);

        //  Text Pannel or Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60 ,30,100,25);
        lblusername.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblusername);

        // input box , textfield
        tfusername = new JTextField();
        tfusername.setBounds(60,70, 300 , 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        //password
        //  Text Pannel or Label
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60 ,120,100,25);
        lblpassword.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblpassword);

        // input box , textfield -> fill usrername
        tfpassword = new JTextField();
        tfpassword.setBounds(60,160, 300 , 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        // creat Buttons for login
        login = new JButton("Login");
        login.setBounds(60,220 , 120,35);
        login.setBackground(new Color( 133, 193,233)); 
        login.setForeground(Color.BLACK);  
        login.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        login.addActionListener(this);
        p2.add(login);

        // creat Buttons for Signup
        signup = new JButton("Signup");
        signup.setBounds(240,220 , 120,35);
        signup.setBackground(new Color( 133, 193,233)); 
        signup.setForeground(Color.BLACK);  
        signup.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        signup.addActionListener(this);
        p2.add(signup);

        // creat Buttons for Signup
        password = new JButton("Forget Password");
        password.setBounds(150,280 , 120,35);
        password.setBackground(new Color( 133, 193,233)); 
        password.setForeground(Color.BLACK);  
        password.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        password.addActionListener(this);
        p2.add(password);

        // side message
        JLabel text = new JLabel("Incorrect credentials.Please Check!");
        text.setBounds(280 ,290,120,20);
        text.setForeground(Color.RED);
        text.setFont(new Font("SAN_SERIF" , Font.PLAIN, 15));
        p2.add(text);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
           
                    try{
                        String username = tfusername.getText();
                        String pass = tfpassword.getText();
            
                        String query = "select * from UserDetails where username =  '"+ username+"' AND password ='"+pass+"'  ";
                        Connect c = new Connect();
                        ResultSet rs = c.s.executeQuery(query);
                        if(rs.next()){
                            setVisible(false);  
                            DashBoard su = new DashBoard();
                            su.setVisible(true);                              
                        }
                        else{
                            JOptionPane.showMessageDialog(null , "Incorrect username or password");
                        }
            
                    }
                    catch(Exception ae){
                        ae.printStackTrace();
                    }
            
            
                    }
                    else if( e.getSource() == signup){
                        setVisible(false);
                        Signup su = new Signup();
                        su.setVisible(true);
                    }
                   
        }

    static class Conn{
        private Connection connection;

        public Conn(String url, String username, String password){
            try {
                Class.forName("com.mysql.jdbc.Driver"); // Adjust for your driver
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        public Connection gConnection(){
            return connection;
        }

        public void closeConnection() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Login("").setVisible(true);
    }

}
