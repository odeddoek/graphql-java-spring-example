package bl;

import domain.Product;
import jpa.ProductRepository;
import mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRetriever {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public List<Product> getProducts()
    {
        List<jpa.Product> all = productRepository.findAll();
        List<Product> products = productMapper.productsToProductsApi(all);
        return products;
    }

    public List<Product> getProductsByStoreId(int store_id)
    {
        List<jpa.Product> all = productRepository.findByStore_id(store_id);
        List<Product> products = productMapper.productsToProductsApi(all);
        return products;
    }

    public Product getProduct(int product_id)
    {
        jpa.Product all = productRepository.findByid(product_id);
        Product product = productMapper.productToProductApi(all);
        return product;
    }
}


