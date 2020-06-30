package scenarios.scn_1;

import java.io.InputStream;
import java.util.Properties;

public class TestBase_1 {
	    
	    protected String serverUI = LoadProperties().getProperty("url");
	    
		public Properties LoadProperties() {

			try {
				InputStream inStream = getClass().getClassLoader().getResourceAsStream("config.properties");
				Properties prop = new Properties();
				prop.load(inStream);
				return prop;
			}catch(Exception e) {
				System.out.println("File not found exception thrown for config.properties file.");
				return null;
			}

		}
}
