package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Client;

import system.MysqlConnection;

public class ReservationC
{
	static MysqlConnection my_connection = new MysqlConnection();
	static RoomC room = new RoomC();
	//▼我也不知在幹嘛
	//ALTER TABLE reservations ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES cus1(id) on DELETE CASCADE;
	//ALTER TABLE reservations ADD CONSTRAINT fk_room_Num FOREIGN KEY (room_Num) REFERENCES reroom(`Number`) on DELETE CASCADE;
	
	//ALTER TABLE reroom ADD CONSTRAINT fk_type_id FOREIGN KEY (`type`) REFERENCES room(ID) on DELETE CASCADE;
	
	public static boolean addReservation(int customer_id, int room_number, String dateIn, String dateOut)
	{
		
		PreparedStatement st;
		String addQuery = "INSERT INTO `reservations` (`customer_id`, `room_Num`, `data_in`, `data_out`, `check`) VALUES (?, ?, ?, ? ,?)";
		
		try {
			st = my_connection.createConnection().prepareStatement(addQuery);
			
			st.setInt(1, customer_id);
			st.setInt(2, room_number);
			st.setString(3, dateIn);
			st.setString(4, dateOut);
			st.setString(5, "Not yet");
			
			
			
			if(room.isRoomReserved(room_number).equals("NO"))
			{
				if(st.executeUpdate() > 0)
				{
					room.setRoomReserved(room_number, "YES");
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "This Room Is Already Reserved", "Room Reserved", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public static boolean addInReservation(int id, int customer_id, int room_number, String dateIn, String dateOut)
	{
		
		PreparedStatement st;
		String addQuery = "INSERT INTO `reservations` (`id`, `customer_id`, `room_Num`, `data_in`, `data_out`, `check`) VALUES (?, ?, ?, ?, ? ,?)";
		
		try {
			st = my_connection.createConnection().prepareStatement(addQuery);
			
			st.setInt(1, id);
			st.setInt(2, customer_id);
			st.setInt(3, room_number);
			st.setString(4, dateIn);
			st.setString(5, dateOut);
			st.setString(6, "Not yet");
			
			if(room.isRoomReserved(room_number).equals("NO"))
			{
				if(st.executeUpdate() > 0)
				{
					room.setRoomReserved(room_number, "YES");
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "This Room Is Already Reserved", "Room Reserved", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean editReservation(int reservation_id, int customer_id, int room_number, String Date_In, String Date_Out)
	{
		PreparedStatement st;
		String edQuery = "UPDATE `reservations` SET `customer_id` = ?, `room_Num` = ?, `data_in` = ?, `data_out` = ? WHERE `id` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(edQuery);
			
			st.setInt(1, customer_id);
			st.setInt(2, room_number);
			st.setString(3, Date_In);
			st.setString(4, Date_Out);
			st.setInt(5, reservation_id);
			
			return (st.executeUpdate() > 0);
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean removeReservation(int reservation_id)
	{
		PreparedStatement st;
		String delQuery = "DELETE FROM `reservations` WHERE `id` = ?";
		
		try {
			st = my_connection.createConnection().prepareStatement(delQuery);
			
			st.setInt(1, reservation_id);
			
			int room_number = getRoomNumberRes(reservation_id);
			
			if(st.executeUpdate() > 0)
			{
				room.setRoomReserved(room_number, "NO");
				return true;
			}
			else
			{
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
	}
	
	public static void fillReservationJTable(JTable table)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery = "SELECT * FROM `reservations`";
		
		try {
			ps = my_connection.createConnection().prepareStatement(selectQuery);
			rs = ps.executeQuery();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			
			Object[] row;
			
			while(rs.next())
			{
				row = new Object[5];
				row[0] = rs.getInt(1);
				row[1] = rs.getInt(2);
				row[2] = rs.getInt(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
		}
	}
	
	
	public static void resetAI() throws SQLException
	{
        String url = "jdbc:mysql://localhost/cus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "HcHgjc105Leo00707";
        
        Connection conn = DriverManager.getConnection(url,username,password);
        
        Statement stmt2 = conn.createStatement();
        String sql = "SELECT * FROM reservations";
        ResultSet rs = stmt2.executeQuery(sql);
        
        if(rs.next())
        {
			Statement stmt = conn.createStatement();
			stmt.addBatch("SET @m = (SELECT MAX(id) + 1 FROM reservations)"); 
			stmt.addBatch("SET @s = CONCAT('ALTER TABLE reservations AUTO_INCREMENT=', @m)");
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
			stmt.addBatch("ALTER TABLE reservations AUTO_INCREMENT = 1");
			stmt.executeBatch();
        }
	}
	
	public static int getRoomNumberRes(int reservation_id)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery = "SELECT `room_Num` FROM `reservations` WHERE `id` = ?";
		
		try
		{
			ps = my_connection.createConnection().prepareStatement(selectQuery);
			ps.setInt(1, reservation_id);
			rs = ps.executeQuery();
			
			
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return 0;
			}
		}
		catch (SQLException e)
		{
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String getDinRes(int reservation_id)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery = "SELECT `data_in` FROM `reservations` WHERE `id` = ?";
		
		try
		{
			ps = my_connection.createConnection().prepareStatement(selectQuery);
			ps.setInt(1, reservation_id);
			rs = ps.executeQuery();
			
			
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return "";
			}
		}
		catch (SQLException e)
		{
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getDoutRes(int reservation_id)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery = "SELECT `data_out` FROM `reservations` WHERE `id` = ?";
		
		try
		{
			ps = my_connection.createConnection().prepareStatement(selectQuery);
			ps.setInt(1, reservation_id);
			rs = ps.executeQuery();
			
			
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return "";
			}
		}
		catch (SQLException e)
		{
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
			return "";
		}
	}
	
	public static int getPrice(int reservation_id)
	{
		int RoomNum = getRoomNumberRes(reservation_id);
		String dateIn = getDinRes(reservation_id);
		String dateOut = getDoutRes(reservation_id);
		
		int baseP = RoomC.getRoomPrice(RoomNum);
		int talDay = dateDiff(dateIn, dateOut);
		return baseP * talDay;
	}
	
	public static int dateDiff(String dateFromStrig, String dateToString)
	{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTo = null;
        Date dateFrom = null;

        // Date型に変換
        try {
            dateFrom = sdf.parse(dateFromStrig);
            dateTo = sdf.parse(dateToString);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        // 差分の日数を計算する
        long dateTimeTo = dateTo.getTime();
        long dateTimeFrom = dateFrom.getTime();
        long dayDiff = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 60 * 24 );
        
        return (int) dayDiff;
    }
}