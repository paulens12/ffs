package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Product;
import vu.lt.persistence.ProductsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class Products {

    @Inject
    private ProductsDAO productsDAO;

    @Getter @Setter
    private Product productToCreate = new Product();

    @Getter
    private List<Product> allProducts;

    @PostConstruct
    public void init(){
        loadAllProducts();
    }

    @Transactional
    public String createProduct(){
        this.productsDAO.persist(productToCreate);
        return "index?faces-redirect=true";
    }

    public String getFriendlyName(Product prod){
        return prod.getName() + " - " + prod.getPrice() + " - " + prod.getStock() + " - " + prod.getDescription();
    }

    private void loadAllProducts(){
        this.allProducts = productsDAO.loadAll();
    }
}
