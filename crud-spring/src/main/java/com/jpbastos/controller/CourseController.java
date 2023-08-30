package com.jpbastos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpbastos.model.CourseModel;
import com.jpbastos.repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	//@RequestMapping(method = RequestMethod.GET) 
	@GetMapping
	public @ResponseBody List<CourseModel> list() {
		return courseRepository.findAll();
	}
	
}
