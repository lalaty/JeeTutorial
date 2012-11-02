package net.ensode.glassfishbook.formhandling;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 11/2/12
 * Time: 4:46 PM
 */
public class FormHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String enteredValue;
        enteredValue = httpServletRequest.getParameter("enteredValue");
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter;
        try {
            printWriter = httpServletResponse.getWriter();
            printWriter.println("<p>");
            printWriter.println("You entered: ");
            printWriter.println(enteredValue);
            printWriter.println("<p>");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
