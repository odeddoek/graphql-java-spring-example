package mappers;


import domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source ="store_id", target = "store_id"),
            @Mapping(source ="store", target = "store", ignore = true)
    })
    Product productToProductApi(jpa.Product product);
    List<Product> productsToProductsApi(List<jpa.Product> product);
}
