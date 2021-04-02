package br.com.algaecommerce.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.algaecommerce.domain.model.Pedido;

@Repository //adicionada por joangele
public interface PedidoRepository extends JpaRepository<Pedido, Long> {   // nao estava extendendo a classe JpaRepository 
	

	@Query("from Pedido p left join fetch p.cliente  left join fetch p.produtoList   " )   //315 ms
	List<Pedido> findAll();                                                                  

	
}
