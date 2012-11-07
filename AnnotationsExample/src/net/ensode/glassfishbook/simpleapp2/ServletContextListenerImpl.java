package net.ensode.glassfishbook.simpleapp2;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 11/7/12
 * Time: 5:27 PM
 */
@WebListener()
public class ServletContextListenerImpl implements ServletContextListener {

    private static final String PROGRAMMATICALLY_CONFIGURED_SERVLET = "ProgrammaticallyConfiguredServlet";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        try {
            ProgrammaticallyConfiguredServlet servlet = servletContext.createServlet(ProgrammaticallyConfiguredServlet.class);
            servletContext.addServlet("ProgrammaticallyConfiguredServlet", servlet);
            ServletRegistration servletRegistration = servletContext.getServletRegistration(PROGRAMMATICALLY_CONFIGURED_SERVLET);
            servletRegistration.addMapping("/" + PROGRAMMATICALLY_CONFIGURED_SERVLET);
        } catch (ServletException e) {
            servletContext.log(e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

}
