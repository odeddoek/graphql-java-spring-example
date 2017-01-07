package graphql.fetchers;

import bl.ProductRetriever;
import domain.Product;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsDataFetcher implements DataFetcher, ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        ProductRetriever productRetriever = context.getBean(ProductRetriever.class);
        List<Product> product = productRetriever.getProducts();

        return product;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
