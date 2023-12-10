package com.firstProject.firstMain.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

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
	private String description = null;

	@Column
	private String comment = null;
	
	@Column
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column
	@NonNull
	private String status = "Не выполнена";

	@Column
	@NonNull
	private String nameOfEmployee;

	public Task() {
	}
}
