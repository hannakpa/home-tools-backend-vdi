package org.ginji.hometoolsbackend.controller;
import org.ginji.hometoolsbackend.model.dto.Product;
import org.ginji.hometoolsbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;
    //FE:  private apiUrl = 'http://localhost:9090/api/products';
    // return this.httpClient.get<Product>(`${this.apiUrl}/search/${title}`);
    /// http://localhost:9090/api/products/search/Apple
    @GetMapping("/search/{title}")
    public Product getProductByTitle(@PathVariable String title) {
        System.out.println("Petition received " + title);
        return productService.getByTitle(title);
    }

}

