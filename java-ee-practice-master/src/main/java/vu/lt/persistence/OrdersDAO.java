package vu.lt.persistence;

import vu.lt.entities.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class OrdersDAO {

    @Inject
    private EntityManager em;

    public List<Order> loadAll() {
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Order order){
        this.em.persist(order);
    }

    public Order findOne(Integer id) {
        return em.find(Order.class, id);
    }
}
