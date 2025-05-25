package com.hexaware.automobile.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer officer_id;

    private String oname;

    @Column(unique = true)
    private String email;

    private String opassword;

	public Object getopassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
