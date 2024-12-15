package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/myschema1";
	private static final String username = "root";
	private static final String password = "root";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
		    Class.forName(Driver);
		    conn = DriverManager.getConnection(url,username,password);
		    System.out.println("enter table name");
		    String tablename = sc.next();
            String sql = "UPDATE " + tablename + " SET id=?,name=?,email=?,password=? WHERE id=?";
		    pmst = conn.prepareStatement(sql);
		    System.out.println("enter id to midify");
		    pmst.setInt(1, sc.nextInt());
		    System.out.println("enter name to modify");
		    pmst.setString(2, sc.next());
		    System.out.println("enter email to modify");
		    pmst.setString(3, sc.next());
		    System.out.println("enter password to modify");
		    pmst.setString(4, sc.next());
		    System.out.println("enter the id to modify");
		    pmst.setInt(5, sc.nextInt());
		    int i = pmst.executeUpdate();
		     
	       if (i>0) {
			System.out.println("id values updated successfully");
		}
	       else {
			System.out.println("id vlaues are not updated");
		}
	    pmst.close();
	    conn.close();
	    sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
