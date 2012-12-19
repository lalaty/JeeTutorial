package net.ensode.glassfishbook.entityrelationships;

import net.ensode.glassfishbook.jpa.Customer;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: edgortiz
 * Date: 12/5/12
 * Time: 11:47 AM
 */
@Entity
@Table(name = "LOGIN_INGO")
public class LoginInfo {

    @Id
    @Column(name = "LOGIN_INFO_ID")
    private Long loginInfoId;
    @Column(name = "LOGIN_NAME")
    private String loginName;
    private String password;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public Long getLoginInfoId() {
        return loginInfoId;
    }

    public void setLoginInfoId(Long loginInfoId) {
        this.loginInfoId = loginInfoId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
