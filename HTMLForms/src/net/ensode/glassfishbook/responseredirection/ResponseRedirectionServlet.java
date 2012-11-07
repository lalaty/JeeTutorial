package net.ensode.glassfishbook.responseredirection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 11/7/12
 * Time: 3:16 PM
 */
public class ResponseRedirectionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String url = httpServletRequest.getParameter("searchEngine");
        if (url != null) {
            httpServletResponse.sendRedirect(url);
        } else {
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.println("No search engine was selected");
        }
    }

}
