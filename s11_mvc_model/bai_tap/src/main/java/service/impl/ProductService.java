package service.impl;

import bean.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductService implements IProductService {

    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        this.iProductRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        this.iProductRepository.remove(id);
    }
}
