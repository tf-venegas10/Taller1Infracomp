package Model.Estructuras;


public class Buffer {
	/**
	 * Tamaño del buffer
	 */
	private  int size; 
	/**
	 * Entero con la información del index actual en el que se puede almacenar info.
	 */
	private int index;
	/**
	 * entero que dice cuantos elementos tiene el buffer realmente. 
	 */
	private int agregados;
	/**
	 * Arreglo dónde se guarda los mensajes en formato String.
	 */
	private Mensaje[] buffer;
	

	
	public Buffer(int tamano) {
		
		agregados=0;
		index=0;
		size=tamano;
		buffer= new Mensaje[size];
	}
	
	public synchronized void escribir(Mensaje m) throws InterruptedException{
		if (agregados==0){
			
			notifyAll();	
			
		}
		while(agregados==size){
			wait();
		}
		buffer[index]=m;
		index=(index+1)%size;
		agregados++;
	}
	
	public synchronized Mensaje leer() throws InterruptedException{
		if (agregados==size){
			notifyAll();
		}
		while(agregados==0){
			wait();
		}
		int i = index;
		index= (index+1) % size;
		agregados--;
		return buffer[i];
	}
}
