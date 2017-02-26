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
	
	/**
	 * Objeto que sirve como cola de espera para los consumidores.
	 */
	private Object esperaConsumidores;
	/**
	 * Objeto que sirve como cola de espera para los productores.
	 */
	private Object esperaProductores;
	
	
	public Buffer(int tamano) {
		agregados=0;
		index=0;
		size=tamano;
		buffer= new Mensaje[size];
	}
	
	public synchronized void escribir(Mensaje m) throws InterruptedException{
		if (agregados==0){
			synchronized (esperaProductores) {
			esperaProductores.notifyAll();	
			}
		}
		while(agregados==size){
			synchronized (esperaConsumidores) {
				esperaConsumidores.wait();
			}
		}
		buffer[index]=m;
		index=(index+1)%size;
		agregados++;
	}
	
	public synchronized Mensaje leer() throws InterruptedException{
		if (agregados==size){
			synchronized (esperaConsumidores) {
				esperaConsumidores.notifyAll();
			}
		}
		while(agregados==0){
			synchronized (esperaProductores) {
				esperaProductores.wait();
			}
		}
		int i = index;
		index= (index+1) % size;
		agregados--;
		return buffer[i];
	}
}
