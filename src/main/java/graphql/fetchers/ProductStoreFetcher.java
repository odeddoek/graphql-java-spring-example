package graphql.fetchers;

import bl.StoreRetriever;
import domain.Product;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ProductStoreFetcher implements DataFetcher, ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        StoreRetriever storeRetriever = context.getBean(StoreRetriever.class);
        Product source = (Product) environment.getSource();
        return storeRetriever.getStore(source.getStore_id());

//        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
