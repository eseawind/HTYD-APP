package util.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBOperator {
	
	private static String m_dbName = "jsbDb";
	private DBHelper m_dbHelper; 
    public static DBOperator m_instance = null; 
    public SQLiteDatabase m_sqliteDatabase;  
    
    public DBOperator(Context context) 
    {
    	m_dbHelper = new DBHelper(context,m_dbName);
    	m_sqliteDatabase = m_dbHelper.getReadableDatabase();
    }    
    public static final DBOperator getInstance(Context context) 
    {
    	if (m_instance == null)
    	{
    		m_instance = new DBOperator(context);
    	}
    	
    	return m_instance;
    } 
    public void close() 
    {
    	if(m_sqliteDatabase.isOpen()) 
    		m_sqliteDatabase.close();    

        if(m_dbHelper != null) 
        	m_dbHelper.close();    

        if(m_instance != null) 
        	m_instance = null;    
    }
    
    public void ExecuteNonQuery(String strSql)
    {
    	try
    	{
    		m_sqliteDatabase.execSQL(strSql);
    		
    		close();
    	}
    	catch(SQLException e)
    	{
    		throw e;
    	}
    }
    public void ExecuteNonQuery(String strSql,Object[] obj)
    {
    	try
    	{
    		m_sqliteDatabase.execSQL(strSql,obj);
    		
    		close();
    	}
    	catch(SQLException e)
    	{
    		throw e;
    	}
    }
    
    public void TranExecuteNonQuery(String[] strArrSql)
    {
    	m_sqliteDatabase.beginTransaction();
    	try
    	{
    		for (int i=0;i<strArrSql.length;i++)
    		{
    			m_sqliteDatabase.execSQL(strArrSql[i].toString());
    		}
    		
    		m_sqliteDatabase.setTransactionSuccessful();
    	}
    	catch(SQLException e)
    	{
    		throw e;
    	}
    	finally
    	{
    		m_sqliteDatabase.endTransaction();
    	}    	
    }    
}
