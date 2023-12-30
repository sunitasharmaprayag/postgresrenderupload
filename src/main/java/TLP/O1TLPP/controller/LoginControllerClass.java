package TLP.O1TLPP.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import TLP.O1TLPP.entity.Employee;
import TLP.O1TLPP.service.EmployeeService;

@Controller


public class LoginControllerClass {
	@GetMapping("/login")
	public String login(Model theModel) {
		
		
		return "Login";




}
	
/*	@GetMapping("/employees/authenticate")
	String authenticate(@RequestParam("firstName") String pwd,
			@RequestParam("email") String email,
			 Model theModel)
	{
		String cemail="aaa@gmail.com";
		String cpwd="12345";
		if(cemail.equals(email)&&pwd.equals(cpwd))
			
		{
			return  "redirect:/employees/list";
		}
		else
		{
			return "Login";
		}
		
		
	}*/
	private EmployeeService employeeService;
	
	public LoginControllerClass(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	


	
	@GetMapping("/employees/authenticate")
	String authenticate(@RequestParam("firstName") String pwd,
			@RequestParam("email") String email,
			 Model theModel)
	{
		
		List<Employee> theEmployees = employeeService.findAll();
		

	for(int a=0;a<theEmployees.size();a++)
	{

		String cpwd=theEmployees.get(a).getFirstName();
		String cemail=theEmployees.get(a).getEmail();
		System.out.println(cemail+" "+email);
		//System.out.println(cpwd+"   "+pwd);
		
		
		if(cemail.equals(email)&&cpwd.equals(pwd))
			
		{

				
			return  "redirect:/employees/list";
		}
		
		
		
		
		}
	theModel.addAttribute("error","invalid email or password");
	return "Login";

	}
	
}