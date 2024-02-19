package Code;

// lecture 8
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener {

    JButton Signup,Login,Packages,Subscriptions,Payment,Booking,Billing , viewPersonalDetails , updatePersonalDetails , checkpackages , bookPackages , deletePersonalDetails;
    JButton logout , HomePage ,calculator , about , payment , Destinations , viewBookedHotels  , bookHotels , viewHotels ,viewPackages;
    String username;
    
    DashBoard(){
        this.username = username;
//    setBounds(0,0,1250,700);
       setExtendedState(JFrame.MAXIMIZED_BOTH); // to fit according to my screen
    setLayout(null);

    JPanel p1 = new JPanel();
    p1.setLayout(null);
    p1.setBackground(new Color(0 , 0 ,102));
    p1.setBounds(0,0,1400 , 65);
    add(p1);

    JLabel heading = new JLabel("Dashboard");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 40));
        heading.setBounds(650, 5, 500, 50);
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0 , 0 ,102));
        p2.setBounds(0,65,300 , 900);
        add(p2);

        Signup = new JButton("Sign Up");
        Signup.setBounds(0,0,300,50);
        Signup.setBackground( new Color( 0,0,102));
        Signup.setForeground(Color.WHITE);
        Signup.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        Signup.setMargin( new Insets(0,0,0,55));
        Signup.addActionListener(this);
        p2.add(Signup);

        Login = new JButton("Login");
        Login.setBounds(0,50,300,50);
        Login.setBackground( new Color( 0,0,102));
        Login.setForeground(Color.WHITE);
        Login.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        Login.setMargin( new Insets(0,0,0,55));
        Login.addActionListener(this);
        p2.add(Login);   
        
        HomePage = new JButton("Home");
        HomePage.setBounds(0,100,300,50);
        HomePage.setBackground( new Color( 0,0,102));
        HomePage.setForeground(Color.WHITE);
        HomePage.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        HomePage.setMargin( new Insets(0,0,0,55));
        HomePage.addActionListener(this);
        p2.add(HomePage);

        Booking = new JButton("Book Packages");
        Booking.setBounds(0,150,300,50);
        Booking.setBackground( new Color( 0,0,102));
        Booking.setForeground(Color.WHITE);
        Booking.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        Booking.setMargin( new Insets(0,0,0,55));
        Booking.addActionListener(this);
        p2.add(Booking);

        payment = new JButton("Payments");
        payment.setBounds(0,200,300,50);
        payment.setBackground( new Color( 0,0,102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        payment.setMargin( new Insets(0,0,0,55));
        payment.addActionListener(this);
        p2.add(payment);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(250, 50, 1150, 700);
        add(NewLabel);

        JLabel l1 = new JLabel("Travel Management System");
        l1.setForeground(new Color(162, 48, 124));
        l1.setFont(new Font("Tahoma", Font.BOLD, 45));
        l1.setBounds(300, 350, 1000, 55);
        NewLabel.add(l1);

        setVisible(true);
        
        // checkpackages = new JButton("Packages");
        // checkpackages.setBounds(0,200,300,50);
        // checkpackages.setBackground( new Color( 0,0,102));
        // checkpackages.setForeground(Color.WHITE);
        // checkpackages.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        // checkpackages.setMargin( new Insets(0,0,0,110));
        // checkpackages.addActionListener(this);
        // p2.add(checkpackages);

        // bookPackages = new JButton("Book Packages");
        // bookPackages.setBounds(0,250,300,50);
        // bookPackages.setBackground( new Color( 0,0,102));
        // bookPackages.setForeground(Color.WHITE);
        // bookPackages.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        // bookPackages.setMargin( new Insets(0,0,0,110));
        // bookPackages.addActionListener(this);
        // p2.add(bookPackages);

        //  viewPackages = new JButton("View Booked Package");
        // viewPackages.setBounds(0,300,350,50);
        // viewPackages.setBackground( new Color( 0,0,102));
        // viewPackages.setForeground(Color.WHITE);
        // viewPackages.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        // viewPackages.setMargin( new Insets(0,0,0,110));
        // viewPackages.addActionListener(this);
        // p2.add(viewPackages);

        //  viewHotels = new JButton("View Hotels");
        // viewHotels.setBounds(0,350,300,50);
        // viewHotels.setBackground( new Color( 0,0,102));
        // viewHotels.setForeground(Color.WHITE);
        // viewHotels.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        // viewHotels.setMargin( new Insets(0,0,0,150));
        // viewHotels.addActionListener(this);
        // p2.add(viewHotels);

        // bookHotels = new JButton("Booked Hotels");
        // bookHotels.setBounds(0,400,300,50);
        // bookHotels.setBackground( new Color( 0,0,102));
        // bookHotels.setForeground(Color.WHITE);
        // bookHotels.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        // bookHotels.setMargin( new Insets(0,0,0,130));
        // bookHotels.addActionListener(this);
        // p2.add(bookHotels);

        // viewBookedHotels = new JButton("View  Booked Hotels");
        // viewBookedHotels.setBounds(-7,450,350,50);
        // viewBookedHotels.setBackground( new Color( 0,0,102));
        // viewBookedHotels.setForeground(Color.WHITE);
        // viewBookedHotels.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        // viewBookedHotels.setMargin( new Insets(0,0,0,110));
        // viewBookedHotels.addActionListener(this);
        // p2.add(viewBookedHotels);

        //  Destinations = new JButton("Destinations");
        // Destinations.setBounds(0,500,300,50);
        // Destinations.setBackground( new Color( 0,0,102));
        // Destinations.setForeground(Color.WHITE);
        // Destinations.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        // Destinations.setMargin( new Insets(0,0,0,155));
        // Destinations.addActionListener(this);
        // p2.add(Destinations);

                
        // calculator = new JButton("Calculator");
        // calculator.setBounds(0,550,300,50);
        // calculator.setBackground( new Color( 0,0,102));
        // calculator.setForeground(Color.WHITE);
        // calculator.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
        // calculator.setMargin( new Insets(0,0,0,175));
        // calculator.addActionListener(this);
        // p2.add(calculator);

//         about = new JButton("About");
//         about.setBounds(0,600,300,40);
//         about.setBackground( new Color( 0,0,102));
//         about.setForeground(Color.WHITE);
//         about.setFont(new Font( "Tohoma" , Font.PLAIN , 20) );
//         about.setMargin( new Insets(0,0,0,195));
//         about.addActionListener(this);
//         p2.add(about);

//         JLabel showname = new JLabel("Welcome "+username+"");
//         showname.setBounds(600 , 15 , 500 , 35);
//         showname.setForeground(Color.white);
//         showname.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 35));
// //        showname.setFont(new Font("Raleway" , Font.BOLD , 35));
//         p1.add(showname);

//          logout = new JButton("Logout");
//         logout.setForeground(Color.ORANGE );
//         logout.setBackground( new Color( 0,0,102));
//         logout.setBounds(1000 , 15 , 200 , 45);
//         logout.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
//         logout.addActionListener(this);
//         logout.setMargin(new Insets(0 , 0 , 0 , 0));
//         p1.add(logout);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Signup){
            new Signup();
        }
        else if( ae.getSource() == Login){           
            new Login("").setVisible(true);;
        }
        else if( ae.getSource() == Subscriptions){
            new Subscriptions().setVisible(true);
        }
        else if( ae.getSource() == Booking){
            new BookPackage();
        }
        else if( ae.getSource() ==  HomePage){
            new Packages();
        }
        else if( ae.getSource() == payment){
         new Payment();
            try {
                Runtime.getRuntime().exec("calc.exe");
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // else if( ae.getSource() == about  ){
        //         new About();
        // }
        // else if( ae.getSource() == deletePersonalDetails ){
        //         new DeleteCustomerDetails(username);
        // }
    }

    public static void main(String[] args) {
        new DashBoard().setVisible(true);;
    }
}


