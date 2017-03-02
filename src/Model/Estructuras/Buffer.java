package Model.Estructuras;


public class Buffer {
	// Tama�o del buffer
	private  int size; 
	// Entero con la informaci�n del index actual en el que se puede almacenar info.
	private int index;
	// entero que dice cuantos elementos tiene el buffer realmente.
	private int agregados;
	//Arreglo d�nde se guarda los mensajes en formato String.
	private Mensaje[] buffer;

	private Cola<Integer> indexIn;
	
	private Cola<Integer> indexOut;

	public Buffer(int tamano) {
		agregados=0;
		index=0;
		size=tamano;
		buffer= new Mensaje[size];
		indexOut = new Cola<Integer>();
		indexIn = new Cola<Integer>();
		for (int i = 0; i < size; i++) {
			indexIn.enqueue(i);
		}
	}

	public synchronized void escribir(Mensaje m) throws InterruptedException{
		if (agregados<size-1){
			notifyAll();	
		}
		while(agregados==size){
			wait();
		}
		index = indexIn.dequeue();
		buffer[index]=m;
		indexOut.enqueue(index);
		agregados++;
	}

	public synchronized Mensaje leer() throws InterruptedException{
		if (agregados>1){
			notifyAll();
		}
		while(agregados==0){
			wait();
		}
		index = indexOut.dequeue();
		indexIn.enqueue(index);
		agregados--;
		return buffer[index];
	}
}