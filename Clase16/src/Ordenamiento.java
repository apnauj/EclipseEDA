import java.security.Identity;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.function.LongFunction;

public class Ordenamiento {
	
	public static void bubbleInt(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if(a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	
	public static void bubble(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if(a[j].compareTo(a[j + 1]) > 0) {
					Comparable temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	
	public static void selection(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int im = i;
			for (int j = i + 1; j < a.length; j++) {
				if(a[j].compareTo(a[im]) < 0) {
					im = j;
				}
			}
			Comparable temp = a[i];
			a[i] = a[im];
			a[im] = temp;
		}
	}
	
	public static void insertion(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			Comparable temp = a[i];
			int j = i;
			while (j > 0 && temp.compareTo(a[j - 1]) < 0) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
	}
	
	public static void bubbleOptimizado(Comparable[] a) {
	    boolean intercambio = true;
	    int i = 0;
	    while (i < a.length - 1 && intercambio) {
	        intercambio = false; 
	        
	        for (int j = 0; j < a.length - 1 - i; j++) {
	            if (a[j].compareTo(a[j + 1]) > 0) {
	                Comparable temp = a[j];
	                a[j] = a[j + 1];
	                a[j + 1] = temp;
	                intercambio = true; 
	            }
	        }
	        i++; 
	    }
	}
	
	public static void quick(Comparable[] a, int inicio, int fin) {
		//Si se cruzan devolvemos esta iteración
		if(fin <= inicio) return;
		else {
			//Elegimos un pivote al final
			Comparable pivote = a[fin];
			//Apuntador al inicio
			int i = inicio - 1;
			//Apuntador al final
			int j = fin; 
			Comparable temp;
			//Mientas i y j no se crucen
			while(i < j) {
				//Mientas el siguiente elemento de la derecha sea menor que el pivote
				//Es decir que sale cuando a[i] es mayor
				while(a[++i].compareTo(pivote) < 0);
				//Mientras j no se pase del inicio y el siguiente elemento por la izquierda sea mayor
				//Es decir que sale cuando a[j] es menor
				while(j > inicio && a[--j].compareTo(pivote) > 0);
				//Si después de pasar al siguiente elemento i sigue siendo menor que j
				if(i < j) {
					//Guardamos en temp el elemento en a[i] (que es mayor al pivote)
					temp = a[i];
					//En el lugar donde estaba a[i] ponemos a[j] (que es menor que el pivote)
					a[i] = a[j];
					//En donde estaba a[j] ponemos a[i]
					a[j] = temp;
				}
			}
			//Hacemos el swap del pivote hacia la posición del medio del arreglo
			temp = a[i];
			a[i] = a[fin];
			a[fin] = temp;
			int partition = i;
			//Llamamos a la función recursivamente en cada una de las dos mitades del arreglo
			quick(a, inicio, partition - 1);
			quick(a, partition + 1, fin);
		}
	}
	
	//MergeSort
	public static Comparable[] merge(Comparable[] a, Comparable[] b) {
		Comparable[] ans = new Comparable[a.length + b.length];
		int i = 0;
		int j = 0;
		while(i < a.length && j < b.length) {
			ans[i + j] = (a[i].compareTo(b[j]) <= 0) ? a[i++] : b[j++];
		}
		for (int k = i; k < a.length; k++) {
			ans[k + j] = a[k];
		}
		for (int k = j; k < b.length; k++) {
			ans[k + i] = b[k];
		}
		return ans;
	}
	
	public static Comparable[] mergeSortOptimo(Comparable[] a, int i, int j) {
		if(j <= i) return new Comparable[] {a[i]};
		int mitad = (i + j)/2;
		Comparable[] l = mergeSortOptimo(a, i, mitad);
		Comparable[] r = mergeSortOptimo(a, mitad + 1, j);
		return merge(l, r);
	}
	
	public static void printLista(Comparable[] a) {
		if(a != null) {
			for (Comparable comparable : a) {
				System.out.print(comparable + " ");
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args) {
		Persona p1 = new Persona(21, "Marcela",'F');
		Persona p2 = new Persona(20, "Marcela",'F');
		Persona p3 = new Persona(24, "Marcela",'F');
		Persona p4 = new Persona(26, "Andrés",'M');
		Persona p5 = new Persona(30, "Carlos",'M');
		Persona p6 = new Persona(21, "Ana",'F');
		Persona p7 = new Persona(21, "Nadia",'F');
		Persona[] arregloPersonas = {p1, p2, p3, p4, p5, p6, p7};
		Integer[] arregloEnteros = {9,2,2,6,3,7,4,1,5,8};
		String[] arregloStrings = {"Angel","Ana","Ana","Abel","Alberto"};
		selection(arregloStrings);
		insertion(arregloEnteros);
		bubbleOptimizado(arregloPersonas);
		printLista(arregloStrings);
		printLista(arregloEnteros);
		printLista(arregloPersonas);
		System.out.println();
		
		int N = 100000;
		
		Random r = new Random();
		Integer[] lista = new Integer[N];
		for (int i = 0; i < N; i++) {
//			lista[i] = r.nextInt(2*N);
			lista[i] = N - i;
//			lista[i] = i;
		}
		long timeInicio;
		long timeFin;
		
		
		//QuickSort
		Integer[] listaTemp = Arrays.copyOf(lista, N);
		timeInicio = System.currentTimeMillis();
		quick(listaTemp, 0, listaTemp.length - 1);
		timeFin = System.currentTimeMillis();
		System.out.println("Quicksort: " + (timeFin-timeInicio));
		
		for (int i = 0; i < 20; i++) {
			System.out.print(listaTemp[i] + " ");
		}
		System.out.println();
		
		//Merge Sort
		listaTemp = Arrays.copyOf(lista, N);
		timeInicio = System.currentTimeMillis();
		mergeSortOptimo(listaTemp, 0, listaTemp.length - 1);
		timeFin = System.currentTimeMillis();
		System.out.println("Merge Sort: " + (timeFin-timeInicio));
		
		for (int i = 0; i < 20; i++) {
			System.out.print(listaTemp[i] + " ");
		}
		System.out.println();
		
		//Selection Sort
		listaTemp = Arrays.copyOf(lista, N);
		timeInicio = System.currentTimeMillis();
		selection(listaTemp);
		timeFin = System.currentTimeMillis();
		System.out.println("Selection: " + (timeFin-timeInicio));
		
		for (int i = 0; i < 20; i++) {
			System.out.print(listaTemp[i] + " ");
		}
		System.out.println();
		
		//Bubble Sort
		listaTemp = Arrays.copyOf(lista, N);
		timeInicio = System.currentTimeMillis();
		bubble(listaTemp);
		timeFin = System.currentTimeMillis();
		System.out.println("BubbleSort: " + (timeFin-timeInicio));
		
		for (int i = 0; i < 20; i++) {
			System.out.print(listaTemp[i] + " ");
		}
		System.out.println();
		
		//Insertion Sort
		listaTemp = Arrays.copyOf(lista, N);
		timeInicio = System.currentTimeMillis();
		insertion(listaTemp);
		timeFin = System.currentTimeMillis();
		System.out.println("Insertion: " + (timeFin-timeInicio));
		
		for (int i = 0; i < 20; i++) {
			System.out.print(listaTemp[i] + " ");
		}
		System.out.println();
		
		//Bubble Optimo
		listaTemp = Arrays.copyOf(lista, N);
		timeInicio = System.currentTimeMillis();
		bubbleOptimizado(listaTemp);
		timeFin = System.currentTimeMillis();
		System.out.println("BubbleSort Optimo: " + (timeFin-timeInicio));
		
		for (int i = 0; i < 20; i++) {
			System.out.print(listaTemp[i] + " ");
		}
		System.out.println();
		
		
		
	}
}
