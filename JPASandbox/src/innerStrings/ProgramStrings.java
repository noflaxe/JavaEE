package innerStrings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 18.07.13
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
public class ProgramStrings {
    private static final String filepath = "C:\\Users\\noflaxe\\Desktop\\JPASandbox\\Properties\\ProgramStrings.properties";
    private static final Properties prop;

    static {


        prop = new Properties();
        try {
            prop.load(new FileInputStream(filepath));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }


    public static String getProgramString(String param) {
        return prop.getProperty(param);
    }
}
