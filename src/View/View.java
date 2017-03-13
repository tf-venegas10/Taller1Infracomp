package View;
import Controler.Controler;
import Model.Estructuras.GetPropertyValues;
import java.io.IOException;
public class View {

	public static void main(String[] args) throws IOException{
		
		try{
		GetPropertyValues properties = new GetPropertyValues();
		
		System.out.println("\n---------------------\nCaso1\n---------------------\n");
		int params [] = properties.getPropValues(GetPropertyValues.CASO1);
		Controler.playGround(params);
		
		Thread.sleep(5000);
		
		System.out.println("\n---------------------\nCaso2\n---------------------\n");
		params = properties.getPropValues(GetPropertyValues.CASO2);
		Controler.playGround(params);
		
		Thread.sleep(5000);
		
		System.out.println("\n---------------------\nCaso3\n---------------------\n");
		params = properties.getPropValues(GetPropertyValues.CASO3);
		Controler.playGround(params);
		
		Thread.sleep(5000);
		
		System.out.println("\n---------------------\nCaso4\n---------------------\n");
		params = properties.getPropValues(GetPropertyValues.CASO4);
		Controler.playGround(params);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
