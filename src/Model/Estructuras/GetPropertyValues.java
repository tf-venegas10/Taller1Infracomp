/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Estructuras;

import java.io.*;
//import java.time.Clock;
import java.util.*;

/**
 *
 * @author e.dalel10
 */
public class GetPropertyValues {
	InputStream inputStream;
        int [] resp= new int[4];
	public int [] getPropValues() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
                            System.out.println(
                                System.getProperty("java.class.path"));
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			String tamanoBuffer = prop.getProperty("tamanoBuffer");
			String numClient = prop.getProperty("numClient");
			String numServ = prop.getProperty("numServ");
			String numMens = prop.getProperty("numMens");
                        
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
