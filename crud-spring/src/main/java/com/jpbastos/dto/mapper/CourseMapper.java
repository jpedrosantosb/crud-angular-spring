package com.jpbastos.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jpbastos.dto.CourseDTO;
import com.jpbastos.dto.LessonDTO;
import com.jpbastos.enums.Category;
import com.jpbastos.model.CourseModel;
import com.jpbastos.model.LessonModel;

@Component
public class CourseMapper {
	public CourseDTO toDTO(CourseModel course) {
		if (course == null) {
			return null;
		}
		List<LessonDTO> lessons = course.getLessons()
				.stream()
				.map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl())).collect(Collectors.toList());
		return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
	}

	public CourseModel toEntity(CourseDTO courseDTO) {

		if (courseDTO == null) {
			return null;
		}

		CourseModel course = new CourseModel();
		if (courseDTO.id() != null) {
			course.setId(courseDTO.id());
		}
		course.setName(courseDTO.name());
		course.setCategory(convertCategoryValue(courseDTO.category()));
		
		List<LessonModel> lessons = courseDTO.lessons().stream().map(lessonDTO -> {
            var lesson = new LessonModel();
            lesson.setId(lessonDTO.id());
            lesson.setName(lessonDTO.name());
            lesson.setYoutubeUrl(lessonDTO.youtubeUrl());
            lesson.setCourse(course);
            return lesson;
        }).collect(Collectors.toList());
        course.setLessons(lessons);
		
		return course;
	}
	
	public Category convertCategoryValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Front-end" -> Category.FRONT_END;
            case "Back-end" -> Category.BACK_END;
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };    
    }
}
