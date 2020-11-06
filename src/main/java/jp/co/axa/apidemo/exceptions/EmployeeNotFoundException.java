package jp.co.axa.apidemo.exceptions;

/* 
  Custom Exception class thrown when
  invalid user id is provided for processing
*/
public class EmployeeNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;
}