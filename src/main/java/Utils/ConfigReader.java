package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

   private static final Properties properties=new Properties();

    static {
        try (FileInputStream fp=new FileInputStream("src/test/resources/config.properties"))
        {
            properties.load(fp);
        }catch (FileNotFoundException e)
        {
            throw new RuntimeException("File Not found",e);
        }

        catch (IOException e)
        {
            throw new RuntimeException("Error while reading config.properties.",e);
        }


    }

    public static String  getKey(String key)
    {
        String value=properties.getProperty(key);


        if(value==null)
        {
            throw new RuntimeException("Key not found in config.properties: "+ key);
        }
        return value;
    }


}

