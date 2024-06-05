package br.com.mfsdevsystem.workshopmongo.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.mfsdevsystem.workshopmongo.domain.User;


@Document(collection="user")
public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
	private String id;	
	private String name;
	private String email;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();	
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
