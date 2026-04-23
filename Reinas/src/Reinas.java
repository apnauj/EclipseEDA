public class Reinas {

    private static final int N = 8;
    private static final int[][] tablero = new int[N][N];

    //Fuerza bruta, verificaciones de columnas, filas y diagonales por completo
    public static boolean isValid(int i, int j) {
        int k = 0;
        int l;
        boolean exit = false;
        while (k < tablero.length && !exit) {
            l = 0;
            while (l < tablero.length && !exit) {
                if (tablero[k][l] == 1 && !(k == i && l == j)) {
                    if (k == i || l == j) {
                        exit = true;
                    } 
                    else if (Math.abs(i - k) == Math.abs(j - l)) {
                        exit = true;
                    }
                }
                l++;
            }
            k++;
        }
        return !exit;
    }

    //Backtracking
    public static boolean resolver(int fila) {
        //Si todas las reinas han sido colocadas
        if (fila >= N) return true;

        //Intenta colocar la reina en cada columna de la fila actual
        for (int columna = 0; columna < N; columna++) {
            
            //Colocar reina temporalmente
            tablero[fila][columna] = 1;

            //Usar isValid para validar la posición
            if (isValid(fila, columna)) {
                // Recursión: Intentar colocar la reina en la siguiente fila
                if (resolver(fila + 1)) {
                    return true;
                }
            }

            //(Backtracking): Si no lleva a solución, se limpia la celda
            tablero[fila][columna] = 0;
        }

        return false;
    }

    public static void imprimirTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (resolver(0)) {
            imprimirTablero();
        } else {
            System.out.println("No existe solución.");
        }
    }
}