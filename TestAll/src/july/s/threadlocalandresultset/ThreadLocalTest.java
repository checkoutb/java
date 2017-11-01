package july.s.threadlocalandresultset;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ThreadLocalTest {

	private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
	private static Connection initConn = null;
	
	
	/*
	 * ���� ���̡߳���get..������߳�Ҳûʲô�ð���ֱ��new2���Ϳ����ˣ�����Ҳ������ʲô��ǳ����
	 * 
	 * ��threadLocal������ּ̳�/��չThreadRunnable�Ĳ���֪�����Ͼ��ܴ�ӡ��Thread�����֡��ܱ���״̬
	 * 
	 * дjdbc��conn���ֲ���threadlocal�ļ�ֵ�ɣ������ˣ�new��2����t1ֻ��һ��static��Ӧ��ֻ��1����������ȴ��ͬʱ���С�
	 * */
	static
	{
		try
		{
			initConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/self", "root", "");
			t1.set(initConn);	//������getConn��Ͳ����ж��˰ɣ�
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ThreadLocalTest tlt = new ThreadLocalTest();
		ThreadLocalTest tlt2 = new ThreadLocalTest();
		tlt.selectTest();
		tlt2.selectTest();
		
	}

	
	
	public void selectTest()
	{
		Connection c = getConn();
		String sql = "select * from person";
		try {
			Statement stmt = (Statement) c.createStatement();
			ResultSet result =  stmt.executeQuery(sql);		//...no list or set,just ResultSet!!!
			/*while(result.next())
			{
				System.out.println(result.getInt(1) + result.getString(2) + result.getInt("person_age"));
			}*/
			
			ResultSetMetaData m = result.getMetaData();
			int columns = m.getColumnCount();
			for(int i = 1; i <= columns; i++)
			{
				System.out.printf("%12s", m.getColumnName(i));
			}
			System.out.println();
			int j = 0;
			while(result.next())
			{
				for(int i = 1; i <= columns; i++)
				{
					String out = "";
					out = result.getString(i);
					if(i==5)
					{
//						continue;
						if(result.getString(i).trim().isEmpty() || result.getString(i)==null)
						{
							//....trim.....
							//...database is '\u0000',so ...
							//and i should use result.getChar(i) == '\u0000'..this is no getChar,only getCharacterStream..
							j++;
							out = "   ";
						}
						
//						out = result.getString(i)==null ? "" : result.getString(i);
					}
					System.out.printf("%12s", " " + out);			//
				}
				System.out.println();
			}
			
//			System.out.println(j);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConn()
	{
//		Connection c = t1.get();
//		if(c==null)
//		{
//			t1.set(initConn);
//		}
		return t1.get();
	}
}
