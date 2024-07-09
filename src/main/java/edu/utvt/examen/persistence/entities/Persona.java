package edu.utvt.examen.persistence.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "te_personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID) 
	private UUID id;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@Column(nullable = false)
	private Integer edad;
	
	@Column(nullable = false, length = 50)
	private String universidad;
	
	@Column(nullable = false, length = 50, unique = true)
	private String email;
		
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false, columnDefinition = "DATE")
	private Date birthDate;
	
	
	// @OneToMany(mappedBy = "persona")
	@JsonIgnore
	@OneToMany(mappedBy = "persona")
	private List<Item> items;

}
