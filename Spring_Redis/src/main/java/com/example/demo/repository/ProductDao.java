package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

import jakarta.annotation.Resource;

@Repository
public class ProductDao {

	public static final String HASH_KEY = "Product";
	@Resource(name = "redisTemplate")
	@Autowired
	private RedisTemplate template;

	public Product save(Product product) {
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}

	public List<Product> findAll() {
		return template.opsForHash().values(HASH_KEY);

	}

	public Product findProductById(int id) {
		Product product = (Product) template.opsForHash().get(HASH_KEY, id);
		System.out.println(product);
		return product;
	}

	public String deleteProduct(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "product removed...";
	}

}
