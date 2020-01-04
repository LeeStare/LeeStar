package manage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Client;

import system.MysqlConnection;

public class BillC
{
	static MysqlConnection my_connection = new MysqlConnection();
	public static void fillBillJTable(JTable table)
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
				row[3] = rs.getString(6);
				
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			
			e.printStackTrace();
		}
	}
	
	public static boolean editCheck(int id, String CID, String RoomNum)
	{
		PreparedStatement st;
		String edQuery = "UPDATE `reservations` SET `check` = ? WHERE `id` = ?";
		
		try
		{
			st = my_connection.createConnection().prepareStatement(edQuery);
			
			st.setString(1, "Now In");
			st.setInt(2, id);
			
			
			return (st.executeUpdate() > 0);
		}
		catch (SQLException e)
		{
			// TODO 自動產生的 catch 區塊
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			return false;
		}
		
	}
	
}
