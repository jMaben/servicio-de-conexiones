package com.connections.service.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import app.commons.models.entity.Metadates;

/**
 * Este es repositorio de Metadates, el cual extiende de PagingAndSortingRepository para heredar metodos
 * basicos para hacer un CRUD por ejemplo.
 */
@Repository
public interface MetadatesRepository extends PagingAndSortingRepository<Metadates, Long>{
	
	@Query(value = "SELECT * FROM metadates WHERE id IN (SELECT id_metadate FROM connections_metadates WHERE id_connection = :id)", nativeQuery = true)
	public List<Metadates> allConnectionsMetadatesTable(Long id);
}
