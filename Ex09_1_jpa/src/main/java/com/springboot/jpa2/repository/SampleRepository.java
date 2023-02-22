package com.springboot.jpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa2.dto.SampleDTO;
import com.springboot.jpa2.entity.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long>{

	// 기본적인 CRUD가 가능함
	// C : 등록(생성) -> save()
	//public int save(SampleDTO sample);
	// R : 조회(단일) -> findBy...()
	// R : 조회(전체) -> findAll()
	// U : 수정 -> save()
	// D : 삭제 -> deleteBy...()
}
