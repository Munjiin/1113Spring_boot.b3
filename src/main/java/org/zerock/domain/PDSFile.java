package org.zerock.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of="fno") 
public class PDSFile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fno;
	private String fname;
	
	

}
