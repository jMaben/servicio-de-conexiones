package com.connections.service.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.connections.service.models.entity.Connections;

@Repository
public interface ConnectionsRepository extends CrudRepository<Connections, Long>{

}
