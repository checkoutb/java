package june.fifteen.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 */
public class MysqlWWW {

	private static Statement stmt =null;
	private static PreparedStatement pstmt = null;
	private static CallableStatement cstmt = null;
	private static ResultSet rs = null;
	private static Connection conn = null;
	/**
	 */
	public static void main(String[] args) {

		String sql = "";
		try {
			conn = getConn();
			
			sql = " select * from person where person_name=?";
			String name = "tlr";
			stmt = conn.createStatement();		//静�?�sql
			pstmt = conn.prepareStatement(sql);		//动�?�sql
			cstmt = conn.prepareCall(sql);		//数据库存�?
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
			    System.out.println(rs.getString(2));
			}
			
			/*rs = stmt.executeQuery("select * from person");
//			System.out.println(rs.getString(2));		//exception
			while(rs.next())
			{
				System.out.println(rs.getString(2));		//第一列是1.
				System.out.println(rs.getInt("person_age"));
			}
			*/
			
//			insertData();
//			deleteData(55,61);
//			updateData();
			
			
			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void updateData()
	{
		StringBuilder sql = new StringBuilder();
		sql.append("update person set person_id=57 where person_id=44");
		
		try {
			stmt.executeUpdate(sql.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn()
	{
		MySqlConn msc = new MySqlConn();
		return msc.conn2MySql();
	}
	
	
	public static void deleteData(int s, int e)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("delete from person where 1=1 ").append("and person_id>" + s + " and person_id<" + e);
		String jdbcsql = sql.toString();
		
		try {
			stmt.executeUpdate(jdbcsql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public static void insertData()
	{
		//int name age tel sex
		StringBuilder sql = new StringBuilder();
		sql.append("insert into person (person_name,person_sex,person_age) value ");	//怎么才能where 1=1那种呢？直接加一�? select xxxx,xx,xx from person where id=1 ??
		StringBuilder name = new StringBuilder();
		
		for(int i = 0; i < 100; i++)
		{
			int k = (int) (Math.random()*10);
			if(k==0)
			{
				k++;
			}
			for(int j = 0; j < k ; j++)
			{
				name.append((int)(Math.random()*9));
			}
			int age = (int) ((Math.random()*60));
			char sex = (Math.random()>0.6 ? 'f' : 'm');
			sql.append("(\'").append(name).append("\',\'").append(sex).append("\',\'").append(age).append("\'),");
			name.delete(0, name.length());
		}
		sql.setCharAt(sql.length()-1, ' ');
		String jdbcsql = sql.toString();
		try {
			conn.prepareCall(jdbcsql).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll()
	{
		try
		{
			if(null!=rs)
			{
				rs.close();
			}
			stmt.close();
			pstmt.close();
			cstmt.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}







