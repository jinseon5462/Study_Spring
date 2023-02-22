package com.springboot.jpa2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_sample")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@Column(length=20, nullable=false)
	private String name;
	
//	@Column(length=20, nullable=false) 콜럼이라고 안써도 콜럼이 된다.
	private int age;
}
