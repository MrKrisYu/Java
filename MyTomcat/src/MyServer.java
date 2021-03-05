import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Kris
 * @Date: 2021/3/5 - 03 - 05 - 20:46
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class MyServer {

    public static void startServe(int port) throws Exception{
        // 定义服务套接字
        ServerSocket serverSocket = new ServerSocket(port);
        // 定义客户端
        Socket socket = null;

        while(true){
            // 侦听客户端
            socket = serverSocket.accept();

            // 获取输入、输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // 定义请求对象
            MyRequest request = new MyRequest(inputStream);
            MyResponse response = new MyResponse(outputStream);

            // 定义反射类
            String clazz = new MyMapping().getMapping().get(request.getRequestUrl());
            if(clazz!=null){
                Class<MyServlet> myServletClass = (Class<MyServlet>)Class.forName(clazz);
                // 根据myServletClass创建对象
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.service(request, response);

            }

        }

    }

    public static void main(String[] args) {
        try {
            startServe(10086);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
