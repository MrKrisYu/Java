/**
 * @Author: Kris
 * @Date: 2021/3/5 - 03 - 05 - 20:44
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class MyServlet extends MyHttpServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.write("Get myTomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("post MyTomcat");
    }
}
