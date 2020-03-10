package com.connections.service.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "types_groups")
@Getter @Setter
public class TypesGroups implements Serializable{
	
	private static final long serialVersionUID = -2610454119918397015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String typeGroup;
	private String description;
	
	@OneToMany(mappedBy = "id_type_group", cascade = CascadeType.ALL)
    private Set<Types> types;
}
