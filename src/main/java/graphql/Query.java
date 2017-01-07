package graphql;

import domain.Product;
import domain.Store;
import graphql.annotations.GraphQLDataFetcher;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import graphql.fetchers.ProductDataFetcher;
import graphql.fetchers.ProductsDataFetcher;
import graphql.fetchers.StoreDataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query {

    @GraphQLField
    @GraphQLDataFetcher(ProductDataFetcher.class)
    public Product product(@GraphQLName("product_id") int product_id) {
        return null;
    }

    @GraphQLField
    @GraphQLDataFetcher(StoreDataFetcher.class)
    public Store store(@GraphQLName("store_id") int store_id) {
        return null;
    }

    @GraphQLField
    @GraphQLDataFetcher(ProductsDataFetcher.class)
    public List<Product> products() { return null;}
}


