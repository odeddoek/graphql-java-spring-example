package bl;

import domain.Store;
import jpa.StoreRepository;
import mappers.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreRetriever {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreMapper storeMapper;

    public List<Store> getStores() {
        List<jpa.Store> all = storeRepository.findAll();
        List<Store> stores = storeMapper.storesToStoresApi(all);
        return stores;
    }

    public Store getStore(int storeId) {
        jpa.Store all = storeRepository.findByid(storeId);
        Store store = storeMapper.storeToStoreApi(all);
        return store;
    }
}
