package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {
        prop = new Properties();
        try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}
	
	public String getBaseUrl() {
		String url = prop.getProperty("baseurl");
		return url;
	}
}