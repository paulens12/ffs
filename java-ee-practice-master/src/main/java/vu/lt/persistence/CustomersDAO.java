package vu.lt.persistence;

import vu.lt.entities.Customer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class CustomersDAO {

    @Inject
    private EntityManager em;

    public List<Customer> loadAll() {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Customer cust){
        this.em.persist(cust);
    }

    public Customer findOne(Integer id) {
        return em.find(Customer.class, id);
    }
}
