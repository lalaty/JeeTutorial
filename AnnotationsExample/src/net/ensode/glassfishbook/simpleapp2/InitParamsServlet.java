package net.ensode.glassfishbook.simpleapp2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 11/7/12
 * Time: 4:45 PM
 */
@WebServlet(
        name = "InitParamsServlet",
        urlPatterns = "/InitParamsServlet",
        initParams = {
                @WebInitParam(
                        name = "param1",
                        value = "value1"
                ),
                @WebInitParam(
                        name = "param2",
                        value = "value2"
                )
        }
)
public class InitParamsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String param1Val = servletConfig.getInitParameter("param1");
        String param2Val = servletConfig.getInitParameter("param2");
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("<p>");
        printWriter.println("Value of param1 is " + param1Val);
        printWriter.println("</p>");
        printWriter.println("<p>");
        printWriter.println("Value of param2 is " + param2Val);
        printWriter.println("</p>");
    }
}
