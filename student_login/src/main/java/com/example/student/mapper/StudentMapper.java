package com.example.student.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.student.vo.StudentVO;

@Mapper
public interface StudentMapper {
	public int loginCheck(@Param("id") String id, @Param("pw") String pw);
	public int idCheck(@Param("id") String id);
	public int signUp(StudentVO student);
	public StudentVO selectOne(@Param("sno") int sno, @Param("name") String name);
}
