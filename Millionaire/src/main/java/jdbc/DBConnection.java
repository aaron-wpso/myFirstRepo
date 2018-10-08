package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection 
{
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final String DB_URL = "jdbc:mysql://localhost:3306/dbQuestion2";
	
	private final String USER = "root";
	private final String PASS = "root123";
	
	private SQLQuery sql;
	private ArrayList<Question> QList = new ArrayList<Question>();
	
	public ArrayList<Question> run()
	{
		Connection conn = null;
		 Statement stmt = null;
		 try{
		    //STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    //System.out.println("Connecting to a selected database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    //System.out.println("Connected database successfully...");
		    
		    //STEP 4: Execute a query
		    //System.out.println("Creating statement...");
		    stmt = conn.createStatement();

		    sql = new SQLQuery("SELECT question.qID as QuestionID, question.qContent as QuestionContent, " + 
		    		" correctans.caContent as CorrectAnswer, wrongans1.wa1Content as WrongAnswerOne, " + 
		    		" wrongans2.wa2Content as WrongAnswerTwo, wrongans3.wa3Content as  WrongAnswerThree " + 
		    		"FROM question INNER JOIN correctans ON question.caID = correctans.caID " + 
		    		"INNER JOIN wrongans1 ON question.wa1ID = wrongans1.wa1ID " + 
		    		"INNER JOIN wrongans2 ON question.wa2ID = wrongans2.wa2ID " + 
		    		"INNER JOIN wrongans3 ON question.wa3ID = wrongans3.wa3ID ");
		    
		    ResultSet rs = stmt.executeQuery(sql.getSQLQuery());
		    
		    //STEP 5: Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
		       int id  = rs.getInt("QuestionID");
		       String qContent = rs.getString("QuestionContent");
		       String ca = rs.getString("CorrectAnswer");
		       String wa1 = rs.getString("WrongAnswerOne");
		       String wa2 = rs.getString("WrongAnswerTwo");
		       String wa3 = rs.getString("WrongAnswerThree");
		       
		       Question ques = new Question(id, qContent, ca, wa1, wa2, wa3);
		       
		       QList.add(ques);
		       
		       //Display values
		       
		    }
		    rs.close();
		    
		 }catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources
		    try{
		       if(stmt!=null)
		          conn.close();
		    }catch(SQLException se){
		    }// do nothing
		    try{
		       if(conn!=null)
		          conn.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    }//end finally try
		 }//end try
		return QList;
	}
}
