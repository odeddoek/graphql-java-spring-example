package jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {
    @Id
    private int id;

    @JoinColumn(name = "store_id", foreignKey = @ForeignKey(name="product_store_fk"))
    @ManyToOne(targetEntity = Store.class, fetch = FetchType.LAZY)
    private Store store;

    @Column(name = "store_id", insertable = false, updatable = false)
    private int store_id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private double score;

    @Column
    @Type(type = "date")
    private Date create_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
}
