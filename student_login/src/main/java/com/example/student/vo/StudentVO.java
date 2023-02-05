package com.example.student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentVO {
	private int sno;
	private String id;
	private String pw;
	private String name;
	private String tel;
}
