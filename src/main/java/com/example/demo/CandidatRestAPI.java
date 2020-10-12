package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/candidats")
public class CandidatRestAPI {
	private String title="Hello, candidat microservice";
	
	@RequestMapping(value = "/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
		
	}
	
	@Autowired
	private CandidatService cs;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat c){
		return new ResponseEntity<>(cs.addCandidat(c), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id, @RequestBody Candidat c){
	
		return new ResponseEntity<>(cs.updateCandidat(id, c), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
	
		return new ResponseEntity<>(cs.deleteCandidat(id), HttpStatus.OK);
	}
	
	
		
}
