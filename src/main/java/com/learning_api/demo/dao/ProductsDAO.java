package com.learning_api.demo.dao;

import com.learning_api.demo.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDAO extends JpaRepository<Product,Long> {
}
