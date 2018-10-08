package jdbc;

import java.sql.*;
import java.util.ArrayList;

public class jdbcSelect {
	
	static DBConnection dbC = new DBConnection();
	
 
	public static void main(String[] args) 
	{
		ArrayList<Question> QList = new ArrayList<Question>();
		QList = dbC.run();
			
		for(int i = 0; i <QList.size();i++)
		{
			System.out.print(QList.get(i).getqID() + " ");
			System.out.println(QList.get(i).getqContent());
		}
	}
}