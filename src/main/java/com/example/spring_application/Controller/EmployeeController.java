package com.example.spring_application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_application.Models.Employee;
import com.example.spring_application.Service.EmployeeService;


@Controller
//@RestController
public class EmployeeController {	

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        System.out.print("controller - " );
		System.out.print(employeeService.getAllEmployees());
        return "index";
    }
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		// redirects back to home page
		return "redirect:/";
	}
	
	@GetMapping("/showForm/{id}")
	public String showForm(@PathVariable(value="id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) { 
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
