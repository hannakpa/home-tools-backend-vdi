package org.ginji.hometoolsbackend.service;

import org.ginji.hometoolsbackend.model.dto.Product;
import org.ginji.hometoolsbackend.model.dto.ProductSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://dummyjson.com/products";

    public List<Product> getAllProducts() {
        String url = BASE_URL;
        ProductSearchResponse response = restTemplate.getForObject(url, ProductSearchResponse.class);
        if (response != null && response.getProducts() != null) {
            return response.getProducts();
        }
        return Collections.emptyList();
    }


    // Buscar producto por nombre
    public Product getByTitle(String title) {
        String url = BASE_URL + "/search?q=" + title;
        System.out.println("URL: " + url);
        ProductSearchResponse response = restTemplate.getForObject(url, ProductSearchResponse.class);

        if (response != null && response.getProducts() != null && !response.getProducts().isEmpty()) {
            return response.getProducts().get(0);
        }
        return null;
    }
}
