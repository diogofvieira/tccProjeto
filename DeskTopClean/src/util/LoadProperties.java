package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	static Properties props = new Properties();
	static final String FILE = "./propriedades.properties";
	
	public static Properties getProp(){
		try {
			FileInputStream file = new FileInputStream(FILE);
			props.load(file);
			return props;
		} catch (IOException e) {
			e.printStackTrace();
			return props;
		}
	}
	
	public static void saveProp() throws IOException{
		try {
			FileOutputStream fos = new FileOutputStream(FILE);
			props.store(fos, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}