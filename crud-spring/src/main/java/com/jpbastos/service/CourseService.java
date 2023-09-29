package com.jpbastos.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.jpbastos.exception.RecordNotFoundException;
import com.jpbastos.model.CourseModel;
import com.jpbastos.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<CourseModel> list() {
		return courseRepository.findAll();
	}

	public CourseModel findById(@NotNull @Positive Long id) {
		return courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
	}

	public CourseModel create(@Valid CourseModel course) {
		return courseRepository.save(course);
	}

	public CourseModel update(@NotNull @Positive Long id, @Valid CourseModel course) {
		return courseRepository.findById(id).map(recordFound -> {
			recordFound.setName(course.getName());
			recordFound.setCategory(course.getCategory());
			return courseRepository.save(recordFound);
		}).orElseThrow(() -> new RecordNotFoundException(id));
	}

	public void delete(@NotNull @Positive Long id) {
		courseRepository.delete(courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
