import java.util.HashMap;

/**
 * @Author: Kris
 * @Date: 2021/3/5 - 03 - 05 - 20:42
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class MyMapping {
    public static HashMap<String, String> mapping = new HashMap<String,String>();

    static{
        mapping.put("/mytomcat", "MyServlet");

    }

    public HashMap<String, String> getMapping() {
        return mapping;
    }
}
