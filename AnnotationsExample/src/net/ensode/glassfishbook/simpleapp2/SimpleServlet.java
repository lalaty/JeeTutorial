package net.ensode.glassfishbook.simpleapp2;

import javax.servlet.ServletException;
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
 * Time: 3:58 PM
 */

@WebServlet(urlPatterns = {"/simpleservlet", "*.foo"})
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            httpServletResponse.setContentType("text/html");
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.println("<h2>");
            printWriter.println("If you are reading this, you aplication server is good to go");
            printWriter.println("</h2>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
