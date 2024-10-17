package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.ISeguroDao;
import entidad.Seguro;
import entidad.TipoSeguro;

public class SeguroDaoImpl implements ISeguroDao
{
	private String insertQry;
	// private String deleteQry;
	// private String modifyQry;
	// private String obtenerQry;
	private String lastIdQry;
	// private String readAllTypeQry;
	private String readAllQry;
	
	public SeguroDaoImpl()
	{
		insertQry = "INSERT INTO seguros (descripcion, idTipo, costoContratacion,costoAsegurado) VALUES (?, ?, ?,?)";
		// deleteQry = "NO LA USAMOS EN ESTE TP";
		// modifyQry = "NO LA USAMOS EN ESTE TP";
		// obtenerQry = "";
		lastIdQry = "SELECT MAX(idSeguro) as idSeguro from seguros";
		// readAllTypeQry = "";
		readAllQry = "SELECT * from seguros";
	}

	@Override
	public boolean agregar(Seguro seguro)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(insertQry);
			
			pstmt.setString(1, seguro.getDescripcion());
			pstmt.setInt(2, seguro.getTipoSeguro().getId());
			pstmt.setFloat(3, seguro.getCostoContratacion());
			pstmt.setFloat(4, seguro.getCostoAsegurado());
			
			rows = pstmt.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return (rows > 0);
	}

	@Override
	public boolean eliminar(Seguro seguro)
	{
		return false;
	}

	@Override
	public boolean modificar(Seguro seguro)
	{
		return false;
	}

	@Override
	public Seguro obtenerSeguro(int idSeguro)
	{
		return null;
	}

	@Override
	public int obtenerUltimoId()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet;
		int ultimoId = 0;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(lastIdQry);
			resultSet = pstmt.executeQuery();
			resultSet.next();
			ultimoId = resultSet.getInt("idSeguro");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return ultimoId;
	}

	@Override
	public ArrayList<Seguro> readAllTipo(int idTipo)
	{
		return null;
	}
	
	private Seguro getSeguro(ResultSet resultSet) throws SQLException
	{
		int idSeguro = resultSet.getInt("idSeguro");
		String descripcion = resultSet.getString("descripcion");
		int idTipo = resultSet.getInt("idTipo");
		float costoContratacion = resultSet.getFloat("costoContratacion");
		float costoAsegurado = resultSet.getFloat("costoAsegurado");
		return new Seguro(idSeguro,descripcion,new TipoSeguro(idTipo),costoContratacion,costoAsegurado);
	}
	
	@Override
	public ArrayList<Seguro> readAll()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet resultSet;
		ArrayList<Seguro> seguros = new ArrayList<Seguro>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		try 
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(readAllQry);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next())
			{
				seguros.add(getSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return seguros;
	}
}
