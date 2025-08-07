package com.study.spring.testImage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.testImage.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
	
	@Query("select t from TestEntity t left join fetch t.imageList where t.id = : id ")
	Optional<TestEntity> findByIdWidthImages(@Param("id") Long id);

}
