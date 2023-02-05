package com.example.student.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.student.vo.StudentVO;

@Mapper
public interface StudentMapper {
	public int login(StudentVO student);
	public int studentCheck(@Param("sno") int sno, @Param("name") String name);
	public int checkId(@Param("id") String id);
	public int signUp(StudentVO student);
}
