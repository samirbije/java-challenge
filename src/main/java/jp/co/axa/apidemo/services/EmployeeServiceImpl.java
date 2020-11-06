package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exceptions.EmployeeNotFoundException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {	    
        this.employeeRepository = employeeRepository;
    }

    /** 
     * Service method to retrived all Employee list from database
     * @return List<Employee>
     */
    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    
    /** 
     * Service method to get an Employee data using id
     * @param employeeId
     * @return Employee
     */
    public Employee getEmployee(Long employeeId) {
        try {
            Optional<Employee> optEmp = employeeRepository.findById(employeeId);
            return optEmp.get();
        } catch (IllegalArgumentException | NoSuchElementException e) {
            throw new EmployeeNotFoundException();
        }
    }

    
    /** 
     * Service method to save a record on a Employee
     * @param employee
     * @return Employee
     */
    public Employee saveEmployee(Employee employee){
        Employee createdEmployee = employeeRepository.save(employee);
        return createdEmployee;
    }

    
    /** 
     * Service method to delete a Employee record by id
     * @param employeeId
     */
    public void deleteEmployee(Long employeeId){
        try {
            employeeRepository.deleteById(employeeId);
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException();
        }
    }

    
    /** 
     * Service method to update a Employee record by id
     * @param employee
     */
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}