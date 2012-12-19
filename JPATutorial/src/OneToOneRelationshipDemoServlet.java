import net.ensode.glassfishbook.entityrelationships.LoginInfo;
import net.ensode.glassfishbook.jpa.Customer;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 12/5/12
 * Time: 11:58 AM
 */
public class OneToOneRelationshipDemoServlet extends HttpServlet {

    @PersistenceUnit(unitName = "customerPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Customer customer;
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginInfoId(1L);
        loginInfo.setLoginName("juan");
        loginInfo.setPassword("password");
        try {
            userTransaction.begin();
            customer = entityManager.find(Customer.class, 4L);
            loginInfo.setCustomer(customer);
            entityManager.persist(loginInfo);
            userTransaction.commit();
            httpServletResponse.getWriter().println("Database updated succesfully");
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        }
    }

}
