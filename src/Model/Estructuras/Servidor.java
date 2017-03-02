package Model.Estructuras;

import java.util.Random;

public class Servidor extends Thread {
	

	private Buffer buffer;
	
	public static final String[] respuestas= {"1","2","3"};
	
	public Servidor(Buffer buff) {
		buffer= buff;
	}
	
	@Override
	public void run() {
		Mensaje m;
		String respuesta ;
		while(true){
			try {
				m= buffer.leer();
				respuesta = respuestas[m.leerPedido().compareTo("A")];
				m.responderPedido(respuesta);
				Servidor.yield();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
