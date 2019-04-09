package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Order;
import vu.lt.persistence.OrdersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Model
public class Orders {

    @Inject
    private OrdersDAO ordersDAO;

    @Getter @Setter
    private Order orderToCreate = new Order();

    @Getter
    private List<Order> allOrders;

    @PostConstruct
    public void init(){
        loadAllOrders();
    }

    @Transactional
    public String createOrder(){
        orderToCreate.setDate(new Timestamp(new Date().getTime()));
        this.ordersDAO.persist(orderToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllOrders(){
        this.allOrders = ordersDAO.loadAll();
    }
}
