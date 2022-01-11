package com.calculator.demo.exceptions;

import org.springframework.http.HttpStatus;

public class RestOperationNotFoundException extends RestBaseException {

  private static final HttpStatus customHttpStatus = HttpStatus.NOT_FOUND;

  private final static String MESSAGE_EXCEPTION = "Operation not found";

  public RestOperationNotFoundException() {
    super(customHttpStatus, MESSAGE_EXCEPTION);
  }

  public RestOperationNotFoundException(String reason) {
    super(customHttpStatus, reason);
  }

  public RestOperationNotFoundException(String reason, Throwable cause) {
    super(customHttpStatus, reason, cause);
  }

}
