package shoppingSystem;

import java.sql.Connection;
import java.util.LinkedList;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class dataBaseConnection {
	private String uName = "root";
	private String password = "qwerty";
	
	private String url = "jdbc:mysql://localhost:3306/bankapp";
	private String query;
	private Connection con = null;
	private Statement statement = null;
	
	{
		getConnection();
	}
	
	
	
	
	
	

	
	
	public void createNewData(String databaseShema,String DataTables,String Values ) {
		
		 try {
			 query = "INSERT INTO "+ databaseShema +" ("+ DataTables+") VALUES ("+ Values +")";
			  statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
		

     public void deleteData(int id,String shema) throws SQLException {
	    
    	 query = "DELETE FROM "+ shema  +" WHERE ID="+id;
    	 statement.executeUpdate(query);
	
	}

	
     public void editData(double balance, int id) {
		
//     	try {
//     		query = "UPDATE account SET Balance=" +balance+"WHERE ID="+id;
//			statement.executeUpdate(query);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	

public List<String[]> RetrieveData(String databaseShema,int numberOfData) throws SQLException {
		query = "SELECT * FROM " + databaseShema;
		ResultSet rs = statement.executeQuery(query);
		List<String[]> data = new LinkedList<>();
		while (rs.next()) {
			String dataRow = "";
			for (int i = 1; i < numberOfData + 1; i++) {
				
				dataRow =dataRow + rs.getObject(i) + ",";
			}
			String[] dataRecords = dataRow.split(",");
			data.add(dataRecords);	
			}
			
			
//			
//			
//			
//		}
		return data;
	}
	

	
	
	public void getConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(url, uName,password);
		 statement = con.createStatement();
		
		
			
		}
		
			
	 catch (Exception e) {
		
		System.out.print("Exception : " + e.toString());
		// TODO: handle exception
	}



}
}
