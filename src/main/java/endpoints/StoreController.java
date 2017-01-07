package endpoints;

import bl.ProductRetriever;
import bl.StoreRetriever;
import domain.Product;
import domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreController {

    @Autowired
    StoreRetriever storeRetriever;

    @Autowired
    ProductRetriever productRetriever;

    @RequestMapping(value = "/store", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Store> findAllStores() {
        List<Store> all = storeRetriever.getStores();
        return all;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAllProducts () {
        List<Product> all = productRetriever.getProducts();
        return all;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findProduct(@PathVariable("productId") int productId) {
        Product all = productRetriever.getProduct(productId);
        return all;
    }

    @RequestMapping(value = "/store/{storeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Store findStore(@PathVariable("storeId") int storeId) {
        Store all = storeRetriever.getStore(storeId);
        return all;
    }

    @RequestMapping(value = "/store/{storeId}/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findStoreProducts(@PathVariable("storeId") int storeId) {
        List<Product> all = productRetriever.getProductsByStoreId(storeId);
        return all;
    }

}