package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//Essa classe é um recurso web que é implementado por um controlador rest
@RestController
@RequestMapping(value = "/users") //Dar um nome para o recurso
public class UserResource {
	
	//O tipo de retorno desse método é o ResponseEntity que é um tipo específico aqui do spring para retornar respostas de requisições web 
	@GetMapping //Indica que o método responde a requisições do tipo get do http
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
		return ResponseEntity.ok().body(u);
	}

}
