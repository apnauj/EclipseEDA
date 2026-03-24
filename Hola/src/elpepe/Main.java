import java.util.Arrays;
import java.util.Scanner;

class SinEstudiantes extends Exception{
    public SinEstudiantes(String s){
        super(s);
    }
}

class Persona{
    private String nombre;
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

class Estudiante extends Persona{
    private double[] notas;
    public Estudiante(String nombre){
        super(nombre);
    }
    public void setNotas(double[] notas){
        this.notas = notas;
    }
    public void getNotas(){
        System.out.println(Arrays.toString(notas));
    }
    public double promedioNotas(){
        double promedio = 0;
        for(int i = 0; i < notas.length; i++){
            promedio+=notas[i];
        }
        promedio = promedio/(notas.length);
        return promedio;
    }
    
}


class Universidad{
    private Persona[] personas;

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    public double PromedioTotal(){
        double promedio = 0;
        int contador = 0;
        for(int i = 0; i < personas.length; i++){
            if(personas[i] instanceof Estudiante){
                promedio =promedio + ((Estudiante)personas[i]).promedioNotas();
                contador++;
            }
        }
        promedio = promedio/(contador);
        return promedio;
    }
       
    
}

public class Solucion {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int cantidad= Integer.parseInt(in.nextLine());
        Persona[] personas=new Persona[cantidad];

        for (int i=0;i<cantidad;i++) {
            String tipo=in.nextLine();
            String nombre=in.nextLine();
            if (tipo.compareTo("Estudiante")==0){
                double[] notas=new double[0];
                String line="";
                while((line=in.nextLine()).compareTo("")!=0) {
                    notas=Arrays.copyOf(notas, notas.length+1);
                    notas[notas.length-1]=Double.parseDouble(line);
                }
                Estudiante e=new Estudiante(nombre);
                e.setNotas(notas);
                System.out.println(e.promedioNotas());
                personas[i]=e;
            }            
            else            
                personas[i]=new Persona(nombre);
        }       
        in.close();
        Universidad universidad=new Universidad();
        universidad.setPersonas(personas);
        double promedio=universidad.PromedioTotal(); 
        if (promedio>-1)
            System.out.print(promedio);
    }
}