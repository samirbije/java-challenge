package jp.co.axa.apidemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionController {

  // constant variables
  private static final String UNEXPECTED_SERVER_ERROR = "Unexpected Server Error";
  private static final String EMPLOYEE_NOT_FOUND = "Employee not found";

  
  /** 
   * Global Exception handler that provides clean response with custom message
   * for the EmployeeNotFoundException execetion
   * @param exception
   * @return ResponseEntity<Object>
   */
  @ExceptionHandler(value = EmployeeNotFoundException.class)
  public ResponseEntity<Object> exception(EmployeeNotFoundException exception) {
     return new ResponseEntity<>(EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND);
  }

  
  /** 
   * Global Exeption handler that provides clean response
   * with custom message for other unexpected RuntimeExceptions
   * @param exception
   * @return ResponseEntity<Object>
   */
  @ExceptionHandler(value = RuntimeException.class)
  public ResponseEntity<Object> exception(RuntimeException exception) {
     return new ResponseEntity<>(UNEXPECTED_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}