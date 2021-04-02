package br.com.algaecommerce.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.algaecommerce.domain.model.Cliente;

import br.com.algaecommerce.domain.repository.ClienteRepository;



@RestController
@RequestMapping(value = "/clientes") 
public class ClienteController {
	
	@Autowired
	private  ClienteRepository clienteRepository ;
	

	
	@GetMapping
	public List<Cliente> listar(){
		
		return clienteRepository.findAll();
	}
	

}
