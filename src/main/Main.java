package main;

import java.util.ArrayList;

import daoImpl.SeguroDaoImpl;
import entidad.Seguro;

/////////////
/////////////
//MAIN PARA PRUEBAS
/////////////
/////////////
public class Main {

	public static void main(String[] args) {
		
		SeguroDaoImpl seguroDao = new SeguroDaoImpl();
		Seguro seguro1 = new Seguro();
		
		
		seguro1.getTipoSeguro().setId(2);
		seguro1.setDescripcion("Seguro de VIDA para mayores de 99 a�os");
		seguro1.setCostoContratacion(989889);
		seguro1.setCostoAsegurado(5);
		
		///seguroDao.agregar(seguro1);
		
		
		ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
		listaSeguros = seguroDao.readAll();
		
		for(Seguro s : listaSeguros)
		{
			System.out.println(s.toString());
			System.out.println("\n");
		}
		
		
		System.out.println("El ultimo ID generado es: " + seguroDao.obtenerUltimoId() + "\n");
		System.out.println("El proximo ID sera: " + (seguroDao.obtenerUltimoId() + 1));
		
		
		System.out.println("Terminado");

	}

}
