package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Order;
import vu.lt.entities.Player;
import vu.lt.entities.Team;
import vu.lt.persistence.OrdersDAO;
import vu.lt.persistence.PlayersDAO;
import vu.lt.persistence.ProductsDAO;
import vu.lt.persistence.TeamsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class OrderSpecific implements Serializable {

    @Inject
    private OrdersDAO ordersDAO;

    @Getter @Setter
    private Order order;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer orderId = Integer.parseInt(requestParameters.get("orderId"));
        this.order = ordersDAO.findOne(orderId);
    }
}
