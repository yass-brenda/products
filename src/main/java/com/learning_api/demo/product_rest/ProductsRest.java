package com.learning_api.demo.product_rest;

import com.learning_api.demo.entitys.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // Es un restapi
@RequestMapping("products") //url en la que se expondran los servivios
public class ProductsRest {

    @GetMapping
    public ResponseEntity<Product> getProduct(){
        Product product = new Product();
        product.setId(1L);
        product.setName("Producto 1");
        return ResponseEntity.ok(product); //Regresa status 200 que todo salio bien

    }


    // Exponer un servicio
    // @GetMapping Este servivio estará expuesto en el método get toma como raiz el requestmapping de la clase
    // @RequestMapping(value = "hello",method = RequestMethod.GET) // url del servicio , la request del metodo get toma la url que se le indique
    public String hello(){
        return "hello";
    }
}
