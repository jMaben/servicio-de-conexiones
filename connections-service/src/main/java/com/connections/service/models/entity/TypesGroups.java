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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "types_groups")
@Getter @Setter
public class TypesGroups implements Serializable{
	
	private static final long serialVersionUID = -2610454119918397015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String typeGroup;
	private String description;
	
	@OneToMany(mappedBy = "idTypeGroup", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<Types> types;
}
