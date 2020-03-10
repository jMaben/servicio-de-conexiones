package com.connections.service.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "metadates")
@Getter @Setter
public class Metadates implements Serializable{

	private static final long serialVersionUID = 28983255424303677L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String metadate;
	private String description;
	
	@Column(name = "id_parent")
	private int idParent;
	
	private int level;
	private boolean active; 
	
	@ManyToMany(mappedBy = "ConnectionsMetadates")
	private Set<Connections> MetadatesConnections;
	
}
