import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection connection = null;
	
	private DatabaseConnection() {}
	
	
	//trả về 1 connection
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url ="jdbc:sqlserver://TU_HOANG\\TIEN123TIEN123:1433;databaseName=QLThuPhi;encrypt=true;trustServerCertificate=true";
				String userName = "sa";
				String passWord = "0181";
				
				connection = DriverManager.getConnection(url, userName, passWord);
				System.out.println("Kết nối thành công");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("conn ko null");
		}
		return connection;
	}
	
	
	//ngắt kết nối sever
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
				System.out.println("Đã ngắt kết nối");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
