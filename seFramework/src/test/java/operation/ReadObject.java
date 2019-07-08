package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadObject {
	
	Properties prop = new Properties();
	
	public Properties getObjectRepository() throws IOException
	{	
	//File srcProp = new File(System.getProperty("user.dir")+"\\seFramework\\src\\test\\java\\objects\\object.properties");
	
	File srcProp = new File("C:\\Users\\Srikanth\\git\\SeFramework\\seFramework\\src\\test\\java\\objects\\object.properties");
	
	
	FileInputStream pFile = new FileInputStream(srcProp);
	
	prop.load(pFile);
	
	return prop;
	
	}	

}
