package com.connections.service.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.connections.service.models.entity.Metadates;

@Repository
public interface MetadatesRepository extends PagingAndSortingRepository<Metadates, Long>{

}
