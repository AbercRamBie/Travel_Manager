package Code;

import java.sql.*;

public class Connect {
   Connection c;
   public Statement s;
    Connect(){
        try{

            Class.forName("org.sqlite.JDBC"); //// check it further
//            Class.forName("com.mysql.jdbc.Driver"); //// check it further
            c =DriverManager.getConnection("jdbc:sqlite:d:\\TravelManager\\src\\TravelManagerDB.db");
//            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","MySQL");
            s =c.createStatement();
        }catch(Exception e){
           e.printStackTrace();
        }
    }
}
