public class Persona implements Comparable<Persona> {
    private int edad;
    private String nombre;
    private char sexo; // 'M' para Mujer, 'H' para Hombre
    
    public Persona(int edad, String nombre, char sexo) {
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    // Getters y Setters
    public int getEdad() {
    	return edad; 
    	}
    public void setEdad(int edad) { 
    	this.edad = edad; 
    	}
    public String getNombre() { 
    	return nombre; 
    	}
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    	}
    public char getSexo() { 
    	return sexo; 
    	}
    public void setSexo(char sexo) { 
    	this.sexo = sexo;
    	}

    @Override
    public int compareTo(Persona o) {
        int difS = Character.compare(this.sexo, o.getSexo());
        if (difS != 0) return difS;

        int difE = Integer.compare(this.edad, o.getEdad());
        if (difE != 0) return difE;

        return this.nombre.compareTo(o.getNombre());
    }
    
    @Override
    public String toString() {
        return "[" + nombre + "-" + edad + "-" + sexo + "] ";
    }
}