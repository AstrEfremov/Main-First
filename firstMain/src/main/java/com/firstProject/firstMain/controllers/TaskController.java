package com.firstProject.firstMain.controllers;

import com.firstProject.firstMain.entities.Task;
import com.firstProject.firstMain.service.TaskService;
import com.firstProject.firstMain.service.UserService;
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
	@Autowired
	private UserService userService;

	@GetMapping({"/", "viewTaskList"})
	public String viewAllTask(Model model) {
		model.addAttribute("list", service.getAllTask());
		return "ViewTaskList";
	}
	
	@GetMapping("/updateTaskStatus/{id}")
	public String updateTaskStatus(@PathVariable Long id) {
		System.out.println(id);
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
