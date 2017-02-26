package Model.Estructuras;

import java.util.Queue;

public class Buffer {
	/**
	 * Tama�o del buffer
	 */
	private  int size; 
	/**
	 * Entero con la informaci�n del index actual en el que se puede almacenar info.
	 */
	private int index;
	
	/**
	 * Arreglo d�nde se guarda los mensajes en formato String.
	 */
	private String[] buffer;
	
	public Buffer(int tamano) {
		size=tamano;
		buffer= new String[size];
	}
}
