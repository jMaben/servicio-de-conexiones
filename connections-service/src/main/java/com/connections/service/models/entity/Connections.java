package com.connections.service.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "connections")
@Getter @Setter @NoArgsConstructor
public class Connections implements Serializable{
	
	private static final long serialVersionUID = -2173385203936724383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String host;
	private int port;
	private String user;
	private String pass;
	
	@Column(unique = true, length = 150)
	private String alias;
	private boolean active;
	
    @ManyToOne
    @JoinColumn(name = "id_type")
	private Types idType;
	
	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	private Date createdData;
	
	@ManyToMany
	@JoinTable(
	  name = "connections_metadates", 
	  joinColumns = @JoinColumn(name = "id_connection"), 
	  inverseJoinColumns = @JoinColumn(name = "id_metadate"))
	private Set<Metadates> ConnectionsMetadates;

}
