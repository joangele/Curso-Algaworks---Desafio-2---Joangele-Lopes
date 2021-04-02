package br.com.algaecommerce.domain.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.JoinColumn;     //estava sem esta anotação

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	@SequenceGenerator(name = "seq2", sequenceName = "seq_chave_prim")
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	
	//@ElementCollection(targetClass = Endereco.class)  //Este elemento 'targetClass' é opcional apenas se o campo ou propriedade de coleção for definido usando genéricos 
	
	@JsonIgnore
	@ElementCollection() 
	@CollectionTable(name = "cliente_endereco", joinColumns = @JoinColumn(name = "cliente_id"))
	//@Column(name="nome")                                  	//lista de enderecos com o nome 'nome' na tabela (o objeto não é uma string é um colection de Endereço)  ???????????
	//private List<Endereco> enderecos = new ArrayList<>();     //tirei ainicialização nao achei necessário
	private List<Endereco> enderecos ;
	
	@JsonIgnore    //adicionei  para nao entrar em referencia circular
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	

	
}
