package com.springboot.myapp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String role;
}
