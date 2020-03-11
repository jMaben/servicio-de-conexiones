package com.connections.service.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "types")
@Getter @Setter
public class Types implements Serializable{

	private static final long serialVersionUID = -1480101823247798409L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    @ManyToOne
    @JoinColumn(name = "id_type_group")
    @JsonIgnore
	private TypesGroups idTypeGroup;
	
	private String type;
	private String description;
	private String driver; 
	
	@OneToMany(mappedBy = "idType", cascade = CascadeType.ALL)
    private Set<Connections> connections;
	
	
}
