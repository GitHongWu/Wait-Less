import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class MyDatabaseTest {
	
	Connection conn;
	Statement stmt;
	
	@Test
	void connectAsLocalHost() throws SQLException {
		MyDatabase db = new MyDatabase("localHost");
		db.display("account");
	}

	@Test
	void test() throws SQLException {
		//Constructor initially connect to database
		MyDatabase db = new MyDatabase();
		
		String username1 = "non_exist_user";
		String password1 = "no_password";
		String username2 = "hongcheng_wu";
		String password2 = "hongcheng_wu";
		
		if (db.isConnect()) {
			//invalid user
			if(db.loginValidate(username1, password1)) {
				System.out.println("Valid user: " + username1);
			}
			else {
				System.out.println("Invalid user: " + username1);
			}
			
			//valid user
			if(db.loginValidate(username2, password2)) {
				System.out.println("Valid user: " + username2);
			}
			else {
				System.out.println("Invalid user: " + username2);
			}
		}
		else {
			System.out.println("Not connecting to database");
		}
	}
	
	@Test
	void signUpTest() throws SQLException {
		String u = "test";
		String pw = "testPW";
		String position = "testPo";
		
		MyDatabase db = new MyDatabase();
		if (db.isConnect()) {
			db.signUp(u, pw, position);
		}
		else {
			System.out.println("Sign up test connecting to database");
		}
	}

}
