package Model.Estructuras;

import java.util.Random;

public class Servidor extends Thread {
	

	private Buffer buffer;
	
	private static String[] respuestas= {"1","2","3"};
	
	public Servidor(Buffer buff) {
		buffer= buff;
	}
	
	@Override
	public void run() {
		Mensaje m;
		Random r= new Random();
		String respuesta ;
		while(true){
			try {
				m= buffer.leer();
				respuesta = respuestas[r.nextInt(respuestas.length)];
				m.responderPedido(respuesta);
				Servidor.yield();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
