
public class Prestamo {
	private String fechaPrestamo;
	private String fechaDevolución;
	private String fechaRealDevolucion;
	private Usuario usuario;
	private Ejemplar libro;
	private boolean activo;
	
	public Prestamo(Usuario usuario, Libro libro) {
		//Aquí se debe hacer que cuando se quiera prestar un libro 
		// dentro de este mismo constructor se busque si hay ejemplares disponibles de ese libro
		// si es así se asigna al atributo ejemplar ese libro y se marca como no disponible
		
		
	}
	
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public String getFechaDevolución() {
		return fechaDevolución;
	}
	public void setFechaDevolución(String fechaDevolución) {
		this.fechaDevolución = fechaDevolución;
	}
	public String getFechaRealDevolucion() {
		return fechaRealDevolucion;
	}
	public void setFechaRealDevolucion(String fechaRealDevolucion) {
		this.fechaRealDevolucion = fechaRealDevolucion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Ejemplar getLibro() {
		return libro;
	}
	public void setLibro(Ejemplar libro) {
		this.libro = libro;
	}
	
	
}
