package vu.lt.persistence;

import vu.lt.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class ProductsDAO {

    @Inject
    private EntityManager em;

    public List<Product> loadAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Product prod){
        this.em.persist(prod);
    }

    public Product findOne(Integer id) {
        return em.find(Product.class, id);
    }
}
