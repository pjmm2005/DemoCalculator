package com.calculator.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestBaseException extends ResponseStatusException {

  public RestBaseException(HttpStatus status) {
    super(status);
  }

  public RestBaseException(HttpStatus status, String reason) {
    super(status, reason);
  }

  public RestBaseException(HttpStatus status, String reason, Throwable cause) {
    super(status, reason, cause);
  }

}
