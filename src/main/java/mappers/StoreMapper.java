package mappers;


import domain.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")

public interface StoreMapper {
    @Mappings({
            @Mapping(source = "id", target = "id")
    })
    Store storeToStoreApi(jpa.Store car);
    List<Store> storesToStoresApi(List<jpa.Store> car);
}
