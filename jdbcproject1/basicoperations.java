package jdbcproject1;

import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class basicoperations {

	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/myschema1";
	private static final String username = "root";
	private static final String password = "root";
	private static Connection conn;
	private static PreparedStatement pmst;

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		int reply ;
		do {
			getdetails();
			reply = Integer.parseInt(sc.next());
			switch (reply) {
			case 1: 
				loginuser();
                break;
		    case 2:
		    	registeruser();
		    	break;
		    case 3:
		    	adduser();
		    	break;
		    case 4 :
		    	deleteuser();
		    	break;
		    case 5 :
		    	modifyuser();
		    	break;
		    case 6 	:
		    	getall();
		    	break;
		    case 7 :
		    	getbyid();
		    	break;
		    case 8:
		    	getbyemail();
		    	break;
		    case 9:
		    	System.exit(0);
			default:
				System.out.println("invalid operstion choosed");
				break;
			}
			
		} while (reply > 0);
	     System.out.println("errors occured");
      }
	
   //getbyemial
	private static void getbyemail(){
			try {
				
				Scanner sc = new Scanner(System.in);
				Class.forName(Driver);
				conn =DriverManager.getConnection(url,username,password);
				System.out.print("enter table name");
				String sql = "select * from " + sc.next() + "where email=?";
				pmst = conn.prepareStatement(sql);
				System.out.println("enter email");
				pmst.setString(1, sc.next());
				ResultSet rs = pmst.executeQuery();
				while (rs.next()) {
				  System.out.println("id :" +rs.getInt("id"));
                  System.out.println("email :" +rs.getString("email"));
                  System.out.println("name :" +rs.getString("name"));
				  System.out.println("password :" +rs.getString("password"));	
				}
				pmst.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("errors are occured");
  			 }
		}
	
	// get by id 
	
	private static void getbyid() {
		try {
			
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter table name");
			String sql = "select * from " +sc.next() + " where id=? ";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter email");
			pmst.setInt(1,sc.nextInt());
			ResultSet rs = pmst.executeQuery();
		    
			while (rs.next()) {
                System.out.println("id :" + rs.getInt("id"));
                System.out.println("name :" +rs.getString("name"));
                System.out.println("email :" +rs.getString("email"));
                System.out.println("password :" +rs.getString("password"));				
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error occured");
		}
	}
	
	//getall
	
	private static void getall() {
		
try {
			
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter table name");
			String sql = "select * from " +sc.next();
			pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
		    
			while (rs.next()) {
                System.out.println("id :" + rs.getInt("id"));
                System.out.println("name :" +rs.getString("name"));
                System.out.println("email :" +rs.getString("email"));
                System.out.println("password :" +rs.getString("password"));				
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error occured");
		}
		
	}
	
	// loginuser
	private static void loginuser() {
          try {
        	  Scanner sc = new Scanner(System.in);
  			Class.forName(Driver);
  			conn = DriverManager.getConnection(url,username,password);
  			System.out.println("enter table name");
  			String sql = "select * from " + sc.next() + " where email=?,password=? ";
  			System.out.println("enter email");
  			pmst.setString(1, sc.next());
  			System.out.println("enter password");
  			pmst.setString(2, sc.next());
  			pmst = conn.prepareStatement(sql);
  			ResultSet rs = pmst.executeQuery();
        	if (rs.next()) {
				System.out.println("login successful");
			} else {
				System.out.println("login not successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errors occured");
		}
	}
	
	//modifyuser
	
	private static void modifyuser() {
		
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
			System.out.println("errors occured");
		}
		
	}
	
	//deleteuser
	
	private static void deleteuser() {
		
		
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
			System.out.println("error occured");
			e.printStackTrace();
		}
	}
	
	//adduser
	
	private static void adduser() {
		
		try {
			
Scanner scr = new Scanner(System.in);
            
           
            Class.forName(Driver);
            
           
            conn = DriverManager.getConnection(url, username, password);
            
           
            String sql = "INSERT INTO decp11(name, email, password) VALUES (?, ?, ?)";
            pmst = conn.prepareStatement(sql);
            
           
            System.out.println("Enter name:");
            pmst.setString(1, scr.nextLine());
            
            System.out.println("Enter email:");
            pmst.setString(2, scr.nextLine());
            
            System.out.println("Enter password:");
            pmst.setString(3, scr.nextLine());
            
            // Execute the query
            int i = pmst.executeUpdate();
            if (i > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Error in data insertion.");
            }
            
            // Close resources
            pmst.close();
            conn.close();
            scr.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error occured");
		}
		
	}

	//register user
	
     private static void registeruser() {
		
    	 try {
			
    		 Scanner sc = new Scanner(System.in);
			  Class.forName(Driver);
			  conn = DriverManager.getConnection(url,username,password);
			  String qry = "insert into decp11(name,email,password) values(?,?,?)";
			  pmst =conn.prepareStatement(qry);
			  System.out.println("enter name");
			  pmst.setString(1,sc.next());
			  System.out.println("enter email");
			  pmst.setString(2, sc.next());;
			  System.out.println("entrer password");
			  pmst.setString(3, sc.next());
			  int i = pmst.executeUpdate();
			  if(i >0) {
				  System.out.println("data successfully inserted");  
				  
			  }
			  else {
				  System.out.println("data is not inserted");
			  }
			  conn.close();
			  pmst.close();
    		 
		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println("errors occured");
		}
	}
     
    //get details 
     
    private static void getdetails() {
		
    	System.out.println("wwelcome to yogafor life");
    	System.out.println("choose your intrest");
    	System.out.println("");
    	System.out.println("\t 1.login");
    	System.out.println("\t 2.registeruser");
    	System.out.println("\t 3.adduser");
    	System.out.println("\t 4.deleteuser");
    	System.out.println("\t 5.modifyuser");
        System.out.println("\t 6.getalluserdetils");   
        System.out.println("\t 7.getbyid");
        System.out.println("\t 8.getbyemail");
        System.out.println("\t 9.exit");
        System.out.println("");
	}      
}



 