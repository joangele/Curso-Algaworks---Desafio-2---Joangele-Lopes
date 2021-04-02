package br.com.algaecommerce.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.algaecommerce.domain.model.Produto;
import br.com.algaecommerce.domain.repository.ProdutoRepository;



@Service
public class CadastroProdutoService {
	
	
	@Autowired
	public ProdutoRepository produtoRepository ;	
	
	
	public Produto salvar(Produto produto) { 		
		
		return produtoRepository.save(produto) ;
		
	}

}
