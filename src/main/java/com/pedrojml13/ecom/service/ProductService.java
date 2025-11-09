package com.pedrojml13.ecom.service;

import com.pedrojml13.ecom.model.Product;
import com.pedrojml13.ecom.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @NonNull
    private ProductRepository repository;


    public List<Product> getAllProducts() {
        return repository.findAll();
    }


    public Product getProductById(int id) {

        return repository.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repository.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData((imageFile.getBytes()));
        product.setImageName(imageFile.getName());
        product.setImageType(imageFile.getContentType());
        return repository.save(product);

    }

    public void deleteProductById(int productId) {
        repository.deleteById(productId);
    }

    public List<Product> searchProduct(String keyword) {

        return repository.searchProduct(keyword);

    }
}
