/**
 * @Author: Kris
 * @Date: 2021/3/5 - 03 - 05 - 20:36
 * @Description: 抽象HttpServlet类，规范Post和Get操作
 * @version: 1.0
 */


public abstract class MyHttpServlet {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    public abstract void doGet(MyRequest request, MyResponse response) throws Exception;
    public abstract void doPost(MyRequest request, MyResponse response) throws Exception;

    /**
     *  根据请求方式，判断调用那种处理方法
     * @param request
     * @param response
     * @throws Exception
     */
    public void service(MyRequest request, MyResponse response) throws Exception{
        if(METHOD_GET.equals(request.getRequestMethod())){
            doGet(request,response);
        }else if(METHOD_POST.equals(request.getRequestMethod())){
            doPost(request,response);
        }else{
            System.err.println(Thread.currentThread().getName()+"Wrong Method Name");
        }


    }

}
