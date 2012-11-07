package net.ensode.glassfishbook.formhandling;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 11/7/12
 * Time: 12:27 PM
 */
public class MultipleValueFieldHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String[] selectedOptions = httpServletRequest.getParameterValues("options");
        ArrayList<String> selectedOptionLabels = null;
        if (selectedOptions != null) {
            selectedOptionLabels = new ArrayList<String>(selectedOptions.length);
            for (String selectedOption : selectedOptions) {
                switch (selectedOption) {
                    case "option1":
                        selectedOptionLabels.add("Option 1");
                        break;
                    case "option2":
                        selectedOptionLabels.add("Option 2");
                        break;
                    case "option3":
                        selectedOptionLabels.add("Option 3");
                        break;
                }
            }
        }
        httpServletRequest.setAttribute("checkedLabels", selectedOptionLabels);
        try {
            httpServletRequest.getRequestDispatcher("confirmationservlet").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
