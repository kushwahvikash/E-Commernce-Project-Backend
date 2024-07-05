package com.vikas.fai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class User {
	@Id
	@GeneratedValue
	private Long uId;
    private String uName;
    private String email;
    private String mobile;
    private String type;
    private String address;
    @Lob
    private byte[] file;
}
