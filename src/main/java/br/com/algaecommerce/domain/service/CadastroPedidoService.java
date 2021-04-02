package br.com.algaecommerce.domain.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.algaecommerce.domain.exception.EntidadeNaoEncontradaException;
import br.com.algaecommerce.domain.model.Cliente;
import br.com.algaecommerce.domain.model.Pedido;
import br.com.algaecommerce.domain.model.Produto;
import br.com.algaecommerce.domain.repository.ClienteRepository;
import br.com.algaecommerce.domain.repository.PedidoRepository;
import br.com.algaecommerce.domain.repository.ProdutoRepository;


/**
 * 
 * @author Joangele
 * @implNote  criada para tirar a atribuição de persistência que estava contida na classe controller
 */
@Service
public class CadastroPedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository ;
    
	@Autowired
	private ClienteRepository clienteRepository ;
	
	@Autowired
	private ProdutoRepository produtoRepository ;
			
	
	public Pedido salvar(Pedido pedido) {
		
		
		var produtos = new ArrayList<Produto>();
		
		for (Produto produto : pedido.getProdutoList()) {
			
			Long produtoId = produto.getId();
			
		    Produto ProdutoEncontrado = produtoRepository.findById(produtoId)
		    		.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não Existe registro de produto com o Id %d", produtoId))); 	
			
		    produtos.add(ProdutoEncontrado);
		    
		}
		
		pedido.setProdutoList(produtos);
		
		
		Long clienteId = pedido.getCliente().getId();
		
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não Existe registro de Cliente com o Id %d", clienteId)));
		
		pedido.setCliente(cliente);
		
		return pedidoRepository.save(pedido);
	}

}
