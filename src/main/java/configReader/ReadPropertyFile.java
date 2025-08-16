package configReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	public static String getProperty(String key) {
        Properties prop = new Properties();
        String value = null;
        try {
            // Get the project path dynamically
            String projectPath = System.getProperty("user.dir");
            FileInputStream fis = new FileInputStream(projectPath + "/src/main/resources/dataFiles/config.properties"); // Adjust path as needed
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
	
	
	public static String getAPIProperty(String key) {
        Properties prop = new Properties();
        String value = null;
        try {
            // Get the project path dynamically
            String projectPath = System.getProperty("user.dir");
            FileInputStream fis = new FileInputStream(projectPath + "/src/main/resources/dataFiles/configAPI.properties"); // Adjust path as needed
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
