package business.dataaccess.dto.carrera;

public class Categoria {
	private int edadMinima;
	private int edadMaxima;
	private String tipo;
	
	public Categoria (String tipo, int edadMinima, int edadMaxima) {
		this.tipo = tipo;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
