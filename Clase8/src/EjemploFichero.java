import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploFichero {
	public static void main(String[] args) {
		String fichero = "/home/juanpa/Documents/University/S3.2026/Estructuras/EclipseWorkspace/Clase8/ficheros/ficheroPrueba.txt";
		File f = new File(fichero);
		FileReader fr = null;
		BufferedReader b = null;
		try {
			fr = new FileReader(f);
			b = new BufferedReader(fr);
			String linea;
			while((linea = b.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo encontrar el fichero");
		} catch (IOException e) {
			System.out.println("No se pudo escribir en el fichero");
		} finally {
			try {
				if(fr != null) {
					b.close();
					fr.close();
				}
			} catch (IOException e) {
				System.out.println("No se pudo cerrar el fichero");
			}
		}
		
//		FileWriter fw = null;
//		BufferedWriter b = null;
//		try {
//			fw = new FileWriter(fichero);
//			b = new BufferedWriter(fw);
//			b.write("Esta es una prueba de que puedo escribir en el fichero");
//			b.newLine();
//			b.write("Esta es otra prueba");
//			b.newLine();
//		} catch (FileNotFoundException e) {
//			System.out.println("No se pudo encontrar el fichero");
//		} catch (IOException e) {
//			System.out.println("No se pudo escrbir en el fichero");
//		} finally {
//			if(fw != null) {
//				try {
//					b.close();
//					fw.close();
//				} catch (IOException e) {
//					System.out.println("No se pudo cerrar el fichero");
//				}
//			}
//		}
	}
}
