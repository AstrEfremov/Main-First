package com.firstProject.firstMain.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@Table(name = "Task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private Long id;
	
	@Column
	@NonNull
	private String title;
	
	@Column
	@NonNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate date;
	
	@Column
	@NonNull
	private String status;

	@Column
	@NonNull
	private String nameOfEmployee;

	public Task() {
	}
}
