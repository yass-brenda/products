package com.learning_api.demo.product_rest;

import com.learning_api.demo.dao.ProductsDAO;
import com.learning_api.demo.entitys.Product;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Es un restapi
@RequestMapping("products") //url en la que se expondran los servivios
public class ProductsRest {

    @Autowired
    private ProductsDAO productsDAO;

    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        List<Product>products = productsDAO.findAll();
        return ResponseEntity.ok(products);

    }

    @RequestMapping(value = "{productId}") // products/{productId} -> /products/1
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
        Optional<Product> optionalProduct = productsDAO.findById(productId); // protege de un valor nulo optional
        if (optionalProduct.isPresent()){
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.noContent().build(); // Regresa que no encuentra nada
        }

    }

    @PostMapping // /products(POST)
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newProduct = productsDAO.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping(value = "{productId}") // /products(DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId){
        productsDAO.deleteById(productId);
        return ResponseEntity.ok(null);
    }


    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Optional<Product> optionalProduct = productsDAO.findById(product.getId()); // protege de un valor nulo optional
        if (optionalProduct.isPresent()){
            Product updateProduct = optionalProduct.get();
            updateProduct.setName(product.getName());
            productsDAO.save(updateProduct);
            return ResponseEntity.ok(updateProduct);
        } else {
            return ResponseEntity. notFound().build(); // Regresa que no encuentra nada
        }
    }


    // Exponer un servicio
    // @GetMapping Este servivio estará expuesto en el método get toma como raiz el requestmapping de la clase
    // @RequestMapping(value = "hello",method = RequestMethod.GET) // url del servicio , la request del metodo get toma la url que se le indique
    public String hello(){
        return "hello";
    }
}
