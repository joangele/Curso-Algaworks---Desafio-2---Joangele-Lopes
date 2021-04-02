package br.com.algaecommerce.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.algaecommerce.domain.exception.EntidadeNaoEncontradaException;
import br.com.algaecommerce.domain.model.Pedido;
import br.com.algaecommerce.domain.repository.PedidoRepository;
import br.com.algaecommerce.domain.service.CadastroPedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository ;
	
	@Autowired
	private CadastroPedidoService cadastroPedido;
	
	
	@GetMapping
	public List<Pedido> listar(){
		
		return pedidoRepository.findAll();
		
	}
     
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public  ResponseEntity<?>  cadastrar(@RequestBody Pedido pedido)  {
		
	  try {
		  pedido = cadastroPedido.salvar(pedido);
		  return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} 	
				
		    		
    }

}
