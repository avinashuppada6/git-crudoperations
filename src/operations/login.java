package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login {
	
   private static final String Driver ="com.mysql.cj.jdbc.Driver";
   private static final String  url = "jdbc:mysql://localhost:3306/myschema1";
   private static final String username ="root";
   private static final String password ="root";
   private static Connection conn;
   private static PreparedStatement pmst;
   
   public static void main(String[] args) {
	login();
}
   
   private static void login() {
	   try {
		   Scanner sc = new Scanner(System.in);
		   Class.forName(Driver);
		   conn = DriverManager.getConnection(url,username,password);
		   System.out.println("Enter mail");
		   String email=sc.next();
		   System.out.println("Enter paassword");
		   String password=sc.next();
	       String qry = "select * from myschema1.decp11 where email=? and password =? ";
	       pmst = conn.prepareStatement(qry);
	       pmst.setString(1, email);
	       pmst.setString(2, password);
	       ResultSet rs = pmst.executeQuery();
	       if(rs.next()) {
	    	   System.out.println("Login Successsful");
	       } else { 
	    	   System.out.println("Login not successful");
	       }
	       conn.close();
	       pmst.close();
	   }
	   catch (Exception e) {
		e.printStackTrace();
	}
   }
}
