package Model.Estructuras;

public class Cola<T extends Integer>{

	/**
	 * Primer nodo de la cola
	 */
	private Nodo<T> primero;
	
	/**
	 * Ultimo nodo de la cola
	 */
	private Nodo<T> ultimo;
	
	/**
	 * Tamano de la cola
	 */
	private int size;
	
	/**
	 * Metodo que retorna el tamano de la cola
	 * @return Size de la cola
	 */
	public int size(){
		return size;
	}
	
	/**
	 * Metodo que retorna el estado de la cola
	 * @return True si esta vacia, false en caso contrario
	 */
	public boolean isEmpty(){
		return size==0;
	}
	
	/**
	 * Metodo que agrega un elemento al final de la cola
	 * @param item Elemento que sera contenido al final de la cola
	 */
	public void enqueue(T item){
		Nodo<T> nuevo = new Nodo<T>(item);
		Nodo<T> elUltimo = ultimo;
		ultimo = nuevo; 
		if(isEmpty()) primero=ultimo;
		else  elUltimo.siguiente = ultimo;
		size++;
	}
	
	/**
	 * Metodo que saca el elemento de la cabeza de la cola
	 * @return Elemento de la cabeza de la cola
	 */
	public T dequeue(){
		T elem = primero.elem;
		primero = primero.siguiente;
		if(isEmpty())ultimo = null;
		size--;
		return elem;
	}
	
	private class Nodo <T>{

		Nodo<T> siguiente;
		
		T elem;
		
		public Nodo(T elem) 
		{
			this.elem = elem;
		}
		 
	}
	
	public static void main(String[] args) {
		Cola<Integer> c = new Cola<Integer>();
		for (int i = 0; i < 10; i++) {
			c.enqueue(i);
		}
		while(c.size!=0){
			System.out.println(c.dequeue());
		}
	}
}
