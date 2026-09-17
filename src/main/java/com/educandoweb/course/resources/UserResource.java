package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

//Essa classe é um recurso web que é implementado por um controlador rest
@RestController
@RequestMapping(value = "/users") //Dar um nome para o recurso
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//O tipo de retorno desse método é o ResponseEntity que é um tipo específico do spring para retornar respostas de requisições web 
	@GetMapping //Indica que o método responde a requisições do tipo get do http
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
