package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.ITipoSeguroDao;
import entidad.TipoSeguro;

public class TipoSeguroDaoImpl implements ITipoSeguroDao
{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private String readAllQry;
	private String readQuery;
	
	public TipoSeguroDaoImpl()
	{
		readAllQry = "SELECT * from tiposeguros";
		readQuery = "SELECT idTipo, descripcion from tipoSeguros where idTipo = ?;";
	}
	
	private TipoSeguro getTipoSeguro(ResultSet resultSet) throws SQLException
	{
		TipoSeguro tipoSeguro = new TipoSeguro();
		tipoSeguro.setId(resultSet.getInt("idTipo"));
		tipoSeguro.setDescripcion(resultSet.getString("descripcion"));
		
		return tipoSeguro;
	}
	
	public TipoSeguro read(int id)
	{
		ResultSet resultSet;
		TipoSeguro tipoSeguro = new TipoSeguro();
		
		try
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(readQuery);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next())
			{
				tipoSeguro = getTipoSeguro(resultSet);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return tipoSeguro;
	}
	
	@Override
	public ArrayList<TipoSeguro> readAll()
	{	
		ResultSet resultSet;
		ArrayList<TipoSeguro> tipoSeguros = new ArrayList<TipoSeguro>();
		callDriver();

		try 
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(readAllQry);
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next())
			{
				tipoSeguros.add(getTipoSeguro(resultSet));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return tipoSeguros;
	}
	
	private void callDriver()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
