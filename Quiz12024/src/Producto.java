import java.util.Arrays;

class Producto{
    private String nombre;
    private PlagaEspecie[] plagas;// Las especies que puede capturar o manejear
    
    public String getNombre() {
        return nombre;
    }

    public Producto(String nombre, PlagaEspecie[] plagas) {
        this.nombre = nombre;
        this.plagas = plagas;
    }
    
    public Producto(String nombre) {
        this.nombre = nombre;
        this.plagas = new PlagaEspecie[0];
    }
    
    public void addPlagaEspecie(String plaga, String[] subespecies) {
        plagas = Arrays.copyOf(plagas, plagas.length+1);
        plagas[plagas.length-1] = new PlagaEspecie(plaga, subespecies);
    }

    
    //Devuelve verdadero si la plaga se encuentra en la lista plagas
    public boolean isPlaga(String plaga) {
    	int i =0;
    	while (i != (plagas.length-1)) {
			int j = 0;
			while (j != plagas[i].getSubespecies().length - 1 && plagas[i].getSubespecies()[j] != plaga) {
				j++;
			}
			if(j != plagas[i].getSubespecies().length - 1) {
				return true;
			}
		}
        return false;
    }
}
