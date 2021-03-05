import java.io.OutputStream;

/**
 * @Author: Kris
 * @Date: 2021/3/5 - 03 - 05 - 20:32
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String str) throws Exception{
        StringBuilder builder = new StringBuilder();

        builder.append("HTTP/1.1 200 OK\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>" + str + "</h1>")
                .append("<body>")
                .append("<html>");
        this.outputStream.write(builder.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();

    }
}
