package net.ensode.glassfishbook.formhandling;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 11/7/12
 * Time: 2:56 PM
 */
public class ConfirmationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            PrintWriter printWriter;
            List<String> checkedLabels = (List<String>) httpServletRequest.getAttribute("checkedLabels");
            httpServletResponse.setContentType("text/html");
            printWriter = httpServletResponse.getWriter();
            printWriter.println("<p>");
            printWriter.print("The following options were selected: ");
            printWriter.println("<br/>");
            if (checkedLabels != null) {
                for (String optionLabel : checkedLabels) {
                    printWriter.print(optionLabel);
                    printWriter.println("<br/>");
                }
            } else {
                printWriter.println("None");
            }
            printWriter.println("</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
