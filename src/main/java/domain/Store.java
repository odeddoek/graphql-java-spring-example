package domain;

import graphql.fetchers.StoreProductsFetcher;
import graphql.annotations.GraphQLDataFetcher;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLType;

import java.util.List;

@GraphQLType
public class Store {
    @GraphQLField
    private int id;

    @GraphQLField
    private String name;

    @GraphQLField
    private String address;

    @GraphQLField
    private int owner;

    @GraphQLField
    private int creation_date;

    @GraphQLField
    @GraphQLDataFetcher(StoreProductsFetcher.class)
    private List<Product> products;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(int creation_date) {
        this.creation_date = creation_date;
    }


}
