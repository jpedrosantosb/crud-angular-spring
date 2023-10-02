package com.jpbastos.dto.mapper;

import org.springframework.stereotype.Component;

import com.jpbastos.dto.CourseDTO;
import com.jpbastos.enums.Category;
import com.jpbastos.model.CourseModel;

@Component
public class CourseMapper {
	public CourseDTO toDTO(CourseModel course) {
		if (course == null) {
			return null;
		}
		return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue());
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
