package br.com.algaecommerce.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.algaecommerce.domain.model.Cliente;

import br.com.algaecommerce.domain.repository.ClienteRepository;



/**
 * 
 * @author Joangele
 * @implNote  criada para tirar a atribuição de persistencia que estava contida na classe HomeController
 */
@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository ;
	
	public Cliente salvar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}

}
