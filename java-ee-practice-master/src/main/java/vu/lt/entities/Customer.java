package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer as c")
})
@Table(name = "CUSTOMER")
@Getter @Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;

    private String country;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer cust = (Customer) o;
        return Objects.equals(id, cust.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
