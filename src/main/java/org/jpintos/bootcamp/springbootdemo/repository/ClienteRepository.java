package org.jpintos.bootcamp.springbootdemo.repository;

import org.jpintos.bootcamp.springbootdemo.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findById(long id);
}
