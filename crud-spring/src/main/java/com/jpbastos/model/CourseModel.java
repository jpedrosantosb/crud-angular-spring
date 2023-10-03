package com.jpbastos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpbastos.enums.Category;
import com.jpbastos.enums.Status;
import com.jpbastos.enums.converters.CategoryConverter;
import com.jpbastos.enums.converters.StatusConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cursos")
@SQLDelete(sql = "UPDATE cursos SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class CourseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("_id")
	private Long id;

	@NotBlank
	@NotNull
	@Length(min = 4, max = 50)
	@Column(name = "nome", length = 100, nullable = false)
	private String name;

	@NotNull
	@Column(length = 10, nullable = false)
	@Convert(converter = CategoryConverter.class)
	private Category category;

	@NotNull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ATIVO;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "course")
    // @JoinColumn(name = "course_id")
    private List<LessonModel> lessons = new ArrayList<>();

	public CourseModel() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(category, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseModel other = (CourseModel) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;

	}

	public List<LessonModel> getLessons() {
		return lessons;
	}

	public void setLessons(List<LessonModel> lessons) {
		this.lessons = lessons;
	}
	
	

}
