package com.connections.service.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import app.commons.models.entity.TypesGroups;

/**
 * Este es repositorio de TypesGroups, el cual extiende de PagingAndSortingRepository para heredar metodos
 * basicos para hacer un CRUD por ejemplo.
 */
@Repository
public interface TypesGroupsRepository extends PagingAndSortingRepository<TypesGroups, Long>{

}
