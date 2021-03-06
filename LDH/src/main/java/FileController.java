import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Clase que se encarga de todas las acciones relativas a los ficheros de entrada y salida
 * @author Bianney
 *
 */
public class FileController {
	
	public static String finalText = "";//String que almacena el texto de los distintos archivos de entrada
	private Scanner scanner;//Objeto de la clase Scanner. Utilizado para leer ficheros
	
	/**
	 * Funci�n que borra el contenido del fichero que se le pasa por par�metro
	 * @param file Fichero al cual se le borra el contenido
	 */
	public void deleteFile(File file){
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Funci�n que a�ade el texto de un fichero de entrada a la variable est�tica finalText
	 * @param input Fichero de entrada
	 */
	public void addText(File input){
		String text = "";
		//Se recorre el fichero input y se va a�adiendo el contenido a la variable text
		try {
			scanner = new Scanner(input);
			while (scanner.hasNext()){
				text = text + scanner.next() + " ";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		finalText = finalText + text;
	}
	
	/**
	 * Funci�n que a�ade al archivo que se le pasa por par�metro el contenido de la variable est�tica finalText
	 * @param output Archivo en el cual se escribir� el contenido de finalText
	 */
	public void add(File output){
		try {
			scanner = new Scanner(finalText);
			FileWriter writer = new FileWriter(output);
			String text = "";
			
			while (scanner.hasNext()){
				text = scanner.next();
				writer.write(text);
				if (scanner.hasNext()){
					writer.write(" ");
				}
			}	
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en operaci�n de E/S", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Funci�n que devuelve en un String el contenido de un fichero de texto
	 * @param input
	 * @return
	 */
	public String fileToString (File input){
		String text = "";
		Scanner scanner;
		try {
			scanner = new Scanner(input);
			while (scanner.hasNext()){
				text = text + scanner.next() + " ";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fichero no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return text;
	}
}
