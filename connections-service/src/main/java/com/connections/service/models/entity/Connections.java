package com.connections.service.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "connections")
@Getter @Setter
public class Connections implements Serializable{
	
	private static final long serialVersionUID = -2173385203936724383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String host;
	private int port;
	private String user;
	private String pass;
	
	@Column(unique = true, length = 150)
	private String alias;
	private boolean active;
	
	@Column(name = "id_type")
	private int idType;
	
	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	private Date createdData;

}
