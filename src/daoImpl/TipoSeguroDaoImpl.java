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
	private String readAllQry;
	
	public TipoSeguroDaoImpl () 
	{
		readAllQry = "SELECT * from tiposeguros";
	}
	
	private TipoSeguro getTipoSeguro(ResultSet resultSet) throws SQLException
	{
		TipoSeguro tipoSeguro = new TipoSeguro();
		tipoSeguro.setId(resultSet.getInt("idTipo"));
		tipoSeguro.setDescripcion(resultSet.getString("descripcion"));
		
		return tipoSeguro;
	}
	
	@Override
	public ArrayList<TipoSeguro> readAll() 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet resultSet;
		ArrayList<TipoSeguro> tipoSeguros = new ArrayList<TipoSeguro>();
		
		try {
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
				tipoSeguros.add(getTipoSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tipoSeguros;
	}
}
