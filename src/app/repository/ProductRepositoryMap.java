package app.repository;

import app.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//@Component
@Repository
public class ProductRepositoryMap implements ProductRepository {

    private Map<Long, Product> database = new HashMap<>();

    public ProductRepositoryMap() {
        database.put(1L, new Product(1L, "Apple",new BigDecimal((90))));
        database.put(2L, new Product(2L, "Banana",new BigDecimal((170))));
        database.put(3L, new Product(3L, "Orange",new BigDecimal((210))));
    }

    @Override
    public Product getById(Long id) {
        return database.get(id);
    }
}
