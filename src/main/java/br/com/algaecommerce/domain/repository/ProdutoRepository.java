package br.com.algaecommerce.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.algaecommerce.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(" select distinct  p   from Produto p left join  fetch  p.tags")   // 229 ms retirando a duplicidade de registros
	//@Query(" select  p  from Produto p  join  fetch  p.tags")   //  251 ms  com duplicidade de registros
 	List<Produto> findAll();  //sem a anotação @Query     //   471 ms problema do N + 1

}
