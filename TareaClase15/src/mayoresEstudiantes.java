import java.util.Arrays;

public class mayoresEstudiantes {
    
    public static Estudiante[] mayores(Estudiante[] e) {
        if (e == null || e.length == 0) return new Estudiante[0];
        return mayores(e, 0);
    }
    
    private static Estudiante[] mayores(Estudiante[] e, int i) {
        if (i == e.length) return new Estudiante[0];
        
        Estudiante[] m = mayores(e, i + 1);
        
        if (e[i].getEdad() >= 18) {
            Estudiante[] nuevoArreglo = Arrays.copyOf(m, m.length + 1);
            nuevoArreglo[nuevoArreglo.length - 1] = e[i];
            return nuevoArreglo;
        }

        return m;
    }

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Pedro", 19);
        Estudiante e2 = new Estudiante("Sara", 17);
        Estudiante e3 = new Estudiante("Manuel", 20);
        Estudiante[] estudiantes = {e1, e2, e3};
        
        for (Estudiante e : mayores(estudiantes)) {
            System.out.println(e.getNombre() + " - " + e.getEdad());
        }
    }
}