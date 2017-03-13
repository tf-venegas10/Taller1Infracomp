/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Estructuras;

import java.io.*;
//import java.time.Clock;
import java.util.*;


public class GetPropertyValues {
	
	public static final String CASO1 = "data/caso1.properties";
	public static final String CASO2 = "data/caso2.properties";
	public static final String CASO3 = "data/caso3.properties";
	public static final String CASO4 = "data/caso4.properties";
	
	
	private FileInputStream fis;
	private int [] resp= new int[4];
	
	public int [] getPropValues(String caso) throws IOException {

		try {
			Properties prop = new Properties();
			fis = new FileInputStream(caso);
			prop.load(fis);

			String tamanoBuffer = prop.getProperty("tamanoBuffer");
			String numClient = prop.getProperty("numClient");
			String numServ = prop.getProperty("numServ");
			String numMens = prop.getProperty("cantMensajes");

			//pone en resp los properties leidos
			resp [0] = Integer.parseInt(tamanoBuffer);
			resp [1] = Integer.parseInt(numClient);
			resp [2] = Integer.parseInt(numServ);
			resp [3] = Integer.parseInt(numMens);


		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} //finally {
		//inputStream.close();
		//}
		return resp;
	}
}
