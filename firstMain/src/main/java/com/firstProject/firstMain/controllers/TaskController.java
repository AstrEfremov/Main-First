package com.firstProject.firstMain.controllers;

import com.firstProject.firstMain.entities.Task;
import com.firstProject.firstMain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping({"/", "viewTaskList"})
	public String viewAllTask(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", service.getAllTask());
		model.addAttribute("message", message);
		return "ViewTaskList";
	}
	
	@GetMapping("/updateTaskStatus/{id}")
	public String updateTaskStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.updateStatus(id)) {
			redirectAttributes.addFlashAttribute("message", "Update Success");
			return "redirect:/viewTaskList";
		}
		redirectAttributes.addFlashAttribute("message", "Update Failure");
		return "redirect:/viewTaskList";
	}
	
	@GetMapping("/addTask")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "AddTask";
	}
	
	@PostMapping("/saveTask")
	public String saveTask(Task task, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateTask(task)) {
			redirectAttributes.addFlashAttribute("message", "Save Success");
			return "redirect:/viewTaskList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Save Failed");
		return "redirect:/addTask";
	}
	
	@GetMapping("/editTask/{id}")
	public String editTask(@PathVariable Long id, Model model) {
		model.addAttribute("task", service.getTaskById(id));
		return "EditTask";
	}
	
	@PostMapping("/editSaveTask")
	public String editSaveTask(Task task, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateTask(task)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/viewTaskList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Edit Failed");
		return "redirect:/editTask/" + task.getId();
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if(service.deleteTask(id)) {
			redirectAttributes.addFlashAttribute("message", "Delete Success");
			return "redirect:/viewTaskList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Delete Failure");
		return "redirect:/viewTaskList";
	}
	
	
}
