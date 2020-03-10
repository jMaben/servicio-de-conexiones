package com.connections.service.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.connections.service.models.entity.Connections;

@Repository
public interface ConnectionsRepository extends PagingAndSortingRepository<Connections, Long>{

}
