package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Helper {
	static String filePath = System.getProperty("user.dir")+"\\data.properties";
	
	public static String readDataFile(String key) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		System.out.println("The value fetched is "+ value);
		return value;
	}
	
	
	
}
