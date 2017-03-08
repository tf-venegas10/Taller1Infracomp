package Controler;

import Model.Estructuras.Buffer;
import Model.Estructuras.Cliente;
import Model.Estructuras.Servidor;

public class Controler {

	public static void playGround(int [] params){

                int tamBuff = params[0];
                int numServ = params[2];
                int numClien= params[1];
                
		Buffer buff= new Buffer(tamBuff);
		Servidor s;
		Cliente c;
		for (int i = 0; i < numServ; i++) {
			s= new Servidor(buff);
			s.start();
		}
		for (int i = 0; i < numClien; i++) {
			c= new Cliente(buff,i);
			c.start();
		}
	}
  
}
