package net.ensode.glassfishbook.customtags;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 12/4/12
 * Time: 11:48 AM
 */
public class CustomTagDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        AddressBean addressBean = new AddressBean();
        addressBean.setLine1("43623 Park Ridge Ct");
        addressBean.setCity("Orlando");
        addressBean.setState("FL");
        addressBean.setZip("00303");
        httpServletRequest.setAttribute("address", addressBean);
        try {
            httpServletRequest.getRequestDispatcher("customtags2.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
