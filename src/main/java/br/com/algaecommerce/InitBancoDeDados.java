package br.com.algaecommerce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;


import br.com.algaecommerce.domain.model.Cliente;
import br.com.algaecommerce.domain.model.Endereco;
import br.com.algaecommerce.domain.model.Pedido;
import br.com.algaecommerce.domain.model.Produto;
import br.com.algaecommerce.domain.service.CadastroClienteService;
import br.com.algaecommerce.domain.service.CadastroPedidoService;
import br.com.algaecommerce.domain.service.CadastroProdutoService;


import java.util.Arrays;


//interfaces para executar partes específicas de código quando um aplicativo é iniciado,

@Component
public class InitBancoDeDados implements ApplicationRunner {
	

	
	@Autowired
	private CadastroProdutoService cadastroProduto ;  //adicionei
	
	@Autowired                                         //estava sem @Autowired 
	private CadastroClienteService cadastroCliente ;
 	 
	@Autowired                                        
	private CadastroPedidoService  CadastroPedido ;     //adicionei
   
	
	@Override

	public void run(ApplicationArguments args) throws Exception {
		for (int i = 0; i < 20; i++) {
			Produto produto1 = new Produto();
			produto1.setNome("Desktop");
			produto1.setTags(Arrays.asList("TI", "Mesa"));
			//manager.persist(produto1);
			cadastroProduto.salvar(produto1);
			
			Produto produto2 = new Produto();
			produto2.setNome("Notebook");
			produto2.setTags(Arrays.asList("TI", "Portátil", "Departamento de TI"));
			//manager.persist(produto2);   //comentei
			cadastroProduto.salvar(produto2);
			
			Cliente cliente1 = new Cliente();
			cliente1.setNome("João");
			
			var endereco = new Endereco();
			endereco.setCep("49060-700");
			endereco.setBairro("cidade nova");
			endereco.setCidade("Aracaju");
			endereco.setEstado("SE");
			endereco.setLogradouro("rua sadsdasdas ");
			endereco.setNumero("51");
			
			
			cliente1.setEnderecos(Arrays.asList( endereco));
			//manager.persist(cliente1);   //comentei
			cadastroCliente.salvar(cliente1);
			
	
			Pedido pedido = new Pedido();
			//pedido.setDataCriacao(LocalDateTime.now());                      // criei uma propriedade anotando com  @CreationTimestamp na classe Pedido
			
						
			pedido.setProdutoList(Arrays.asList(produto1, produto2));         
			pedido.setCliente(cliente1);
			//manager.persist(pedido);       //comentei
			CadastroPedido.salvar(pedido) ;
			
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Maria");
			//manager.persist(cliente2);      //comentei
			cadastroCliente.salvar(cliente2);
			
			Pedido pedido2 = new Pedido();
			//pedido2.setDataCriacao(LocalDateTime.now());   // criei uma propriedade anotando com  @CreationTimestamp na classe Pedido
			pedido2.setProdutoList(Arrays.asList(produto1, produto2));
			pedido2.setCliente(cliente2);
			//manager.persist(pedido2);   //comentei
			CadastroPedido.salvar(pedido2); 
			
		}
	}
}
