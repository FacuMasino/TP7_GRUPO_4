package dao;

import java.util.ArrayList;

import entidad.Seguro;

public interface ISeguroDao
{
	public boolean agregar(Seguro seguro);
	public boolean eliminar(Seguro seguro);
	public boolean modificar(Seguro seguro);
	public Seguro obtenerSeguro(int idSeguro);
	public int obtenerUltimoId();
	public ArrayList<Seguro> readAllTipo(int idTipo);
	public ArrayList<Seguro> readAll();
}
