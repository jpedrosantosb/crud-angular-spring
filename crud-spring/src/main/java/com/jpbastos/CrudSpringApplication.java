package com.jpbastos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

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
	@Profile("dev")
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			for (int i = 0; i < 20; i++) {
				CourseModel c = new CourseModel();
				c.setName("Angular com spring");
				c.setCategory(Category.FRONT_END);

				LessonModel l1 = new LessonModel();
				l1.setName("Introdução");
				l1.setYoutubeUrl("watch?v=1");
				l1.setCourse(c);
				c.getLessons().add(l1);

				LessonModel l2 = new LessonModel();
				l2.setName("Orientação a objeto");
				l2.setYoutubeUrl("watch?v=2");
				l2.setCourse(c);
				c.getLessons().add(l2);

				CourseModel c1 = new CourseModel();
				c1.setName("Java");
				c1.setCategory(Category.BACK_END);

				LessonModel l3 = new LessonModel();
				l3.setName("Introdução Java");
				l3.setYoutubeUrl("watch?v=3");
				l3.setCourse(c1);
				c1.getLessons().add(l3);

				courseRepository.save(c);
				courseRepository.save(c1);
			}
		};
	}
}
