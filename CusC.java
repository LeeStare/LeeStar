package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Client;

import system.MysqlConnection;

public class CusC
{
	static MysqlConnection my_connection = new MysqlConnection();
	public boolean addCus(String name, String phone, String address, String credit)
	{
		
		PreparedStatement st;
		String addQuery = "INSERT INTO `cus1` (`name`, `address`, `phone`, `credit card`) VALUES (?, ?, ?, ?)";
		
		try {
			st = my_connection.createConnection().prepareStatement(addQuery);
			
			st.setString(1, name);
			st.setString(2, phone);
			st.setString(3, address);
			st.setString(4, credit);
			
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public void resetAI() throws SQLException
	{
        String url = "jdbc:mysql://localhost/cus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "HcHgjc105Leo00707";
       
        Connection conn = DriverManager.getConnection(url,username,password);
		
        Statement stmt2 = conn.createStatement();
        String sql = "SELECT * FROM cus1";
        ResultSet rs = stmt2.executeQuery(sql);
        
        if(rs.next())
        {
	        Statement stmt = conn.createStatement();
			stmt.addBatch("SET @m = (SELECT MAX(id) + 1 FROM cus1)"); 
			stmt.addBatch("SET @s = CONCAT('ALTER TABLE cus1 AUTO_INCREMENT=', @m)");
			stmt.addBatch("PREPARE stmt1 FROM @s");
			stmt.addBatch("EXECUTE stmt1");
			stmt.addBatch("DEALLOCATE PREPARE stmt1");
			try {
				stmt.executeBatch();
			} catch (SQLException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}
        else
        {
        	Statement stmt = conn.createStatement();
        	stmt.clearBatch();
			stmt.addBatch("ALTER TABLE cus1 AUTO_INCREMENT = 1");
			stmt.executeBatch();
        }
	}
	
	public boolean addInCus(int id, String name, String phone, String address, String credit)
	{
		
		PreparedStatement st;
		String addQuery = "INSERT INTO `cus1` (`id`, `name`, `address`, `phone`, `credit card`) VALUES (?, ?, ?, ?, ?)";
		
		try {
			st = my_connection.createConnection().prepareStatement(addQuery);
			
			st.setInt(1, id);
			st.setString(2, name);
			st.setString(3, phone);
			st.setString(4, address);
			st.setString(5, credit);
			
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
	}
	public boolean editCus(int id, String name, String phone, String address, String credit)
	{
		PreparedStatement st;
		String edQuery = "UPDATE `cus1` SET `name` = ?, `address` = ?, `phone` = ?, `credit card` = ? WHERE `id` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			
			st.setString(1, name);
			st.setString(2, phone);
			st.setString(3, address);
			st.setString(4, credit);
			st.setInt(5, id);
			
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean removeCus(int id)
	{
		PreparedStatement st;
		String delQuery = "DELETE FROM `cus1` WHERE `id` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(delQuery);
			
			st.setInt(1, id);
			
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public void fillCusJTable(JTable table)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery = "SELECT * FROM `cus1`";
		
		try {
			ps = my_connection.createConnection().prepareStatement(selectQuery);
			rs = ps.executeQuery();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			
			Object[] row;
			
			while(rs.next())
			{
				row = new Object[5];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
		}
	}
	
	
	public static String getCusName(int CID)
	{
		PreparedStatement st;
		ResultSet rs;
		String edQuery = "SELECT `name` FROM `cus1` WHERE `ID` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			

			st.setInt(1, CID);
			
			rs = st.executeQuery();
			
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return "";
			}
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getCusPhone(int CID)
	{
		PreparedStatement st;
		ResultSet rs;
		String edQuery = "SELECT `address` FROM `cus1` WHERE `ID` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			

			st.setInt(1, CID);
			
			rs = st.executeQuery();
			
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return "";
			}
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getCusCredit(int CID)
	{
		PreparedStatement st;
		ResultSet rs;
		String edQuery = "SELECT `credit card` FROM `cus1` WHERE `ID` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			

			st.setInt(1, CID);
			
			rs = st.executeQuery();
			
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return "";
			}
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return "";
		}
	}
}
