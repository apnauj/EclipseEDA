import java.util.*;

// Crear ExceptionEvento

class Atleta{
    protected String nombre;
    protected String paisOrigen;
    public Atleta(String nombre, String paisOrigen) {
        super();
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPaisOrigen() {
        return paisOrigen;
    }
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    
}