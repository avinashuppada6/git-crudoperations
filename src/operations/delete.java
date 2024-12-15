package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.Set;

public class delete {
    
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/myschema1";
	private static final String username = "root";
	private static final String password = "root";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	public static void main(String[] args) {
		delete();
	}
	public static void delete() {
		try {
			
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
		    conn = DriverManager.getConnection(url,username,password);
	        System.out.println("enter table name");
	        String qry = " delete from " + sc.next() + " where name = ?";
	        pmst = conn.prepareStatement(qry);
	        System.out.println("enter name");
	        pmst.setString(1,sc.next());
	        int i = pmst.executeUpdate();
	        
	        if(i>0) {
	        	System.out.println("deleted name");
	        }
	   
	        else {
	        	System.out.println("not deleted");
	        }
	        conn.close();
	        pmst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
	}
}
    
    
    
