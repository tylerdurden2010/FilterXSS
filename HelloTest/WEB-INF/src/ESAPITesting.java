import org.owasp.esapi.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.*;




public class ESAPITesting extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	         throws ServletException, IOException 
	{
	    
		//设置HTTP响应的正文的数据类型
	    response.setContentType("text/html;charset=GB2312");
	    
	    /*输出HTML文档*/
	    PrintWriter out = response.getWriter();
	    out.println("<html><head><title>RequestInfo</TITLE></head>");
	    out.println("<body>");
	    //打印服务器端的IP地址
	    out.println("<br>LocalAddr: "+request.getLocalAddr());
	    //打印服务器端的的主机名
	    out.println("<br>LocalName: "+request.getLocalName());
	    //打印服务器端的的FTP端口号
	    out.println("<br>LocalPort: "+request.getLocalPort());
	    //打印客户端与服务器端通信所用的协议的名称以及版本号
	    out.println("<br>Protocol: "+request.getProtocol());
	    //打印客户端的IP地址
	    out.println("<br>RemoteAddr: "+request.getRemoteAddr());
	    //打印客户端的主机名
	    out.println("<br>RemoteHost: "+request.getRemoteHost());
	    //打印客户端的FTP端口号
	    out.println("<br>RemotePort: "+request.getRemotePort());

	    //打印HTTP请求方式
	    out.println("<br>Method: "+request.getMethod());
	    //打印HTTP请求中的URI
	    out.println("<br>URI: "+request.getRequestURI());
	    //打印客户端所请求访问的Web应用的URL入口
	    out.println("<br>ContextPath: "+request.getContextPath());
	    //打印HTTP请求中的查询字符串
	    out.println("<br>QueryString: "+request.getQueryString());

	    /**打印HTTP请求头*/
	    out.println("<br>***打印HTTP请求头***");
	    Enumeration eu=request.getHeaderNames();
	    while(eu.hasMoreElements()){
	      String headerName=(String)eu.nextElement();
	      out.println("<br>"+headerName+": "+request.getHeader(headerName));
	    }
	    out.println("<br>***打印HTTP请求头结束***<br>");
	    //打印请求参数username
	    String Test = request.getParameter("username");

	    Test = ESAPI.encoder().encodeForHTML(Test);
	    out.println("<br>username: "+Test);
	    out.println("</body></html>");
	    if (Test.equals("END"))
	    {
	    	response.reset();//balabala
	    	
	    	response.sendError(404);
	    	destroy();
	    }
	    //关闭输出流
	    out.close();
	  }

}
