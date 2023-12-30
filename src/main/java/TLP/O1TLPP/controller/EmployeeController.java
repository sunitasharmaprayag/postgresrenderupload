package TLP.O1TLPP.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import TLP.O1TLPP.entity.Employee;
import TLP.O1TLPP.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}


	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

Employee theEmployee=new Employee();
		// add to the spring model
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,  Model theModel) {

Employee theEmployee=employeeService.findById(theId);

		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	


	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

employeeService.deleteById(theId);

		
return "redirect:/employees/list";
	}
	

	

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}

	@GetMapping("/search")
	public String delete(@RequestParam("employeeName") String theName,
						 Model theModel) {
		
		// delete the employee
		List<Employee> theEmployees = employeeService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		// send to /employees/list
		return "/list-employees";
		
	}
	
}

