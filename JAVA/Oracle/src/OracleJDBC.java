import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class OracleJDBC {
private static Connection conn = null;

//******************************************************
public static void 	ask () throws Exception
	
	{try {
	java.sql.Statement s= conn.createStatement();
	ResultSet rs = s.executeQuery("SELECT NOM FROM DB1.T1");
	
	System.out.println("**************Resultats**************");

    while ( rs.next() ) {
        String all = rs.getString("NOM");
        System.out.print(all+"\n");
    
       
    }
        conn.close();
    } catch (Exception e) {
        System.err.println("exception! ");
        System.err.println(e.getMessage());
    }
	
	
	}

//****************************************************** 
	public static void main(String[] argv) throws Exception {
 
		System.out.println("--- Test de Connection Oracle JDBC---");
 
		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
			} catch (ClassNotFoundException e) 
				{
 
					System.out.println("ou est votre Driver Oracle JDBC ?");
					e.printStackTrace();
					return;
 
				}
 
		System.out.println("Oracle JDBC Driver est bien ok ");
 
		
 
		try {
 
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM","oraclexe");
 
		} catch (SQLException e) 
		{
			System.out.println("erreur de Connection!");
			e.printStackTrace();
			return;
 
		}
 
		if (conn != null) {
			System.out.println("Vous etes bien connecte");
		} else {System.out.println("Impossible de faire une connection!");}
		ask();
	}

}