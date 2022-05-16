package com.laptrinhjava.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.laptrinhjava.employee.entity.Employee;
import com.laptrinhjava.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String HomePage(Model model) {
		
		List<Employee> listemployee = employeeService.getAllEmployee();
		model.addAttribute("listemployee", listemployee);
		// System.out.print("Get / ");
		return "index";
	}

	@GetMapping("/addEmployee")
	public String addEmployeeForm() {
		
		return "add";
	}

	@PostMapping("/register")
	public String employeeRegister(@ModelAttribute Employee employee, HttpSession session) {
		
		employeeService.addEmployee(employee);
		session.setAttribute("msg", "Employee Add Sucessfully.");
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "edit";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee, HttpSession session) {
		
		employeeService.addEmployee(employee);
		session.setAttribute("msg", "Employee Data Update Sucessfully.");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id, HttpSession session) {

		employeeService.deleteEmployee(id);
		session.setAttribute("msg", "Employee Data Delete Sucessfully.");
		return "redirect:/";
	}

}
