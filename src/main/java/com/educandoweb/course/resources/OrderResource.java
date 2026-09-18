package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

//Essa classe é um recurso web que é implementado por um controlador rest
@RestController
@RequestMapping(value = "/orders") //Dar um nome para o recurso
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	//O tipo de retorno desse método é o ResponseEntity que é um tipo específico do spring para retornar respostas de requisições web 
	@GetMapping //Indica que o método responde a requisições do tipo get do http
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
