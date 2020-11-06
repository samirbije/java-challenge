package jp.co.axa.apidemo;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exceptions.EmployeeNotFoundException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.services.EmployeeServiceImpl;

/* 
  Test class that performs Unit tests on 
  EmployeeService Implimentation class
*/
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTests {
  @TestConfiguration
  static class EmployeeServiceImplTestConfiguration {

      @Bean
      public EmployeeService employeeService() {
          return new EmployeeServiceImpl();
      }
  }

  @Autowired
  private EmployeeService employeeService;

  @MockBean
  private EmployeeRepository employeeRepository;
  /* 
    Before starting the test,
    moke the dependency being used by the service.
    In this case employee service is dependent to employee data repository.
    Thus, we mock employee data repository
  */
  @Before
  public void setUp() {
    // mock correct data retrival from dependency
    Long id = new Long(1);
    Employee alex = new Employee(id, "alex", 1000, "IT");
    Optional<Employee> alex_opt = Optional.of(alex);
    Mockito.when(employeeRepository.findById(id)).thenReturn(alex_opt);

    // mock exception from dependency
    Long invalid_id = new Long(999);
    Mockito.when(employeeRepository.findById(invalid_id))
    .thenThrow(IllegalArgumentException.class);
    }

  /* 
    Unit test to test method to getEmployeeId,
    when correct input is provided
  */
  @Test
  public void whenValidId_thenEmployeeShouldBeFound() {
      Long id = new Long(1);
      String name = "alex";
      String department = "IT";
      Employee found = employeeService.getEmployee(id);
  
      assertEquals(found.getName(), name);
      assertEquals(found.getDepartment(), department);
  }

  /* 
    Unit test to test if custom exception is thrown
    when an invalid employee is provided
  */
  @Test(expected = EmployeeNotFoundException.class)
  public void whenInValidId_thenThrowEmployeeNotFoundException() {
    Long id = new Long(999);
    employeeService.getEmployee(id);
  }
}