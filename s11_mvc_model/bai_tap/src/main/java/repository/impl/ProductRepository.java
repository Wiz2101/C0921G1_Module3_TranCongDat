package repository.impl;


import bean.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepository implements IProductRepository {
    public static Map<Integer,Product> productMap;

    static {
        productMap = new TreeMap<>();
        productMap.put(1,new Product(1,"FL680","5","120.5","65% Layout"));
        productMap.put(2,new Product(2,"NJ68 Max","3","150.5","65% Layout"));
        productMap.put(3,new Product(3,"AKKO 3068","7","54.5","65% Layout"));
        productMap.put(4,new Product(4,"NJ80","2","170.2","75% Layout"));
        productMap.put(5,new Product(5,"GMMK Pro","3","212.3","75%% Layout"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
