package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="Note Already Found Exception")
public class EmployeeAlreadyExistsException extends Exception{

}
