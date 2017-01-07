package graphql.fetchers;

import bl.ProductRetriever;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ProductDataFetcher implements DataFetcher, ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        ProductRetriever productRetriever = context.getBean(ProductRetriever.class);
        int product_id = environment.getArgument("product_id");
        domain.Product product = productRetriever.getProduct(product_id);

        return product;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
