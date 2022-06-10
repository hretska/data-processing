package jdbs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import phone.Phone;
import servlets.LabCRUDInterface;

public class SqlCRUD implements LabCRUDInterface<Phone> {

Connection connection;
	
	
	public SqlCRUD() {
		
		this.connection = new Connect().getCon();
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Phone t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection.prepareStatement("INSERT INTO phone (\"title\", power, price) " + "VALUES (?,?,?)")) {
			st.setString(1, t.getTitle());
			st.setDouble(3, t.getPrice());
			st.setInt(2, t.getPower());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Phone> read() {
		List<Phone> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); 
				ResultSet rs = st.executeQuery("SELECT * FROM phone;");) {
			while (rs.next()) {
				list.add(new Phone(rs.getInt(1), rs.getString(2), rs.getDouble(4), rs.getInt(3)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(int id, Phone t) {
		try (PreparedStatement st = connection
				.prepareStatement("UPDATE phone " + "SET \"title\"=?, \"power\"=?, \"price\"=? WHERE id=?;")) {
			st.setString(1, t.getTitle());
			st.setDouble(3, t.getPrice());
			st.setInt(2, t.getPower());
			st.setInt(4, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection
				.prepareStatement("DELETE FROM phone WHERE id=?;")) {
			st.setInt(1, id);			
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
