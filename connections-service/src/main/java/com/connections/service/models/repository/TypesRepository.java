package com.connections.service.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.connections.service.app.commons.models.entity.Types;

@Repository
public interface TypesRepository extends PagingAndSortingRepository<Types, Long>{

}
