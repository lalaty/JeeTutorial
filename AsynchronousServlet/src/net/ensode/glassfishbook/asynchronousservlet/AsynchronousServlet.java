package net.ensode.glassfishbook.asynchronousservlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 11/7/12
 * Time: 6:05 PM
 */
@WebServlet(
        name = "AsynchonousServlet",
        urlPatterns = "/AsynchonousServlet",
        asyncSupported = true
)
public class AsynchronousServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final Logger logger = Logger.getLogger(AsynchronousServlet.class.getName());
        logger.log(Level.INFO, "--- Entering doGet()");
        final AsyncContext asyncContext = httpServletRequest.startAsync();
        logger.log(Level.INFO, "---- inovking ac.start()");
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                logger.log(Level.INFO, "inside thread");
                try {
                    //simulate a long running process.
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Logger.getLogger(AsynchronousServlet.class.getName()).log(Level.SEVERE, null, e);
                }
                try {
                    asyncContext.getResponse().getWriter().println("You should see this after a brief wait");
                    asyncContext.complete();
                } catch (IOException e) {
                    Logger.getLogger(AsynchronousServlet.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        });
        logger.log(Level.INFO, "leaving doGet()");
    }
}
