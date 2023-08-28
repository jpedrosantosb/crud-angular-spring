package com.jpbastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpbastos.model.CourseModel;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {

}
