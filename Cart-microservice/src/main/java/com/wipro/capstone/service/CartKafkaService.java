package com.wipro.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.entity.Cart;
import com.wipro.capstone.entity.CartCust;
import com.wipro.capstone.repository.CartCustRepository;
import com.wipro.capstone.repository.CartRepository;

@Service
public class CartKafkaService {
	
	@Autowired
	private CartRepository repository;
	
	@Autowired
	private CartCustRepository custRepository;

	public Cart addCartByKafka(int custId, Cart cart) {
		cart = repository.save(cart);
		custRepository.save(new CartCust(cart.getCartId(),custId));
		return cart;
	}

	public Cart searchCartByCustId(int custId) {
		
		return repository.findById(custRepository.findByCustId(custId).getCartId()).orElse(null);
	}

	public String deleteCartByCustId(int custId) {
		CartCust id = custRepository.findByCustId(custId);
				custRepository.deleteById(id.getId());
				repository.deleteById(id.getCartId());
		return "Deleting Cart  with this Customer id "+custId;
	}

}
