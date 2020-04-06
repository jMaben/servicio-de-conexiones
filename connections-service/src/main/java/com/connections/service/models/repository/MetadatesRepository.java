package com.connections.service.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import app.commons.models.entity.Metadates;

/**
 * Este es repositorio de Metadates, el cual extiende de PagingAndSortingRepository para heredar metodos
 * basicos para hacer un CRUD por ejemplo.
 */
@Repository
public interface MetadatesRepository extends PagingAndSortingRepository<Metadates, Long>{

}
