package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Client;

import system.MysqlConnection;

public class RoomC {
	
	
	static MysqlConnection my_connection = new MysqlConnection();
	
	public void fillRoomTypeJTable(JTable table)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery = "SELECT * FROM `room`";
		
		try {
			ps = my_connection.createConnection().prepareStatement(selectQuery);
			rs = ps.executeQuery();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			
			Object[] row;
			
			while(rs.next())
			{
				row = new Object[4];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
		}
	}
	
	
	public void fillRoomTypeJCombo(JComboBox<Integer> combobox)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery = "SELECT * FROM `room`";
		
		try {
			ps = my_connection.createConnection().prepareStatement(selectQuery);
			rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				
				combobox.addItem(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
		}
	}
	
	
	public static boolean addRoom(int Type, String phone, String quality, String smoking)
	{
		
		PreparedStatement st;
		String addQuery = "INSERT INTO `reroom` (`type`, `phone`, `Quality`, `smoking`, `reserved`) VALUES (?, ?, ?, ? ,?)";
		
		try {
			st = my_connection.createConnection().prepareStatement(addQuery);
			
			st.setInt(1, Type);
			st.setString(2, phone);
			st.setString(3, quality);
			st.setString(4, smoking);
			st.setString(5, "NO");
			
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean addInRoom(int number, int Type, String phone, String quality, String smoking)
	{
		
		PreparedStatement st;
		String addQuery = "INSERT INTO `reroom` (`Number`, `type`, `phone`, `Quality`, `smoking`, `reserved`) VALUES (?, ?, ?, ?, ? ,?)";
		
		try {
			st = my_connection.createConnection().prepareStatement(addQuery);
			
			st.setInt(1, number);
			st.setInt(2, Type);
			st.setString(3, phone);
			st.setString(4, quality);
			st.setString(5, smoking);
			st.setString(6, "NO");
			
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public static boolean editRoom(int number, int Type, String phone, String quality, String smoking, String isReserved)
	{
		PreparedStatement st;
		String edQuery = "UPDATE `reroom` SET `type` = ?, `phone` = ?, `Quality` = ?, `smoking` = ?, `reserved` = ? WHERE `Number` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			
			st.setInt(1, Type);
			st.setString(2, phone);
			st.setString(3, quality);
			st.setString(4, smoking);
			st.setString(5, isReserved);
			st.setInt(6, number);
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public static boolean removeRoom(int roomnumber)
	{
		PreparedStatement st;
		String delQuery = "DELETE FROM `reroom` WHERE `Number` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(delQuery);
			
			st.setInt(1, roomnumber);
			
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
	}
	
	public void fillRoomJTable(JTable table)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery = "SELECT * FROM `reroom`";
		
		try {
			ps = my_connection.createConnection().prepareStatement(selectQuery);
			rs = ps.executeQuery();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			
			Object[] row;
			
			while(rs.next())
			{
				row = new Object[6];
				row[0] = rs.getInt(1);
				row[1] = rs.getInt(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
		}
	}
	
	public boolean setRoomReserved(int number, String isReserved)
	{
		PreparedStatement st;
		String edQuery = "UPDATE `reroom` SET `reserved` = ? WHERE `Number` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			

			st.setString(1, isReserved);
			st.setInt(2, number);
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
	}
	
	
	public String isRoomReserved(int number)
	{
		PreparedStatement st;
		ResultSet rs;
		String edQuery = "SELECT `reserved` FROM `reroom` WHERE `Number` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			

			st.setInt(1, number);
			
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
	
	public static String getRoomPhone(int RoomNum)
	{
		PreparedStatement st;
		ResultSet rs;
		String edQuery = "SELECT `phone` FROM `reroom` WHERE `Number` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			

			st.setInt(1, RoomNum);
			
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
	
	public static void resetAI() throws SQLException
	{
        String url = "jdbc:mysql://localhost/cus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "HcHgjc105Leo00707";
        
        Connection conn = DriverManager.getConnection(url,username,password);
        
        Statement stmt2 = conn.createStatement();
        String sql = "SELECT * FROM reroom";
        ResultSet rs = stmt2.executeQuery(sql);
        
        if(rs.next())
        {
			Statement stmt = conn.createStatement();
			stmt.addBatch("SET @m = (SELECT MAX(id) + 1 FROM reroom)"); 
			stmt.addBatch("SET @s = CONCAT('ALTER TABLE reroom AUTO_INCREMENT=', @m)");
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
			stmt.addBatch("ALTER TABLE reroom AUTO_INCREMENT = 1");
			stmt.executeBatch();
        }
	}
	
	public static int getRoomPrice(int RoomNum)
	{
		PreparedStatement st;
		ResultSet rs;
		String edQuery = "SELECT `type` FROM `reroom` WHERE `Number` = ?";
		int typeN = 0;
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			

			st.setInt(1, RoomNum);
			
			rs = st.executeQuery();
			
			if(rs.next())
			{
				typeN = rs.getInt(1);
			}
			else
			{
				typeN = 0;
			}
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			typeN = 0;
		}
		
		edQuery = "SELECT `price` FROM `room` WHERE `ID` = " + typeN;
		int baseP = 0;
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			
			rs = st.executeQuery();
			
			if(rs.next())
			{
				baseP = rs.getInt(1);
			}
			else
			{
				baseP = 0;
			}
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			baseP = 0;
		}
		
		
		int QP = 0;
		edQuery = "SELECT `Quality` FROM `reroom` WHERE `Number` = ?";
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			

			st.setInt(1, RoomNum);
			
			rs = st.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString(1).equals("☆☆★"))
				{
					QP = 100;
				}
				else if(rs.getString(1).equals("☆★★"))
				{
					QP = 500;
				}
				else if(rs.getString(1).equals("★★★"))
				{
					QP = 1000;
				}
			}
			else
			{
				QP = 0;
			}
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			QP = 0;
		}
		
		System.out.println(baseP);
		System.out.println(QP);
		
		return baseP + QP;
	}
}
