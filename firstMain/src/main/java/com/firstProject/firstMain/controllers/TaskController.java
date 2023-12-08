package com.firstProject.firstMain.controllers;

import com.firstProject.firstMain.entities.Task;
import com.firstProject.firstMain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TaskController {
	@Autowired
	private TaskService service;

	@GetMapping({"/", "viewTaskList"})
	public String viewAllTask(Model model) {
//		Task task = new Task(1L,"Privet", new SimpleDateFormat("yyyy-MM-dd").parse("2000-20-20"),"Kak Dela", "Y tebya");
//		service.saveOrUpdateTask(task);
		model.addAttribute("list", service.getAllTask());
		return "ViewTaskList";
	}
	
	@GetMapping("/updateTaskStatus/{id}")
	public String updateTaskStatus(@PathVariable Long id) {
		System.out.println(id);
		//		Task task = new Task(1L,"Privet", new Date(),"Incomplete", "Y tebya");
		service.updateStatus(id);
			return "redirect:/viewTaskList";
	}
	
	@GetMapping("/сreateNewTask")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "СreateNewTask";
	}

	@GetMapping("/editTask/{id}")
	public String editTask(@PathVariable Long id, Model model) {
		model.addAttribute("task", service.getTaskById(id));
		return "EditTask";
	}
	@GetMapping("/taskDescription/{id}")
	public String descriptionTask(@PathVariable Long id, Model model) {
		model.addAttribute("task", service.getTaskById(id));
		return "taskDescription";
	}
	
	@PostMapping("/editSaveTask")
	public String editSaveTask(Task task) {
		service.saveOrUpdateTask(task);
			return "redirect:/viewTaskList";
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable Long id) {
		service.deleteTask(id);
			return "redirect:/viewTaskList";
	}
}
