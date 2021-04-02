package br.com.algaecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algaecommerce.domain.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
