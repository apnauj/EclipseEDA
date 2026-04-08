public class Hanoi {

    private static int[] topes = new int[3];
    private static int[][] torres = new int[3][];

    private static void inicializarTablero(int n) {
        // Inicializamos 3 torres como arreglos de tamaño n
        for (int i = 0; i < 3; i++) {
            torres[i] = new int[n];
            //-1 indica que la torre está vacía
            topes[i] = -1; 
        }

        // Llenar la primera torre (A) con discos de mayor a menor
        for (int i = n; i > 0; i--) {
            push(0, i);
        }
    }

    private static void resolverHanoi(int n, int origen, int destino, int auxiliar) {
        if (n == 1) {
            moverDisco(origen, destino);
            return;
        }

        // Paso 1: Mover n-1 hacia el auxiliar
        resolverHanoi(n - 1, origen, auxiliar, destino);

        // Paso 2: Mover el disco n al destino
        moverDisco(origen, destino);

        // Paso 3: Mover n-1 del auxiliar al destino
        resolverHanoi(n - 1, auxiliar, destino, origen);
    }

    private static void moverDisco(int desde, int hacia) {
    	//Quitamos el disco de la torre 
        int disco = pop(desde);
        //Lo ponemos encima de la otra torre
        push(hacia, disco);
        System.out.println("Moviendo disco " + disco + " de Torre " + desde + " a Torre " + hacia);
    }

    // Operación para extraer el disco superior de un arreglo
    private static int pop(int torreIdx) {
    	//Obtenemos el disco 
        int disco = torres[torreIdx][topes[torreIdx]];
        //Hacemos 0 el indice pues lo estamos quitando
        torres[torreIdx][topes[torreIdx]] = 0; 
        //Le bajamos uno al tope pues la torre queda más bajita
        topes[torreIdx]--;
        return disco;
    }

    // Operación para insertar un disco en el tope de un arreglo
    private static void push(int torreIdx, int disco) {
    	//Le sumamos uno al tope de la torre a la que estamos pusheando (torreIdx) para así saber cuantos elementos válidos hay en realidad
        topes[torreIdx]++;
        //En la torre que estamos pusheando en la posición que esta el tope que acabamos de sumar insertamos el disco
        torres[torreIdx][topes[torreIdx]] = disco;
    }

    private static void imprimirTorres() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Torre " + i + ": ");
            for (int j = 0; j <= topes[i]; j++) {
                System.out.print(torres[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }
    
    public static void main(String[] args) {
        int n = 4;
        inicializarTablero(n);
        
        System.out.println("Estado inicial:");
        imprimirTorres();

        // Ejecución del algoritmo recursivo
        resolverHanoi(n, 0, 2, 1);

        System.out.println("Estado final:");
        imprimirTorres();
    }
}