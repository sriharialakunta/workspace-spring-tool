package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	private ProductService productservice;

	public ProductController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}
	
	@GetMapping("/products")
	public String listOfProducts(Model model) {
		model.addAttribute("products", productservice.getAllProducts());
		return "products";
	}
	
	@GetMapping("/products/new")
	public String createproductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "create";
	}
	
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productservice.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/edit/{pid}")
	public String editProductForm(@PathVariable int pid,Model model) {
		
		model.addAttribute("product",productservice.getProductById(pid));
		return "edit";
	}
	
	@PostMapping("/products/{id}")
	public String UpdateProduct(@PathVariable int id,@ModelAttribute("product") Product product,Model model) {
		
		Product existingProduct = productservice.getProductById(id);
		existingProduct.setPid(id);
		existingProduct.setPname(product.getPname());
		existingProduct.setQty(product.getQty());
		existingProduct.setPrice(product.getPrice());
		productservice.updateProduct(existingProduct);
		return "redirect:/products";
		
	}
	
	@GetMapping("/products/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		productservice.deleteProductbyId(pid);
		return "redirect:/products";
	}

}
