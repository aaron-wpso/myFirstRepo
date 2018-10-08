package jdbc;

public class SQLQuery 
{
	String sql;
	
	public SQLQuery(String sql)
	{
		this.sql = sql;
	}
	
	public String getSQLQuery()
	{
		return sql;
	}
}
