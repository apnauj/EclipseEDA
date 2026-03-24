class ProductoFumigacion extends Producto{
    private String metodo;
    
    public ProductoFumigacion(String nombre, PlagaEspecie[] plagas, String metodo) {
		super(nombre, plagas);
		this.metodo = metodo;
	}

	public ProductoFumigacion(String nombre, String metodo) {
		super(nombre);
		this.metodo = metodo;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
    
    
}