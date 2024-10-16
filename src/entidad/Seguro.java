package entidad;

public class Seguro implements Comparable <Seguro>
{
	private int id;
	private String descripcion;
	//private int idTipo;
	private TipoSeguro tipoSeguro; 
	private float costoContratacion;
	private float costoAsegurado; 
	
	public Seguro()
	{
		
	}
	
	public Seguro(int id, String descripcion,TipoSeguro tipoSeguro, float costoContratacion, float costoAsegurado) 
	{
		this.id = id;
		this.descripcion = descripcion;
		this.setTipoSeguro(tipoSeguro);
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	/*public int getIdTipo()
	{
		return idTipo;
	}

	public void setIdTipo(int idTipo) 
	{
		this.idTipo = idTipo;
	}*/

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
	
	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}


	@Override
	public String toString() 
	{
		return "Seguro [id=" + id + ", descripcion=" + descripcion + ", idTipo=" + tipoSeguro.toString() + ", costoContratacion="
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
		result = prime * result + getTipoSeguro().getId();
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
		if (getTipoSeguro().getId() != other.getTipoSeguro().getId())
			return false;
		return true;
	}

	@Override
	public int compareTo(Seguro seguro)
	{
		return Integer.compare(this.getId(), seguro.getId());
	}

	
	
}
