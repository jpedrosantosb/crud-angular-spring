package com.jpbastos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpbastos.enums.Category;
import com.jpbastos.model.CourseModel;
import com.jpbastos.model.LessonModel;
import com.jpbastos.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			CourseModel c = new CourseModel();
			c.setName("Angular com spring");
			c.setCategory(Category.FRONT_END);
			
			LessonModel l = new LessonModel();
			l.setName("Introdução");
			l.setYoutubeUrl("watch?v=1");
			l.setCourse(c);
			c.getLessons().add(l);
			
			courseRepository.save(c);
		};
	}
}
