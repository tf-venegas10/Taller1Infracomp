package Model.Estructuras;

public class Mensaje  {
         //String que modela la solicitud del usuario

	private String request;
	//String que modela la respuesta del serivdor

	private String response;

	 //Atributo que apunta al buffer donde se quiere almancenar el mensaje.

	private Buffer buffer;
	
	public Mensaje(String pedido, Buffer buff) {
		buffer=buff;
		request=pedido;
		response= null;
	}
	
	public synchronized String hacerPedido() throws InterruptedException{
		buffer.escribir(this);
		while(response==null){
			wait();
		}
		return response;
	}
	
	public synchronized String leerPedido(){
		return request;
	}
	
	public synchronized void responderPedido(String respuesta){
		response=respuesta;
		notify();
	}

}
