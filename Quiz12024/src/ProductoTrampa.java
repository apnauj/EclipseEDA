class ProductoTrampa extends Producto{
    private String tipo;
    
    public ProductoTrampa(String nombre, PlagaEspecie[] plagas, String tipo) {
		super(nombre, plagas);
		this.tipo = tipo;
	}

	public ProductoTrampa(String nombre, String tipo) {
		super(nombre);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    
    
}