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

public class Banking extends JFrame implements ActionListener {
    
    JTextField tfcardnumber , tfpin, tfotp;
    JLabel lblcardnumber, lblpin, lblotp,lblErrorMessage;
    JButton generateotp, makepayment, backButton;
    String otpmessage = "";
    String TextinTextField = "";
    Banking(){
        setSize(650,450);
        setLocation(220,120);

        //Details 
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(450,0,450,600);
        p2.setBackground(Color.LIGHT_GRAY);
        add(p2);

        lblcardnumber = new JLabel("Card Number :");
        lblcardnumber.setBounds(60 ,70,200,25);
        lblcardnumber.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblcardnumber);

        tfcardnumber = new JTextField();
        tfcardnumber.setBounds(220,70, 300 , 30);
        tfcardnumber.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfcardnumber);

        lblpin = new JLabel("PIN :");
        lblpin.setBounds(156 ,150,200,25);
        lblpin.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        p2.add(lblpin);

        tfpin = new JTextField();
        tfpin.setBounds(220,150, 300 , 30);
        tfpin.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpin);

        lblotp = new JLabel("OTP :");
        lblotp.setBounds(156 ,220,200,25);
        lblotp.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        lblotp.setVisible(false);
        p2.add(lblotp);

        tfotp = new JTextField();
        tfotp.setBounds(220,220, 300 , 30);
        tfotp.setBorder(BorderFactory.createEmptyBorder());
        tfotp.setVisible(false);
        p2.add(tfotp);

        lblErrorMessage = new JLabel("");
        lblErrorMessage.setBounds(220 ,250,200,25);
        lblErrorMessage.setFont(new Font("SAN_SERIF" , Font.PLAIN, 22));
        lblErrorMessage.setVisible(false);
        p2.add(lblErrorMessage);

        // Buttons

        generateotp = new JButton("Generate OTP");
        generateotp.setBounds(100,290 , 120,35);
        generateotp.setBackground(new Color( 133, 193,233)); // background colour change
        generateotp.setForeground(Color.BLACK);  // font background
        generateotp.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        generateotp.addActionListener(this);
        p2.add(generateotp);

        makepayment = new JButton("Confirm");
        makepayment.setBounds(250,290 , 120,35);
        makepayment.setBackground(new Color( 133, 193,233)); // background colour change
        makepayment.setForeground(Color.BLACK);  // font background
        makepayment.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        makepayment.addActionListener(this);
        p2.add(makepayment);

        backButton = new JButton("Back");
        backButton.setBounds(400,290 , 120,35);
        backButton.setBackground(new Color( 133, 193,233)); // background colour change
        backButton.setForeground(Color.BLACK);  // font background
        backButton.setBorder(new LineBorder( new Color(133 , 193 ,233)));
        backButton.addActionListener(this);
        p2.add(backButton);

    }

    public static String generateOTP(int otpLength)
	{
		Random random=new Random();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0 ; i< otpLength ; i++)
		{
			sb.append(random.nextInt(10));
		}
		
		String otp=sb.toString();
		
		return otp;
	}

    public static void sendOTP(String message , String number , String apiKey)
	{
		try
		{
		String sendId="FSTSMS";
		String language="english";
		String route="otp";
		
		message=URLEncoder.encode(message,"UTF-8");    //Important Step
		
		String myUrl="https://www.fast2sms.com/dev/bulkV2="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
    
		URL url=new URL(myUrl);
		HttpsURLConnection con= (HttpsURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent","Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		
		int responseCode=  con.getResponseCode();
		
		StringBuffer response=new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line=br.readLine();
			
			if(line==null)
			{
				break;
			}
			
			response.append(line);
		}
		
		System.out.println(response);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        TextinTextField = tfotp.getText();

        if(e.getSource() == generateotp){

           lblotp.setVisible(true);
           tfotp.setVisible(true);
		   
		   otpmessage=generateOTP(5);

		   System.out.println( "Generate OTP : "+ otpmessage);
		   
		   String apiKey="iC9EzbmLh0W4rdNf53k7aAeqvPyHGInZDoXlsxjOVURJw8STYcGk2CHasZywc0jgrInPOfbF7VUME6K9";
		   String number="+91 8012728937";
		   
		   sendOTP("Hey this message is send by Subash using Java Code. Your OTP is :"+otpmessage,number,apiKey);

        }
        else if(e.getSource() == makepayment){
            if(otpmessage != TextinTextField&&TextinTextField.length()==0){
                lblErrorMessage.setVisible(true);
                lblErrorMessage = new JLabel("Incorrect OTP");
            }
            else{
                setVisible(false);
                Billing bg = new Billing();
                bg.setVisible(true);
            }
        }
        else if(e.getSource() == backButton){
            setVisible(false);
            Payment su = new Payment();
            su.setVisible(true);
        }

    }
    public static void main(String[] args) {

        new Banking().setVisible(true);
        
    }

}

