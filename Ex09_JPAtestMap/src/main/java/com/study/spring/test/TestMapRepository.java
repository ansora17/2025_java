package com.study.spring.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapRepository  extends JpaRepository<TestMapEntity, Long>{

}
