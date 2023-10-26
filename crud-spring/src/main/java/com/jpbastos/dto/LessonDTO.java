package com.jpbastos.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LessonDTO(Long id,  @NotNull @NotBlank @Length(min = 4, max = 100) String name,  @NotNull @NotBlank @Length(min = 8, max = 11) String youtubeUrl) {
	
}
