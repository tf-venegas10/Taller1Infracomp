package Model.Estructuras;

import java.util.Random;

public class Cliente extends Thread {
	
	private Buffer buffer;
	
	public final static String[] messages={"A","B","C"};
	
	public Cliente(Buffer buff) {
		buffer=buff;
	}
	
	@Override
	public void run() {
		Random rand= new Random();
		String m= messages[rand.nextInt(messages.length)];
		Mensaje mensaje= new Mensaje(m,buffer);
		try {
			String resp= mensaje.hacerPedido();
			
			System.out.println("Recibi respuesta a mi mensaje!");
			System.out.println("Mi pregunta: "+m);
			System.out.println("Mi respuesta: "+ resp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
