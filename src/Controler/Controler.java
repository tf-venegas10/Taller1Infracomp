package Controler;

import Model.Estructuras.Buffer;
import Model.Estructuras.Cliente;
import Model.Estructuras.Servidor;

public class Controler {

	public static void playGround(){
		Buffer buff= new Buffer(10);
		Servidor s;
		Cliente c;
		for (int i = 0; i < 10; i++) {
			s= new Servidor(buff);
			s.start();
		}
		for (int i = 0; i < 100; i++) {
			c= new Cliente(buff,i);
			c.start();
		}
	}
}
