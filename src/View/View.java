package View;
import Controler.Controler;
import Model.Estructuras.GetPropertyValues;
import java.io.IOException;
public class View {

	public static void main(String[] args) throws IOException{
            GetPropertyValues properties = new GetPropertyValues();
            
		int params [] = new int[2];
                params=properties.getPropValues();
		Controler.playGround(params);
	}

}
