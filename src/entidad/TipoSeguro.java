package entidad;

public class TipoSeguro implements Comparable <TipoSeguro>
{
	private int id;
	private String descripcion;
	
	public TipoSeguro()
	{
		
	}
	
	public TipoSeguro(int id)
	{
		this.id = id;
		this.descripcion = "";
	}
	
	public TipoSeguro(int id, String descripcion)
	{
		this.id = id;
		this.descripcion = descripcion;
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
	
	@Override
	public String toString()
	{
		return "TipoSeguro [idTipo=" + id + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{			
			return true;
		}
		
		if (obj == null)
		{			
			return false;
		}
		
		if (getClass() != obj.getClass())
		{			
			return false;
		}

		TipoSeguro other = (TipoSeguro) obj;

		if (descripcion == null)
		{
			if (other.descripcion != null)
			{				
				return false;
			}
		}
		else if (!descripcion.equals(other.descripcion))
		{			
			return false;
		}

		if (id != other.id)
		{
			return false;			
		}
		
		return true;
	}

	@Override
	public int compareTo(TipoSeguro tipoSeguro)
	{
		return Integer.compare(this.getId(), tipoSeguro.getId());
	}
}
