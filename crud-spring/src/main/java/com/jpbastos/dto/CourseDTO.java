package com.jpbastos.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpbastos.enums.Category;
import com.jpbastos.enums.validation.ValueOfEnum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(

		@JsonProperty("_id") Long id,

		@NotBlank @NotNull @Length(min = 4, max = 50) String name,

		@NotNull @Length(max = 10) @ValueOfEnum(enumClass = Category.class) String category,
		@NotNull @NotEmpty @Valid List<LessonDTO> lessons) {

}
