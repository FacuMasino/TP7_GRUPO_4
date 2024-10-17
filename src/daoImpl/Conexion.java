package daoImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion
{
	private static Connection conn;
	private String host;
	private String user;
	private String pass;
	private String dbName;
	
	public Conexion()
	{
		Properties props = new Properties();

		try
		{
			InputStream is = Conexion.class.getClassLoader().getResourceAsStream("config.properties");
			
			if (is == null)
			{
		        throw new FileNotFoundException("El archivo 'config.properties' no se encontró en el directorio.");
		    }
			else
			{
				System.out.println("Archivo 'config.properties' encontrado correctamente.");
			}

			props.load(is);
			is.close();
			
			host = props.getProperty("db.host");
			user = props.getProperty("db.user");
			pass = props.getProperty("db.pass");
			dbName = props.getProperty("db.name");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getSQLConexion()   
	{
		try
		{
			if(conn == null || conn.isClosed())
			{
				conn = DriverManager.getConnection(host + dbName, user, pass);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	public void cerrar()
	{
		try 
		{
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
