
public class Usuario {
	private String tipoDoc;
	private String numDoc;
	private String nombres;
	private String apellidos;
	private Prestamo prestamos[];
	private int contadorPrestamos = 0;
	
	public Usuario(String tipoDoc, String numDoc, String nombres, String apellidos) {
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.prestamos = new Prestamo[2];
	}
	
	
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Prestamo[] getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(Prestamo[] prestamos) {
		this.prestamos = prestamos;
	}
	
}
