package TLP.O1TLPP.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import TLP.O1TLPP.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
// no need to code any thing
	
	public List<Employee> findAllByOrderByFirstNameAsc();
	// search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
