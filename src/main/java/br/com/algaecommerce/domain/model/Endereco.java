package br.com.algaecommerce.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Embeddable
public class Endereco {
	

	@NotNull  //nao tinha a dependencia desta anotação
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
	@Column(length = 9)
	private String cep;
	
	@NotBlank
	@Column(length = 100)
	private String logradouro;
	
	@NotBlank
	@Column(length = 10)
	private String numero;
	
	@Column(length = 50)
	private String complemento;
	
	@NotBlank
	@Column(length = 50)
	private String bairro;
	
	@NotBlank
	@Column(length = 50)
	private String cidade;
	
	@NotBlank
	@Size(max = 2, min = 2)
	@Column(length = 2)
	private String estado;
	
	
     
	
}
