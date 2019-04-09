package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select p from Product as p")
})
@Table(name = "PRODUCT")
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private float price;
    private String description;
    private Integer stock;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product prod = (Product) o;
        return Objects.equals(id, prod.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
