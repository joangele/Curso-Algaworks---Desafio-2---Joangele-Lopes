package br.com.algaecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.algaecommerce.domain.exception.EntidadeNaoEncontradaException;
import br.com.algaecommerce.domain.model.Produto;
import br.com.algaecommerce.domain.repository.ProdutoRepository;
import br.com.algaecommerce.domain.service.CadastroProdutoService;


@RestController
@RequestMapping(value = "/produtos") 
public class ProdutoController {
	
	@Autowired
	private  ProdutoRepository produtoRepository ;
	
	@Autowired
	private CadastroProdutoService cadastroProduto ;
	
	@GetMapping
	public List<Produto> listar(){
		
		
		return produtoRepository.findAll();	//com duplicidade de registros	
		
	//	var produtos = produtoRepository.findAll();				
	//	return produtos.stream().distinct().collect(Collectors.toList());  //tirei a duplicidade aqui   //244 ms
	}
	
	
	 @ResponseStatus(value = HttpStatus.CREATED)
	 @PostMapping
	  public Produto  adicionar(@RequestBody Produto produto){				
	    
		 return cadastroProduto.salvar(produto);	
		
		
	}
	 

	
	@PutMapping(value = "/{produtoId}")
	public ResponseEntity<?> atualizar(@PathVariable Long produtoId ,@RequestBody Produto produto)  {
	
		try {
				 Optional<Produto> produtoAtual = produtoRepository.findById(produtoId);
				 
				 if (produtoAtual.isPresent()) {
				     
					 BeanUtils.copyProperties(produto, produtoAtual.get() , "id" );
					 
					 Produto produtoSalvo = cadastroProduto.salvar(produtoAtual.get());		 
					 return ResponseEntity.ok().body(produtoSalvo);
					 		 	
			     } 
				 
				 return ResponseEntity.notFound().build();				 
				
		    
		} catch (EntidadeNaoEncontradaException e) {
			
			  return  ResponseEntity.badRequest().body(e.getMessage()) ;	
			 
		}
	 
	

}

}