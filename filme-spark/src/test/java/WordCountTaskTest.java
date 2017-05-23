import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class WordCountTaskTest {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	@Test
	public void test() throws Exception {
		/*
		 * String inputFile =
		 * getClass().getResource("loremipsum.txt").toURI().toString(); new
		 * WordCountTask().run(inputFile);
		 */

		try {
			Class.forName(driverName);
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("Conectando ao banco...");
		Connection con = DriverManager.getConnection("jdbc:hive2://192.168.217.130:10000/default", "", "");
	    PreparedStatement pstm = con.prepareStatement("select * from csvTable2");
	    
	    System.out.println("Executando query...");
	    ResultSet rs = pstm.executeQuery();
	    
	    System.out.println("Query executada.");
	    if (rs.next()) {
	    	System.out.println(rs.getInt(1) + ", " + rs.getString(2));
	    }
	}
}
