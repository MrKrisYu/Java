import java.io.InputStream;

/**
 * @Author: Kris
 * @Date: 2021/3/5 - 03 - 05 - 20:18
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class MyRequest {
    private String requestMethod ; // 请求方法 GET/POST

    private String requestUrl ; // 请求地址

    public MyRequest(InputStream inputStream) throws Exception{
        // 缓冲区域
        byte[] buffer = new byte[1024];
        // 数据长度
        int len = 0;
        // 封装请求为字符串
        String str = null;

        if((len=inputStream.read(buffer))>0){
            str = new String(buffer, 0, len);

        }
        // 解析请求: GET/HTTP/1.1
        String data  = str.split("\n")[0];
        String[] params = data.split(" ");
        this.requestMethod = params[0];
        this.requestUrl=params[1];


    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
