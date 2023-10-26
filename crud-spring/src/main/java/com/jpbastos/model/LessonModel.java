package com.jpbastos.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class LessonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
    @NotBlank
    @Length(min = 4, max = 100)
	@Column(length = 100, nullable = false)
	private String name;

	@NotNull
    @NotBlank
    @Length(min = 8, max = 11)
	@Column(length = 11, nullable = false)
	private String youtubeUrl;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "course_id", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private CourseModel course;
	
	public LessonModel() {
		
	}

	public LessonModel(Long id, String name, String youtubeUrl, CourseModel course) {
		super();
		this.id = id;
		this.name = name;
		this.youtubeUrl = youtubeUrl;
		this.course = course;
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

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	public CourseModel getCourse() {
		return course;
	}

	public void setCourse(CourseModel course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "LessonModel [id=" + id + ", name=" + name + ", youtubeUrl=" + youtubeUrl + ", course=" + course + "]";
	}
	
	
}
