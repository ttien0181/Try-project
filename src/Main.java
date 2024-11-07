import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;


public class Main {

	public static void main(String[] args) {
		System.out.println("A");
		Connection conn = DatabaseConnection.getConnection();
		String sql = "SELECT *  FROM NHANKHAU ";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			System.out.println("A");
			while(resultSet.next()) {
				System.out.println("Mã nhân khẩu: " + resultSet.getInt("MANHANKHAU") );
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DatabaseConnection.closeConnection();
		}
	}

}
