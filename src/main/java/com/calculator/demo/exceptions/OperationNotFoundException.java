package com.calculator.demo.exceptions;

public class OperationNotFoundException extends Exception{

  private final static String MESSAGE_EXCEPTION = "Operation not found";

  public OperationNotFoundException() {
    super(MESSAGE_EXCEPTION);
  }

}
