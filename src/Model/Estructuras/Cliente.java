package Model.Estructuras;

import java.util.Random;

public class Cliente extends Thread {
	
	private Buffer buffer;
	
	private int id;
	
	public final static String[] messages={"A","B","C"};
	
	public Cliente(Buffer buff, int id) {
		buffer=buff;
		this.id = id;
	}
	
	@Override
	public void run() {
		Random rand= new Random();
		String m= messages[rand.nextInt(messages.length)];
		Mensaje mensaje= new Mensaje(m,buffer);
		try {
			String resp= mensaje.hacerPedido();
			synchronized(System.class){
			System.out.println("Soy el cliente: "+id+"\nRecibi respuesta a mi mensaje!");
			System.out.println("Mi pregunta: "+m);
			System.out.println("Mi respuesta: "+ resp);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
