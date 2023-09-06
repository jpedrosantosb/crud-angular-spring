package com.jpbastos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpbastos.model.CourseModel;
import com.jpbastos.repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public @ResponseBody List<CourseModel> list() {
		return courseRepository.findAll();
	}

//	// @RequestMapping(method = RequestMethod.POST)
//	@PostMapping
//	public ResponseEntity<CourseModel> create(@RequestBody CourseModel course) {
//		// System.out.println(course.getName());
//		// return courseRepository.save(course);
//		return ResponseEntity.status(HttpStatus.CREATED)
//				.body(courseRepository.save(course));
//	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CourseModel create(@RequestBody CourseModel course) {
		return courseRepository.save(course);

	}
}
