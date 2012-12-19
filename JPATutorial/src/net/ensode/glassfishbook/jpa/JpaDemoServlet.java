package net.ensode.glassfishbook.jpa;

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
 * Time: 11:11 AM
 */
public class JpaDemoServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Customer customer = new Customer();
        customer.setCustomerId(3L);
        customer.setFirstName("Juan");
        customer.setLastName("Perez");
        customer.setEmail("juan@perez.com");
        Customer customer2 = new Customer();
        customer2.setCustomerId(4L);
        customer2.setFirstName("Jose");
        customer2.setLastName("Gonzales");
        customer2.setEmail("jose@gonzales.com");
        Customer customer3;
        try {
            userTransaction.begin();
            entityManager.persist(customer);
            entityManager.persist(customer2);
            customer3 = entityManager.find(Customer.class, 4L);
            customer3.setLastName("Rodriguez");
            entityManager.persist(customer3);
            entityManager.remove(customer);
            userTransaction.commit();
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
