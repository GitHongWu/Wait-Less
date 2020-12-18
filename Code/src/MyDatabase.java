import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MyDatabase {
	
	//mysql -u testuser -p -h 192.168.10.103
	private static final String host = "192.168.10.103";	//server host
	//host = InetAddress.getLocalHost().getHostAddress();	//get locol ip
	private	static final String port = "3306";	//mysql defeat port
	private static final String username = "testuser";
	private static final String password = "";
	private static final String database = "restaurantdb";
	private static final String url = "jdbc:mysql://"+ host +":" + port + "/" + database +"?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rset;
	
	MyDatabase(){
		System.out.println("Connecting to database remotely...");
    	if (conn == null) {
            try {
	    		conn = DriverManager.getConnection(url, username, password);   // For MySQL only
				// The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
				stmt = conn.createStatement();
				System.out.println("Connect success");
            } catch (SQLException e) {
                System.out.println("Unable to connect database");
                e.printStackTrace();
            }
        }
	}
	
	MyDatabase(String localHost){
		System.out.println("Connecting to database as local host...");
		String localUserName = "localuser";
		String localUserPasswaod = "localuser";
		String localURL = "jdbc:mysql://localhost:3306/restaurantdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		if (conn == null && localHost.equals("localHost")) {
            try {
	    		conn = DriverManager.getConnection(localURL, localUserName, localUserPasswaod);   // For MySQL only
				// The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
				stmt = conn.createStatement();
				System.out.println("Connect success");
            } catch (SQLException e) {
                System.out.println("Unable to connect database");
                e.printStackTrace();
            }
        }
	}

    // disconnect database
    public void disconnect() {
    	System.out.println("Disconnecting ...");
        if (conn != null) {
            try {
            	rset.close();
            	rset = null;
            	stmt.close();
            	stmt = null;
                conn.close();
                conn = null;
                System.out.println("Disconnect success");
            } catch (SQLException e) {
            	System.out.println("Unable to Disconnect");
                e.printStackTrace();
            }
        }
    }
    
    public boolean isConnect() {
    	if (conn != null) {
    		return true;
    	}
    	return false;
    }
	
    public boolean loginValidate(String loginName, String _password) throws SQLException {
    	if (conn != null) {
			String strSelect = "select * from account";
			rset = stmt.executeQuery(strSelect);
			
			System.out.println("sql command: ");
			while(rset.next()) {   // Move the cursor to the next row, return false if no more row
				if (loginName.equals(rset.getString("loginName"))
						&& _password.equals(rset.getString("loginPassword"))) {
					return true;
				}
			}
			return false;
    	}
    	else {
    		System.out.println("Not connect to database");
    		return false;
    	}
    }
    
    public void signUp(String userName, String password, String position) throws SQLException {
    	if (conn != null) {
			
			// the mysql insert statement
	        String query = " insert into account (loginName, loginPassword, position)"
	          + " values (?, ?, ?)";

	        // create the mysql insert preparedstatement
	        PreparedStatement preparedStmt = conn.prepareStatement(query);
	        preparedStmt.setString (1, userName);
	        preparedStmt.setString (2, password);
	        preparedStmt.setString (3, position);
	        
	        System.out.println("loginName: " + userName);
	        System.out.println("loginPassword: " + password);

	        // execute the preparedstatement
	        preparedStmt.execute();
    	}
    	else {
    		System.out.println("Sign up Not connect to database");
    	}
        conn.close();
    }
    
    public void display(String table) throws SQLException {
    	if (conn != null) {
	    	String strSelect = "select * from restaurantdb." + table + ";";
			System.out.println("sql command: " + strSelect); // Echo For debugging
			rset = stmt.executeQuery(strSelect);
			ResultSetMetaData md = rset.getMetaData();
			int columnCount = md.getColumnCount();
			int rowCount = 0;
			while(rset.next()) {   // Move the cursor to the next row, return false if no more row
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(rset.getObject(i) + " ");
				}
				++rowCount;
				System.out.println();
			}
			
			System.out.println("Total number of records = " + rowCount);
    	}
	}
}
