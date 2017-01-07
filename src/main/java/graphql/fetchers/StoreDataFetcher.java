package graphql.fetchers;

import bl.StoreRetriever;
import domain.Store;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class StoreDataFetcher implements DataFetcher, ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public Object get(DataFetchingEnvironment environment) {
        StoreRetriever productRetriever = context.getBean(StoreRetriever.class);
        int store_id = environment.getArgument("store_id");
        Store product = productRetriever.getStore(store_id);

        return product;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
