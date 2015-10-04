package com.digi.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;







public class StatementsExamples {
	
	private Connection connection=null;//private int a=12;
	private DatabaseUtill databaseUtill=null;
	private Statement statement=null;
	private ResultSet resultset=null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		StatementsExamples se=new StatementsExamples();
		se.insertDatatoDB();
se.readDataFromDB();
	}
//public void readDataformDB() throws ClassNotFoundException, SQLException{
	
	
public void readDataFromDB() throws ClassNotFoundException, SQLException {
	
	String sql = "select * from company.employee";
	
	
databaseUtill = new DatabaseUtill();
databaseUtill.setupDBConnection();
connection = databaseUtill.setupDBConnection();
statement = connection.createStatement();
resultset  = statement.executeQuery(sql);

while(resultset.next()) {
	String name = resultset.getString("name");
	String title=resultset.getString("title");
	
	System.out.println("name: " +name);
	System.out.println("tilte:" +title);
}
}

	public void insertDatatoDB() throws ClassNotFoundException, SQLException{
		
		String sql = "INSERT INTO EMPLOYEE values (8, ' updated john','Supervisor',1)";
		databaseUtill = new DatabaseUtill();
		connection = databaseUtill.setupDBConnection();
		statement = connection.createStatement();
		

		System.out.println("sql:" + sql);
		int rowsInserted = statement.executeUpdate(sql);
		System.out.println("No of rows inserted:" + rowsInserted);		
		
		
	}






}


