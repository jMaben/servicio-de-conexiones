package com.connections.service.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import app.commons.models.entity.TypesGroups;

@Repository
public interface TypesGroupsRepository extends PagingAndSortingRepository<TypesGroups, Long>{

}
