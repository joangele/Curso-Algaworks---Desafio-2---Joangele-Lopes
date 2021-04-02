package br.com.algaecommerce.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data    //lombok
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido {
	
	@Id
	@GeneratedValue	
	@EqualsAndHashCode.Include
	private Long id;
	
	
	@CreationTimestamp
	@Column(nullable = false , columnDefinition = "datetime")   //adicionada nao tinha estava sendo passado quando instanciava o objeto
	private LocalDateTime dataCriacao;
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			     name = "pedido_produto" ,
			     joinColumns = @JoinColumn(name="pedido_id") ,
			     inverseJoinColumns = @JoinColumn(name="produto_id")			
			)
	private List<Produto> produtoList = new ArrayList<>();
	
	/**
	 * adicionei o @ManyToOne   com o JoinColumn
	 */
    @ManyToOne   
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@Embedded
	private Endereco enderecoEntrega;
	
	
}
