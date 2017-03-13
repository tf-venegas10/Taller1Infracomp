package Model.Estructuras;

import java.util.Random;

public class Cliente extends Thread {

	private Buffer buffer;

	private int id;

	private int nMensajes;

	public final static String[] messages={"A","B","C"};

	public Cliente(Buffer buff, int id, int nMensajes) {
		this.nMensajes=nMensajes;
		buffer=buff;
		this.id = id;
	}

	@Override
	public void run() {
		for (int i=0; i< nMensajes; i++){
			Random rand= new Random();
			String m= messages[rand.nextInt(messages.length)];
			Mensaje mensaje= new Mensaje(m,buffer);
			try {
				String resp= mensaje.hacerPedido();
				synchronized(System.class){
					System.out.println("Soy el cliente: "+id+"\nRecibi respuesta a mi mensaje!");
					System.out.println("Mi pregunta No "+(i+1)+" : "+m);
					System.out.println("Mi respuesta: "+ resp);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
