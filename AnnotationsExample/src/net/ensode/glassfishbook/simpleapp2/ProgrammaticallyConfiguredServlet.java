package net.ensode.glassfishbook.simpleapp2;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 11/7/12
 * Time: 5:29 PM
 */
public class ProgrammaticallyConfiguredServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.println("This message was generated form a servlet that was configured programmatically.");
    }
}
