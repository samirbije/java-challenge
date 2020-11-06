package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    
    /** 
     * Endpoint to get Employee list from Database
     * @return List<Employee>
     */
    @GetMapping("/employees")
    public @ResponseBody List<Employee> getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    
    /** 
     * Emdpoint to get an Employee data by id
     * @param employeeId
     * @return Employee
     */
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    
    /** 
     * Endpoint to create a new Employee
     * @param employee
     * @return Employee
     */
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        // employee.setId(null); //ignore id value to allow just create and not allow update
        Employee createdEmployee = employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
        return createdEmployee;
    }

    
    /** 
     * Endpoint to delete an employee record by id
     * @param employeeId
     */
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
    }

    
    /** 
     * Endpoint to update an en Employee record using id
     * @param updated: Employee
     * @param id
     * @return Employee
     */
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee updated,
                               @PathVariable(name="employeeId")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);

        emp.setDepartment(updated.getDepartment());
        emp.setName(updated.getName());
        emp.setSalary(updated.getSalary());
        employeeService.updateEmployee(emp);
        System.out.println("Employee Updated Successfully");
        return emp;
    }

}
