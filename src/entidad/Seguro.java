package entidad;

public class Seguro implements Comparable <Seguro>
{
	   
	private static int idCounter = 0;
	private final int id;
	private String descripcion;
	private int idTipo;
	private float costoContratacion;
	private float costoAsegurado; 
	     
	
	public Seguro( String descripcion, int idTipo, float costoContratacion, float costoAsegurado) 
	{
		
		idCounter++;
		this.id = idCounter;
		this.descripcion = descripcion;
		this.idTipo = idTipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}

	public int getId()
	{
			return id;
	}

	
	public String getDescripcion()
	{
			return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
			this.descripcion = descripcion;
	}

	public int getIdTipo()
	{
			return idTipo;
	}

	public void setIdTipo(int idTipo) 
	{
			this.idTipo = idTipo;
	}

	public float getCostoContratacion() 
	{
			return costoContratacion;
	}

	public void setCostoContratacion(float costoContratacion)
	{
			this.costoContratacion = costoContratacion;
	}

	public float getCostoAsegurado()
	{
			return costoAsegurado;
	}

	public void setCostoAsegurado(float costoAsegurado) 
	{
			this.costoAsegurado = costoAsegurado;
	}

	@Override
	public String toString() 
	{
		return "Seguro [id=" + id + ", descripcion=" + descripcion + ", idTipo=" + idTipo + ", costoContratacion="
				+ costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(costoAsegurado);
		result = prime * result + Float.floatToIntBits(costoContratacion);
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id;
		result = prime * result + idTipo;
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Seguro other = (Seguro) obj;
		
		if (Float.floatToIntBits(costoAsegurado) != Float.floatToIntBits(other.costoAsegurado))
			return false;
		if (Float.floatToIntBits(costoContratacion) != Float.floatToIntBits(other.costoContratacion))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (idTipo != other.idTipo)
			return false;
		return true;
	}

	@Override
	public int compareTo(Seguro seguro) {
		if(seguro.getDescripcion().toLowerCase().compareTo(this.descripcion.toLowerCase()) == 0) return 0;
		if(seguro.getDescripcion().toLowerCase().compareTo(this.descripcion.toLowerCase()) < 0) return 1;
		return -1;
		
	}


	
}
