package domain;

import graphql.fetchers.ProductStoreFetcher;
import graphql.annotations.GraphQLDataFetcher;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import graphql.annotations.GraphQLType;

@GraphQLType
public class Product {
    @GraphQLField
    @GraphQLName("product_id")
    private int id;

    @GraphQLField
    private int store_id;

    @GraphQLField
    @GraphQLDataFetcher(ProductStoreFetcher.class)
    private Store store;

    @GraphQLField
    private String name;

    @GraphQLField
    private String description;

    @GraphQLField
    private double price;

    @GraphQLField
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }


}
