package database;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
public class SqlDbConnect {
	
		
	    public static void getDb() throws IOException, ClassNotFoundException, SQLException {
		//Fetching db values from property file
		
		Properties prop = new Properties();
		String infileLocation = "C:\\Users\\bilal\\eclipse-workspace\\Kite\\src\\main\\java\\properties\\input.properties";

		String outfileLocation = "C:\\Users\\bilal\\eclipse-workspace\\Kite\\src\\main\\java\\properties\\output.properties";
		
		FileInputStream FIS = new FileInputStream(infileLocation);
		prop.load(FIS);
		
	    String connection =	 (String) prop.get("ConnectionString");
	    System.out.println(connection);
		String username = (String) prop.get("DB_Username");
		String password = (String) prop.get("DB_Password");
		
		Class.forName(com.mysql.cj.jdbc.Driver.class.getName());
		
		
		Connection con = DriverManager.getConnection(connection,username,password); //sending credentials to db
		System.out.println("connected to delta Database");
		Statement st = con.createStatement();  //creating a statement
		ResultSet   rs = st.executeQuery("select * from Test_Variables2");  //executing query
		

		File output = new File(outfileLocation);
		FileWriter writer = new FileWriter(output);
		Map<String,String> map = new HashMap<>();
		while(rs.next()) {
		
		String browser_Name = rs.getString("browser");
		String url = rs.getString("url");
		
		map.put("Browser_Name",browser_Name );
		map.put("URL", url);
		
		 writer.write("Browser_Name="+""+browser_Name);;
		writer.write("\n");
		writer.write("url ="+""+url);
	    System.out.println("row data entered");
		
		rs.next();
			
		}
		
		writer.flush();
		writer.close();
		
		st.close();
		con.close();
}
}