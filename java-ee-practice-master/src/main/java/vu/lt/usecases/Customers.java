package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Customer;
import vu.lt.persistence.CustomersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class Customers {

    @Inject
    private CustomersDAO customersDAO;

    @Getter @Setter
    private Customer customerToCreate = new Customer();

    @Getter
    private List<Customer> allCustomers;

    @PostConstruct
    public void init(){
        loadAllCustomers();
    }

    @Transactional
    public String createCustomer(){
        this.customersDAO.persist(customerToCreate);
        return "index?faces-redirect=true";
    }

    public String getFriendlyName(Customer cust)
    {
        return cust.getFirstName() + " " + cust.getLastName();
    }
    private void loadAllCustomers(){
        this.allCustomers = customersDAO.loadAll();
    }
}
